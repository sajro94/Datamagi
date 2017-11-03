package src.yatzy;

import java.util.Random;

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

	private GridPane pane;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		pane = new GridPane();
		initContent(pane);
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("stylesheet.css");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// The Yatzy game object
	private String[] scores = { "1'ere", "2'ere", "3'ere", "4'ere", "5'ere", "6'ere", "Par", "To Par", "Tre Ens",
			"Fire Ens", "Fuldt Hus", "Lille Straight", "Stor Straight", "Chance", "Yatzy" };
	private Yatzy yatzy = new Yatzy();
	// Shows the face values of the 5 dice.
	private Button[] btnValues;
	// Shows the hold status of the 5 dice.
	private Label[] lblScores;
	private Button[] btnScores;
	private Button btnTotal;
	private Label lblBonus;
	private Button btnBonus;
	private Button btnRoll;

	private boolean[] holds;
	private boolean[] scored;
	private int[] scoresScored = new int[15];

	private void initContent(GridPane pane) {
		btnValues = new Button[5];
		holds = new boolean[] { false, false, false, false, false };
		scored = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false,
				false, false, false };
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		for (int i = 0; i < btnValues.length; i++) {
			btnValues[i] = new Button("-");
			btnValues[i].setPrefSize(40, 40);
			btnValues[i].setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 16));
			btnValues[i].setId("roll");
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
		// dicePane.setStyle("-fx-border-color: black");

		// TODO: initialize txfValues, chbHolds, btnRoll and lblRolled

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		lblScores = new Label[15];
		btnScores = new Button[15];
		for (int i = 0; i < 15; i++) {
			int index = i;
			lblScores[i] = new Label(scores[i]);
			btnScores[i] = new Button("0");
			btnScores[i].setId("open");
			btnScores[i].setPrefWidth(40);
			btnScores[i].setPrefHeight(25);
			btnScores[i].setDisable(true);
			btnScores[i].setOnAction(event -> scorePointsAction(index));
			if (i > 5) {
				scorePane.add(lblScores[i], 0, i + 1);
				scorePane.add(btnScores[i], 1, i + 1);
			} else {
				scorePane.add(lblScores[i], 0, i);
				scorePane.add(btnScores[i], 1, i);
			}
		}
		lblBonus = new Label("Bonus");
		btnBonus = new Button("0");
		btnBonus.setDisable(true);
		btnBonus.setId("scored");
		scorePane.add(lblBonus, 0, 6);
		scorePane.add(btnBonus, 1, 6);
		Label lblTotal = new Label("Total");
		btnTotal = new Button("0");
		btnTotal.setDisable(true);
		btnTotal.setId("scored");
		btnTotal.setPrefSize(40, 25);
		btnBonus.setPrefSize(40, 25);
		scorePane.add(lblTotal, 0, 16);
		scorePane.add(btnTotal, 1, 16);

		// TODO: Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
	}

	private void scorePointsAction(int index) {
		btnScores[index].setDisable(true);
		btnScores[index].setId("scored");
		scored[index] = true;
		scoresScored[index] = Integer.parseInt(btnScores[index].getText());
		updateTotal();
		closeScoring();
		if (allScored()) {
			btnRoll.setOnAction(event -> resetGame());
			btnRoll.setText("Reset Game");
		}
	}

	private void resetGame() {
		for (int i = 0; i < 15; i++) {
			scored[i] = false;
			btnScores[i].setId("open");
			btnScores[i].setText("0");
			scoresScored[i] = 0;
			if (i < 5) {
				btnValues[i].setText("-");
			}
		}
		updateTotal();
		btnRoll.setOnAction(event -> rollDices());
		btnRoll.setText(String.format("Roll(%s)", 3));
	}

	private boolean allScored() {
		for (boolean b : scored) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	private void updateTotal() {
		int total = 0;
		int bonus = 0;
		for (int i : scoresScored) {
			total += i;
		}
		int bonusCheck = 0;
		for (int i = 0; i < 6; i++) {
			bonusCheck += scoresScored[i];
		}
		if (bonusCheck >= 63) {
			bonus += 50;
			total += 50;
		}
		btnTotal.setText("" + total);
		btnBonus.setText("" + bonus);

	}

	private void rollDices() {
		openHolds();
		yatzy.throwDice(holds);
		int[] values = yatzy.getValues();
		Random r = new Random();

		for (int i = 0; i < values.length; i++) {
			btnValues[i].setText(values[i] + "");
		}

		btnRoll.setText(String.format("Roll(%s)", 3 - yatzy.getThrowCount()));
		if (yatzy.getThrowCount() == 3) {
			btnRoll.setDisable(true);
			showPossibleResults();
			openScoring();
			closeHolds();
		}
	}

	private void openHolds() {
		for (int i = 0; i < 5; i++) {
			btnValues[i].setDisable(false);
		}
	}

	private void closeHolds() {
		for (int i = 0; i < 5; i++) {
			btnValues[i].setDisable(true);
			btnValues[i].setId("roll");
			holds[i] = false;
		}
	}

	private void openScoring() {
		for (int i = 0; i < 15; i++) {
			if (!scored[i]) {
				btnScores[i].setDisable(false);
			}
		}
	}

	private void closeScoring() {
		for (int i = 0; i < 15; i++) {
			btnScores[i].setDisable(true);
		}
		yatzy.resetThrowCount();
		btnRoll.setText(String.format("Roll(%s)", 3 - yatzy.getThrowCount()));
		btnRoll.setDisable(false);
	}

	private void showPossibleResults() {
		int[] results = yatzy.getPossibleResults();
		for (int i = 0; i < 15; i++) {
			if (!scored[i]) {
				btnScores[i].setText("" + results[i]);
			}
		}
	}

	private void valueButtonAction(int index) {
		if (holds[index]) {
			btnValues[index].setId("roll");
			holds[index] = false;
		} else {
			btnValues[index].setId("hold");
			holds[index] = true;
		}
	}

	// -------------------------------------------------------------------------

	// TODO: Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.

	// -------------------------------------------------------------------------

	// TODO: Create a method for mouse click on one of the text fields in
	// txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.

}
