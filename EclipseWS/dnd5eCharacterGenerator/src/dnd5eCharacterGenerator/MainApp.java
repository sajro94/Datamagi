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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

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
	public static Character character = new Character("Test Character");

	public static Stage stage;
	private ListView<Choice> lstChoose;
	private Button btnChsClass;
	private Button btnLvlUp;
	private Button btnSave;
	private Button btnChsRace;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(25));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);
		// TextArea to show information
		lstChoose = new ListView<>();
		lstChoose.setEditable(false);
		lstChoose.setMinHeight(160);
		lstChoose.setMinWidth(320);
		pane.add(lstChoose, 0, 0, 4, 1);
		// Label to indicate choice field
		// Button to show and choose Class
		btnChsClass = new Button("Show Classes");
		pane.add(btnChsClass, 1, 1);
		// Button to show and choose race
		btnChsRace = new Button("Show Races");
		pane.add(btnChsRace, 2, 1);
		// Button to show features
		// Button to level up
		btnLvlUp = new Button("Level Up");
		pane.add(btnLvlUp, 0, 1);
		// Button to save to file
		btnSave = new Button("Save");
		pane.add(btnSave, 1, 3);
		Button btnCharSheet = new Button("Charactersheet");
		pane.add(btnCharSheet, 0, 3);
		btnCharSheet.setOnAction(event -> this.controller.showCharacterSheetAction());
		btnChsClass.setOnAction(event -> this.controller.showClassesAction());
		btnChsRace.setOnAction(event -> this.controller.showRacesAction());
		btnLvlUp.setOnAction(event -> this.controller.setLevelAction());
		btnSave.setOnAction(event -> this.controller.saveFile());

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

		public Controller() {

		}

		private void showCharacterSheetAction() {
			charWindow = new CharacterSheet("Charactersheet", stage, character);
			charWindow.showAndWait();
		}

		private void showClassesAction() {
			lstChoose.getItems().setAll(d.getClasses());
			resetButtons();
			btnChsClass.setText("Choose Class");
			btnChsClass.setOnAction(event -> chooseClassAction());
		}

		private void chooseClassAction() {
			if ((Class) lstChoose.getSelectionModel().getSelectedItem() != null) {
				character.setCharClass((Class) lstChoose.getSelectionModel().getSelectedItem());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Class Selected");
				alert.setContentText(String.format("You selected the %s class.", character.getClassName()));
				alert.setTitle("Class Selected");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Select a Class from the List.");
				alert.setTitle("Selection Missing");
				alert.showAndWait();
			}
		}

		public void showRacesAction() {
			resetButtons();
			lstChoose.getItems().setAll(d.getRaces());
			btnChsRace.setText("Choose Race");
			btnChsRace.setOnAction(event -> chooseRaceAction());
		}

		private void chooseRaceAction() {
			if ((Race) lstChoose.getSelectionModel().getSelectedItem() != null) {
				character.setRace((Race) lstChoose.getSelectionModel().getSelectedItem());
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Race Selected");
				alert.setContentText(String.format("You selected the %s Race.", character.getRaceName()));
				alert.setTitle("Race Selected");
				alert.showAndWait();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("Select a Race from the List.");
				alert.setTitle("Selection Missing");
				alert.showAndWait();
			}
		}

		private void setLevelAction() {
			character.levelUp();

		}

		public void resetButtons() {
			btnChsClass.setText("Show Classes");
			btnChsClass.setOnAction(event -> showClassesAction());
			btnChsRace.setText("Show Races");
			btnChsRace.setOnAction(event -> showRacesAction());
			lstChoose.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		}
	}

}
