package dnd5eCharacterGenerator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CharGen extends Application {

	public static void main(String[] args) {
		System.out.println("Test");
		Application.launch(args);
	}

	@Override
	public void start(Stage primeStage) {
		stage = primeStage;
		stage.setTitle("Character Creator");
		GridPane pane = new GridPane();
		initContent(pane);
		stage.setResizable(false);
		stage.setWidth(600);
		stage.setHeight(300);

		Scene scene = new Scene(pane);
		scene.getStylesheets().add("stylesheet.css");
		try {
			System.out.println(new File(".").getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}

		stage.setScene(scene);
		stage.show();
	}

	private CharacterSheet charWindow;

	private Controller controller = new Controller();
	public static Character character;

	public static Stage stage;
	private TextField txfName;
	private Button btnLvlUp;
	private Button btnSave;
	private Button btnStart;
	private Button btnCharSheet;
	private ChoiceBox<Race> chsBxRace;
	private ChoiceBox<Class> chsBxClass;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(25));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);
		txfName = new TextField();
		pane.add(txfName, 0, 0);
		chsBxClass = new ChoiceBox<>();
		chsBxClass.getItems().setAll(controller.d.getClasses());
		pane.add(chsBxClass, 1, 0);
		chsBxRace = new ChoiceBox<>();
		chsBxRace.getItems().setAll(controller.d.getRaces());
		pane.add(chsBxRace, 2, 0);
		btnStart = new Button("Create Character");
		pane.add(btnStart, 0, 1);

		// Button to level up
		btnLvlUp = new Button("Level Up");
		pane.add(btnLvlUp, 1, 1);
		// Button to save to file
		btnSave = new Button("Save");
		pane.add(btnSave, 3, 1);
		btnCharSheet = new Button("Charactersheet");
		pane.add(btnCharSheet, 2, 1);

		Button btnStatGen = new Button("Stat Gens");
		pane.add(btnStatGen, 3, 3);

		btnLvlUp.setDisable(true);
		btnSave.setDisable(true);
		btnCharSheet.setDisable(true);

		btnStatGen.setOnAction(event -> this.controller.openStatGensAction());
		btnCharSheet.setOnAction(event -> this.controller.showCharacterSheetAction());
		btnLvlUp.setOnAction(event -> this.controller.setLevelAction());
		btnSave.setOnAction(event -> this.controller.saveFile());
		btnStart.setOnAction(event -> this.controller.createCharacter(pane));

	}

	private class Controller {
		private Database d = new Database();

		public void saveFile() {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ArrayList<String> lines = new ArrayList<>();
			lines.add(gson.toJson(character));
			Path file = Paths.get("test.json");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void openStatGensAction() {
			GamblingDealerWindow gdw = new GamblingDealerWindow(stage, "Stat Generator!");
			gdw.showAndWait();
		}

		private Label[] lblAbilities;
		private Label[] lblScores;

		public void createCharacter(GridPane pane) {
			if (!chsBxClass.getSelectionModel().getSelectedItem().equals(null)
					&& !chsBxRace.getSelectionModel().getSelectedItem().equals(null) && !txfName.getText().equals("")) {
				character = new Character(txfName.getText().trim());
				character.setRace(chsBxRace.getSelectionModel().getSelectedItem());
				character.setCharClass(chsBxClass.getSelectionModel().getSelectedItem());
				enableButtons();
				lblAbilities = new Label[character.getAbilities().length];
				lblScores = new Label[character.getAbilities().length];

				GridPane statPane = new GridPane();

				for (int i = 0; i < character.getAbilities().length; i++) {
					lblAbilities[i] = new Label(character.getAbilities()[i].getName());
					lblScores[i] = new Label(String.format("%s(%+d)", character.getAbilities()[i].getScore(),
							character.getAbilities()[i].getMod()));
					lblAbilities[i].setId("cell");
					lblScores[i].setId("cell");
					statPane.add(lblAbilities[i], i, 0);
					statPane.add(lblScores[i], i, 1);
				}
				pane.add(statPane, 0, 3, 4, 1);

			}
		}

		private void updateStats() {
			for (int i = 0; i < character.getAbilities().length; i++) {
				lblAbilities[i].setText(character.getAbilities()[i].getName());
				lblScores[i].setText(String.format("%s(%+d)", character.getAbilities()[i].getScore(),
						character.getAbilities()[i].getMod()));
			}
		}

		private void enableButtons() {
			btnCharSheet.setDisable(false);
			btnLvlUp.setDisable(false);
			btnSave.setDisable(false);
		}

		public Controller() {

		}

		private void showCharacterSheetAction() {
			charWindow = new CharacterSheet("Charactersheet", stage, character);
			charWindow.showAndWait();
		}

		private void setLevelAction() {
			character.levelUp();
			updateStats();
		}

	}

}
