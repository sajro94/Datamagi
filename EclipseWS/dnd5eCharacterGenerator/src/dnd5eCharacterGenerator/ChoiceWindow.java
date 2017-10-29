package dnd5eCharacterGenerator;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChoiceWindow extends Stage {
	private Archetype arch;

	public ChoiceWindow(Stage owner, String title) {
		initOwner(owner);
		initStyle(StageStyle.UTILITY);
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
		System.out.println(lstChoices.getSelectionModel().getSelectedItem().getClass());
		if (lstChoices.getSelectionModel().getSelectedItem().getClass().equals(Archetype.class)) {
			arch = (Archetype) lstChoices.getSelectionModel().getSelectedItem();
		}
	}

	public void setChoices(ArrayList<Choice> choices) {
		lstChoices.getItems().setAll(choices);
	}

	public Archetype getArch() {
		// TODO Auto-generated method stub
		return arch;
	}
}
