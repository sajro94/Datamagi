package yatzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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
        scene.getStylesheets().add("stylesheet.css"); // Gets the stylesheet
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private Yatzy yatzy = new Yatzy(); // The Yatzy game object

    // Node objects for GUI.
    private ToggleButton[] btnValues;
    private Button btnRoll;

    private Label[] lblResults;
    private ToggleButton[] btnResults;

    private Label lblBonus;
    private Button btnBonus;

    private Label lblTotal;
    private Button btnTotal;

    // Arrays to hold values;
    private boolean[] holds; // Checks if you hold the buttons
    private int[] results; // Array to save the results from getPossibleResults in Yatzy.
    private String[] scoreName = { "1", "2", "3", "4", "5", "6", "1 pair", "2 pair", "3 of a kind", "4 of a kind",
            "Full House", "Little Straight", "Big Straight", "Chance", "Yatzy" };

    // Fields to save scores and if bonus is given.
    private int bonusCheck = 0;
    private int totalScore = 0;
    private boolean bonusGiven = false;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // Initialize our nodes and arrays
        holds = new boolean[] { false, false, false, false, false };
        btnValues = new ToggleButton[5];
        btnRoll = new Button("Roll(3)");

        btnResults = new ToggleButton[15];
        lblResults = new Label[15];

        lblTotal = new Label("Total");
        btnTotal = new Button("0");

        lblBonus = new Label("Bonus");
        btnBonus = new Button("0");

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // Make dice buttons.
        for (int i = 0; i < 5; i++) {
            int index = i;
            btnValues[i] = new ToggleButton("-");
            btnValues[i].setPrefSize(40, 40);
            btnValues[i].setFont(new Font(16));
            btnValues[i].setOnAction(event -> valueButtonAction(index));
            btnValues[i].setDisable(true);
            dicePane.add(btnValues[i], i, 0);
        }

        // Make roll button.
        btnRoll.setMaxWidth(Integer.MAX_VALUE);
        btnRoll.setOnAction(event -> rollDicesAction());
        btnRoll.setFont(new Font(16));
        btnRoll.setPrefHeight(40);
        dicePane.add(btnRoll, 0, 1, 5, 1);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");

        // Make result buttons and labels.
        for (int i = 0; i < btnResults.length; i++) {
            int index = i;
            btnResults[i] = new ToggleButton("-");
            btnResults[i].setPrefSize(60, 30);
            btnResults[i].setId("notScored");
            btnResults[i].setOnAction(Event -> scorePointsAction(index));
            btnResults[i].setDisable(true);
            lblResults[i] = new Label(scoreName[i]);

            // Make a space for bonus.
            if (i > 5) {
                scorePane.add(btnResults[i], 1, i + 1);
                scorePane.add(lblResults[i], 0, i + 1);
            } else {
                scorePane.add(btnResults[i], 1, i);
                scorePane.add(lblResults[i], 0, i);
            }

        }

        // Sets preset buttons (Bonus and Total)
        btnBonus.setPrefSize(60, 30);
        btnBonus.setDisable(true);
        btnBonus.setId("scored");

        btnTotal.setPrefSize(60, 30);
        btnTotal.setDisable(true);
        btnTotal.setId("scored");

        scorePane.add(lblBonus, 0, 6);
        scorePane.add(btnBonus, 1, 6);
        scorePane.add(lblTotal, 0, 16);
        scorePane.add(btnTotal, 1, 16);
    }

    /**
     * Rolls the dice.
     */
    private void rollDicesAction() {
        toggleDieButtons(false);
        yatzy.throwDice(holds);
        int[] values = yatzy.getValues();

        // Sets values of the dice
        for (int i = 0; i < btnValues.length; i++) {
            btnValues[i].setText(values[i] + "");
        }

        // Checks if you have rolled 3 times.
        if (yatzy.getThrowCount() == 3) {
            showResults();
            toggleDieButtons(true);
            btnRoll.setDisable(true);
            toggleResultButtons(false);
        }

        // Sets the text on roll button to have the remaining amount of throws
        btnRoll.setText(String.format("Roll(%s)", 3 - yatzy.getThrowCount()));
    }

    /**
     * Changes the holds of "Die".
     *
     * @param index
     *            is which index the hold needs to change.
     */
    private void valueButtonAction(int index) {
        if (holds[index]) {
            holds[index] = false;
        } else {
            holds[index] = true;
        }
    }

    /**
     * Method for scoring points.
     */
    private void scorePointsAction(int index) {
        // Sets variables
        totalScore += results[index];

        // Check if scoring a 1-6 and gives bonus if acquired.
        if (index < 6) {
            bonusCheck += results[index];
            if (bonusCheck >= 63 && bonusGiven == false) {
                totalScore += 50;
                bonusGiven = true;
                btnBonus.setText("50");
            }
        }

        // Changes visuals.
        btnTotal.setText("" + totalScore);
        btnResults[index].setId("scored");
        toggleRollButton();
        toggleResultButtons(true);
        btnResults[index].setDisable(true);

        // Checks if everything is scored so you can reset game.
        if (allScored()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Game Finished");
            alert.setHeaderText(String.format("%s points", totalScore));
            alert.setContentText(String.format(
                    "You finished the game scoring %s points.%nYou scored %s points in 1's through 6's this was %s to give 50 bonus points.",
                    totalScore, bonusCheck, bonusCheck >= 63 ? "enough" : "not enough"));

            btnRoll.setText("Reset Game");
            btnRoll.setOnAction(event -> resetGameAction());
            alert.showAndWait();
        }
    }

    /**
     * Resets the game.
     */
    private void resetGameAction() {
        // Changes variables.
        bonusGiven = false;
        bonusCheck = 0;
        totalScore = 0;

        for (int i = 0; i < 15; i++) {
            btnResults[i].setText("-");
            btnResults[i].setId("notScored");
            btnResults[i].setSelected(false);
            if (i < 5) {
                btnValues[i].setText("-");
            }
        }

        /**
         * Changes visuals & action back to roll.
         */
        btnBonus.setText("0");
        btnTotal.setText("0");
        btnRoll.setText("Roll(3)");
        toggleRollButton();
        toggleDieButtons(true);
        toggleResultButtons(true);
        btnRoll.setOnAction(Event -> rollDicesAction());
    }

    /**
     * Gets the possible results for scoring.
     */
    private void showResults() {
        results = yatzy.getPossibleResults();

        for (int i = 0; i < btnResults.length; i++) {
            if (!btnResults[i].isSelected()) {
                btnResults[i].setText("" + results[i]);
            }
        }
    }

    /**
     * Toggles die buttons between enabled and disabled.
     *
     * @param b
     *            is true or false for on and off
     */
    private void toggleDieButtons(boolean b) {
        for (int i = 0; i < btnValues.length; i++) {
            btnValues[i].setDisable(b);
            if (b) {
                btnValues[i].setSelected(false);
                holds[i] = false;
            }
        }
    }

    /**
     * Toggles result buttons between enabled and disabled.
     *
     * @param b
     *            is a value of true or false for on and off.
     */
    private void toggleResultButtons(boolean b) {
        for (int i = 0; i < btnResults.length; i++) {
            if (!btnResults[i].isSelected()) {
                btnResults[i].setDisable(b);
            }
        }
    }

    /**
     * Toggles roll button between enabled and disabled.
     */
    private void toggleRollButton() {
        yatzy.resetThrowCount();
        btnRoll.setText("Roll(3)");
        btnRoll.setDisable(false);
    }

    /**
     * Checks if everything is scored. <br>
     * Returns true if everything is scored and false if not.
     */
    private boolean allScored() {

        for (ToggleButton b : btnResults) {
            if (!b.isSelected()) {
                return false;
            }
        }
        return true;
    }
}
