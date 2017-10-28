package src.yatzy;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// The Yatzy game object
	private Yatzy yatzy = new Yatzy();
	// Shows the face values of the 5 dice.
	private Button[] btnValues;
	// Shows the hold status of the 5 dice.
	private Label[] lblResults;
	private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
	private Label lblRolled;
	private Button btnRoll;

	private boolean[] holds;

	private void initContent(GridPane pane) {
		btnValues = new Button[5];
		holds = new boolean[] { false, false, false, false, false };
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

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");

		// TODO: Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
	}

	private void rollDices() {
		yatzy.throwDice(holds);
		int[] values = yatzy.getValues();
		Random r = new Random();

		for (int i = 0; i < values.length; i++) {
			btnValues[i].setText(values[i] + "");
		}

		btnRoll.setText(String.format("Roll(%s)", 3 - yatzy.getThrowCount()));
		if (yatzy.getThrowCount() == 3) {
			btnRoll.setDisable(true);
		}
	}

	private void localWait(long milis) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() - start < milis) {

		}
	}

	private void valueButtonAction(int index) {
		if (holds[index]) {
			btnValues[index].setStyle("");
			holds[index] = false;
		} else {
			btnValues[index].setStyle("-fx-background-color: darkGrey;");
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
