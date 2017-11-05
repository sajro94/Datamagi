package statChoosers;

import dnd5eCharacterGenerator.Ability;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import statGenerator.DieRoller;

public class GamblingDealer extends Chooser {

	public GamblingDealer(Stage owner, String title) {
		super(owner, title);
		desc = "A window to gamble with your stats";
		name = "Gambling Dealer";
	}

	private Button btnGenerate;
	private Button btnGamble;
	private Button btnSafe;
	private Label lblScore;
	private TextField txfScore;
	private Label[] lblScores;
	private TextField[] txfScores;

	private int pcScore = 0;
	private int gmScore = 0;

	@Override
	protected void initContent(GridPane pane) {
		btnGenerate = new Button("Generate Next Stat");
		pane.add(btnGenerate, 0, 0);
		lblScore = new Label("Current Stat:");
		pane.add(lblScore, 1, 0);
		txfScore = new TextField();
		txfScore.setDisable(true);
		pane.add(txfScore, 2, 0);
		btnGamble = new Button("Gamble your Stat");
		pane.add(btnGamble, 0, 1);
		btnSafe = new Button("Keep your Stat");
		pane.add(btnSafe, 1, 1);

		GridPane statPane = new GridPane();
		lblScores = new Label[6];
		txfScores = new TextField[6];
		for (int i = 0; i < 6; i++) {
			lblScores[i] = new Label(Ability.ABILITIES[i].getName());
			txfScores[i] = new TextField();
			txfScores[i].setDisable(true);
			statPane.add(lblScores[i], 0, i);
			statPane.add(txfScores[i], 1, i);
		}
		pane.add(statPane, 0, 2);
	}

	@Override
	protected void generateAction() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void generateAction(String annotation) {
		// TODO Auto-generated method stub

	}

}
