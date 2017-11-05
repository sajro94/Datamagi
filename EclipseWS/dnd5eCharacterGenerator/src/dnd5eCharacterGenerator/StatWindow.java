package dnd5eCharacterGenerator;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import statChoosers.Chooser;
import statChoosers.CustomRoll;
import statChoosers.GamblingDealer;
import statGenerator.*;

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
	private ChoiceBox<Chooser> chbxChoosers;
	private Button btnGenerate;
	private Button btnChoose;
	private int[] stats;

	private void initContent(GridPane pane) {
		chbxGenerator = new ChoiceBox<>();
		populateGeneratorList();
		pane.add(chbxGenerator, 0, 0);
		chbxChoosers = new ChoiceBox<>();
		populateChooserList();
		pane.add(chbxChoosers, 1, 0);
		btnGenerate = new Button("Generate Stats");
		pane.add(btnGenerate, 0, 1);
		btnChoose = new Button("Choose Stats");
		pane.add(btnChoose, 1, 1);

		btnGenerate.setOnAction(event -> generateAction());
		btnChoose.setOnAction(event -> chooseAction());

	}

	private void generateAction() {
		Generator temp = chbxGenerator.getSelectionModel().getSelectedItem();
		temp.generate();
		stats = temp.getStats();
	}

	private void chooseAction() {
		Chooser temp = chbxChoosers.getSelectionModel().getSelectedItem();
		temp.showAndWait();
		stats = temp.getStats();
	}

	private void populateChooserList() {
		chbxChoosers.getItems().add(new GamblingDealer(this, "Custom Annotation Roller"));
	}

	private void populateGeneratorList() {
		chbxGenerator.getItems().add(new EpicCardGen());
		chbxGenerator.getItems().add(new Roll2x3d6_dl1());
		chbxGenerator.getItems().add(new Roll3d6());
		chbxGenerator.getItems().add(new Roll4d6dl1());
		chbxGenerator.getItems().add(new StandardArray());
		chbxGenerator.getItems().add(new StandardCardGen());
	}

}
