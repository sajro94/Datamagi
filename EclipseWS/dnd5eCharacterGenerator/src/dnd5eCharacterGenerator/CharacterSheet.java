package dnd5eCharacterGenerator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CharacterSheet extends Stage {

	private Character chara;

	public CharacterSheet(String title, Stage owner, Character c) {
		this.chara = c;
		initOwner(owner);
		initStyle(StageStyle.UTILITY);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(400);
		setMinWidth(800);
		setResizable(true);

		setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	ListView<Feature> lstFeatures;
	ListView<Skill> lstSkills;
	TextArea txaInfo;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(5);
		pane.setVgap(10);
		pane.getStyleClass().add("character-sheet");

		Label lblName = new Label(chara.getName());
		Label lblClassLvl = new Label(String.format("%s(%s) %s", chara.getCharClass().getName(),
				chara.getArchetype().getName(), chara.getLevel()));
		Label lblRace = new Label(chara.getRace().getName());
		lstFeatures = new ListView<>();
		lstFeatures.getItems().setAll(chara.getFeatures());
		lstSkills = new ListView<>();
		lstSkills.getItems().setAll(chara.getSkills());
		txaInfo = new TextArea();
		txaInfo.setEditable(false);
		txaInfo.setWrapText(true);

		pane.add(lblName, 0, 0);
		pane.add(lblRace, 1, 0);
		pane.add(lblClassLvl, 2, 0);
		pane.add(lstFeatures, 0, 1);
		pane.add(lstSkills, 1, 1);
		pane.add(txaInfo, 2, 1);
		lstFeatures.getSelectionModel().selectedItemProperty().addListener(event -> featureListAction());
		lstSkills.getSelectionModel().selectedItemProperty().addListener(event -> skillListAction());

	}

	private void featureListAction() {
		System.out.println("Feature list change");
		Feature temp = lstFeatures.getSelectionModel().getSelectedItem();
		txaInfo.setText(temp.getFullDesc());
	}

	private void skillListAction() {
		Skill temp = lstSkills.getSelectionModel().getSelectedItem();
		txaInfo.setText(temp.getDesc());
	}

}
