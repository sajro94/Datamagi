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
	private ArrayList<Ability> abilities;
	private Feature feature;
	private ArrayList<Feature> features;

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
		if (lstChoices.getSelectionModel().getSelectedItems().size() != 0) {
			Object choiceClass = lstChoices.getSelectionModel().getSelectedItems().get(0).getClass();
			ObservableList<Choice> obsOptions = lstChoices.getSelectionModel().getSelectedItems();

			if (choiceClass.equals(Archetype.class)) {
				arch = (Archetype) lstChoices.getSelectionModel().getSelectedItem();
				hide();
			} else if (choiceClass.equals(Feature.class)) {
				ArrayList<Feature> features = multiList(obsOptions);
				if (features.size() == limit || !multi) {
					this.features = features;
					hide();
				}
			} else if (choiceClass.equals(Skill.class)) {
				ArrayList<Skill> skills = multiList(obsOptions);
				if (skills.size() == limit) {
					this.skills = skills;
					hide();
				}
			} else if (choiceClass.equals(Ability.class)) {
				ArrayList<Ability> abs = multiList(obsOptions);
				if (abs.size() <= limit) {
					if (abs.size() == 1) {
						abs.get(0).setScore(2);
					} else {
						for (int j = 0; j < abs.size(); j++) {
							abs.get(j).setScore(1);
						}
					}
					this.abilities = abs;
					hide();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private <T extends Choice> ArrayList<T> multiList(ObservableList<Choice> choices) {
		ArrayList<T> list = new ArrayList<>();
		for (Choice c : choices) {
			list.add((T) c);
		}
		return list;
	}

	public void setChoices(ArrayList<Choice> choices) {
		lstChoices.getItems().setAll(choices);
	}

	public Archetype getArch() {
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

	public ArrayList<Skill> getSkills() {
		return this.skills;
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public ArrayList<Feature> getFeatures() {
		return features;
	}

}
