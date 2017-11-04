package dnd5eCharacterGenerator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import statGenerator.Generator;

public class StatWindow extends Stage {

	public StatWindow(Stage owner, String title) {
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

	private ChoiceBox<Generator> chbxGenerator;
	private ChoiceBox<Stage> chbxChoosers;
	private Button btnGenerate;
	private Button btnChoose;

	private void initContent(GridPane pane) {
		// TODO Auto-generated method stub

	}

}
