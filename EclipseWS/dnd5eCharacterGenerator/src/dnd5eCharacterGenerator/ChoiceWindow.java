package dnd5eCharacterGenerator;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChoiceWindow extends Stage {
	private Archetype arch;

	public ChoiceWindow(Stage owner, String title) {
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

	private ListView<Choice> lstChoices;
	private Button btnChs;
	private boolean multi = false;
	private int limit = 1;
	private ArrayList<Skill> skills;

	private void initContent(GridPane pane) {
		new ArrayList<>();
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		lstChoices = new ListView<>();
		pane.add(lstChoices, 0, 0);

		btnChs = new Button("Choose");
		pane.add(btnChs, 1, 0);
		btnChs.setOnAction(event -> chooseAction());
	}

	private void chooseAction() {
		if (!multi && lstChoices.getSelectionModel().getSelectedItem() != null) {
			Object choiceClass = lstChoices.getSelectionModel().getSelectedItem().getClass();
			if (choiceClass.equals(Archetype.class)) {
				arch = (Archetype) lstChoices.getSelectionModel().getSelectedItem();
				hide();
			}
		} else if (multi && lstChoices.getSelectionModel().getSelectedItems().size() != 0) {
			Object choiceClass = lstChoices.getSelectionModel().getSelectedItems().get(0).getClass();
			if (choiceClass.equals(Skill.class)) {
				ObservableList<Choice> obsSkills = lstChoices.getSelectionModel().getSelectedItems();
				ArrayList<Skill> skills = new ArrayList<>();
				for (Choice c : obsSkills) {
					skills.add((Skill) c);
				}
				if (skills.size() == limit) {
					this.skills = skills;
					hide();
				}
			}
		}
	}

	public void setChoices(ArrayList<Choice> choices) {
		lstChoices.getItems().setAll(choices);
	}

	public Archetype getArch() {
		// TODO Auto-generated method stub
		return arch;
	}

	public void setMulti(boolean b) {
		multi = b;
		if (b) {
			lstChoices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
