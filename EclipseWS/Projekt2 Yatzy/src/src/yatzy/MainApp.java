package src.yatzy;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		initContent(pane);
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("stylesheet.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// The Yatzy game object
	private Yatzy yatzy = new Yatzy();
	// Shows the face values of the 5 dice.
	private ToggleButton[] btnValues;
	private String[] scoreNames = { "1'ere", "2'ere", "3'ere", "4'ere", "5'ere", "6'ere", "Et Par", "To Par", "Tre Ens",
			"Fire Ens", "Fuldt Hus", "Lille Straight", "Stor Straight", "Chance", "Yatzy" };
	private Button[] btnScores;
	private Label[] lblScores;
	private Label lblBonusName;
	private Label lblTotalName;
	private Label lblBonusScore;
	private Label lblTotalScore;
	private Button btnRoll;
	private int[] results;

	private int bonusCheck = 0;
	private int totalScore = 0;

	// Shows the hold status of the 5 dice.
	private boolean[] holds;
	private boolean[] scored;

	private void initContent(GridPane pane) {
		btnValues = new ToggleButton[5];
		holds = new boolean[] { false, false, false, false, false };
		scored = new boolean[15];
		for (int i = 0; i < 15; i++) {
			scored[i] = false;
		}
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		for (int i = 0; i < btnValues.length; i++) {
			btnValues[i] = new ToggleButton("-");
			btnValues[i].setPrefSize(40, 40);
			btnValues[i].setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 16));
			btnValues[i].setDisable(true);
			int index = i;
			btnValues[i].setOnAction(event -> valueButtonAction(index));
			dicePane.add(btnValues[i], i, 0);
		}
		btnRoll = new Button("Roll(3)");
		btnRoll.setMaxWidth(Integer.MAX_VALUE);
		btnRoll.setPrefHeight(40);
		btnRoll.setFont(new Font(16));
		dicePane.add(btnRoll, 0, 1, 5, 1);
		btnRoll.setOnAction(event -> rollDices());

		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// TODO: initialize txfValues, chbHolds, btnRoll and lblRolled

		// ---------------------------------------------------------------------

		btnScores = new Button[15];
		lblScores = new Label[15];

		GridPane scorePane = new GridPane();
		for (int i = 0; i < 15; i++) {
			int index = i;
			lblScores[i] = new Label(scoreNames[i]);
			btnScores[i] = new Button("0");
			btnScores[i].setPrefSize(40, 25);
			btnScores[i].setId("open");
			btnScores[i].setDisable(true);
			btnScores[i].setOnAction(event -> scoreResultAction(index));
			if (i > 5) {
				scorePane.add(lblScores[i], 0, i + 1);
				scorePane.add(btnScores[i], 1, i + 1);

			} else {
				scorePane.add(lblScores[i], 0, i);
				scorePane.add(btnScores[i], 1, i);
			}
		}
		lblBonusName = new Label("Bonus");
		lblBonusScore = new Label("0");
		lblTotalName = new Label("Total");
		lblTotalScore = new Label("0");
		lblTotalScore.setPrefSize(40, 25);
		scorePane.add(lblBonusName, 0, 6);
		scorePane.add(lblBonusScore, 1, 6);
		scorePane.add(lblTotalName, 0, 16);
		scorePane.add(lblTotalScore, 1, 16);
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");

		// TODO: Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
	}

	private boolean givenBonus = false;

	private void scoreResultAction(int index) {
		if (index < 6) {
			bonusCheck += results[index];
			if (!givenBonus && bonusCheck >= 63) {
				givenBonus = true;
				totalScore += 50;
				lblBonusScore.setText("50");
			}
		}
		totalScore += results[index];
		lblTotalScore.setText("" + totalScore);
		scored[index] = true;
		toggleScoreButtons(true);
		toggleRollButton();
		btnScores[index].setDisable(true);
		btnScores[index].setId("scored");
		if (allScored()) {
			btnRoll.setText("Reset Game");
			btnRoll.setOnAction(event -> resetGameAction());
		}
	}

	private void resetGameAction() {
		for (int i = 0; i < 15; i++) {
			btnScores[i].setText("0");
			btnScores[i].setId("open");
			scored[i] = false;
		}
		lblTotalScore.setText("0");
		lblBonusScore.setText("0");
		totalScore = 0;
		bonusCheck = 0;
		givenBonus = false;

		btnRoll.setOnAction(event -> rollDices());
		toggleRollButton();
		toggleDieButtons(true);
		toggleScoreButtons(true);
	}

	private void rollDices() {
		yatzy.throwDice(holds);
		toggleDieButtons(false);
		int[] values = yatzy.getValues();

		for (int i = 0; i < values.length; i++) {
			btnValues[i].setText(values[i] + "");
		}

		btnRoll.setText(String.format("Roll(%s)", 3 - yatzy.getThrowCount()));
		if (yatzy.getThrowCount() == 3) {
			toggleDieButtons(true);
			btnRoll.setDisable(true);
			toggleScoreButtons(false);
			showResults();
		}
	}

	private void showResults() {
		results = yatzy.getPossibleResults();
		for (int i = 0; i < btnScores.length; i++) {
			if (!scored[i]) {
				btnScores[i].setText("" + results[i]);
			}
		}
	}

	private void toggleRollButton() {
		yatzy.resetThrowCount();
		btnRoll.setText("Roll(3)");
		btnRoll.setDisable(false);
	}

	private void toggleScoreButtons(boolean b) {
		for (int i = 0; i < btnScores.length; i++) {
			if (!scored[i]) {
				btnScores[i].setDisable(b);
			}
		}
	}

	private void toggleDieButtons(boolean b) {
		for (int i = 0; i < btnValues.length; i++) {
			btnValues[i].setDisable(b);
			if (b) {
				btnValues[i].setSelected(false);
				holds[i] = false;
			}
		}

	}

	private void valueButtonAction(int index) {
		if (holds[index]) {
			holds[index] = false;
		} else {
			holds[index] = true;
		}
	}

	private boolean allScored() {
		for (boolean b : scored) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

}
