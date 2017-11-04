package dnd5eCharacterGenerator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import statGenerator.DieRoller;

public class GamblingDealerWindow extends Stage {

	public GamblingDealerWindow(Stage owner, String title) {
		initOwner(owner);
		initStyle(StageStyle.DECORATED);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(200);
		setResizable(false);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	private Button btnGenerate;
	private ToggleButton[][] btnScores;

	private void initContent(GridPane pane) {

		btnScores = new ToggleButton[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				btnScores[i][j] = new ToggleButton("" + DieRoller.dieRoller(1, 6, 4, 1));
				pane.add(btnScores[i][j], i, j);
				btnScores[i][j].setPrefSize(30, 30);
			}
		}

	}

}
