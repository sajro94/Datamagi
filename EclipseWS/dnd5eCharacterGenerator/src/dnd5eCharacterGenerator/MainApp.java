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
import javafx.scene.control.TextField;
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
			// TODO Auto-generated catch block
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
		// private Die d4 = new Die("d4", 1, 4);
		// private Die d6 = new Die("d6", 1, 6);
		// private Die d8 = new Die("d8", 1, 8);
		private Die d10 = new Die("d10", 1, 10);
		// private Die d12 = new Die("d12", 1, 12);
		// private Die d20 = new Die("d20", 1, 20);
		// private Die d100 = new Die("d100", 1, 100);
		private Ability streng = new Ability("Strength");
		private Ability dexter = new Ability("Dexterity");
		private Ability consti = new Ability("Constitution");
		private Ability intell = new Ability("Intelligence");
		private Ability wisdom = new Ability("Wisdom");
		private Ability charis = new Ability("Charisma");

		public void saveFile() {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ArrayList<String> lines = new ArrayList<>();
			lines.add(gson.toJson(character));
			Path file = Paths.get("test.json");
			try {
				Files.write(file, lines, Charset.forName("UTF-8"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public Controller() {
			createVighter();
		}

		private void createVighter() {
			Class c1 = new Class("Vighter", d10, streng, dexter, 2);
			OptionFeature f1 = new OptionFeature("Fighting Style", "", 1);
			Feature f1o1 = new Feature("Archery", "+2 attack when making an attack with a ranged weapon.", 1);
			Feature f1o2 = new Feature("Defense", "+1 armor class while wearing armor", 1);
			Feature f1o3 = new Feature("Dueling",
					"+2 damage when hitting with a melee weapon wielded in one hand, and you have no weapon in the other hand.",
					1);
			Feature f1o4 = new Feature("Great Weapons Fighting",
					"When you deal damage with a melee weapon, you wield in two hands, you can reroll 1's and 2's, the weapon must have the two-handed or versatile property",
					1);
			Feature f1o5 = new Feature("Protection",
					"While wielding a shield you can as a reaction grant disadvantage on an attack roll against an ally within 5 feet.",
					1);
			Feature f1o6 = new Feature("Two-Weapon Fighting",
					"When dual wielding you can add your ability modifier to the damage of the off hand attack.", 1);
			ArrayList<Choice> fiStl = new ArrayList<>();
			fiStl.add(f1o1);
			fiStl.add(f1o2);
			fiStl.add(f1o3);
			fiStl.add(f1o4);
			fiStl.add(f1o5);
			fiStl.add(f1o6);
			f1.setChoices(fiStl);

			Feature f2 = new Feature("Second Wind", "Use a bonus action to heal for 1d10+Vighter Level hp", 1);
			Feature f3 = new Feature("Maneuvers",
					"Your learn two maneuvers, plus one additional at 3rd, 7th, 10th, 15th, 18th", 2);
			Feature f4 = new Feature("Action Surge", "Gain the use of an extra Action and possible Bonus Action", 2);
			OptionFeature f5 = new OptionFeature("Martial Archetype", "Choose your archetype", 3);
			Feature f6 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 4);
			Feature f7 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 8);
			Feature f8 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 12);
			Feature f9 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 16);
			Feature f10 = new Feature("ABSI", "Gain +1 to two stats, +2 to one stat, or a feat", 19);
			Feature f11 = new Feature("Extra Attack",
					"When you use your Attack action you may attack twice rather than once.", 5);
			Feature f12 = new Feature("Extra Attack",
					"When you use your Attack action you may attack three times rather than once.", 11);
			Feature f13 = new Feature("Extra Attack",
					"When you use your Attack action you may attack four times rather than once.", 20);
			Feature f14 = new Feature("Indomitable", "You can reroll a saving throw once per long rest.", 9);
			Feature f15 = new Feature("Indomitable", "You can reroll a saving throw twice per long rest.", 13);
			Feature f16 = new Feature("Indomitable", "You can reroll a saving throw three times per long rest.", 17);
			f11.setImprovement(f12);
			f12.setImprovement(f13);
			f14.setImprovement(f15);
			f15.setImprovement(f16);

			c1.addFeature(f1);
			c1.addFeature(f2);
			c1.addFeature(f3);
			c1.addFeature(f4);
			c1.addFeature(f6);
			c1.addFeature(f7);
			c1.addFeature(f8);
			c1.addFeature(f9);
			c1.addFeature(f10);
			c1.addFeature(f11);
			c1.addFeature(f14);

			Archetype a1 = new Archetype("Survivalist");
			Feature af1 = new Feature("Ranger of the Wild",
					"Choose three of the following options:\nForager\nStrider\nTracker\nTrapper\nTrainer\nTraveler", 3);
			Feature af2 = new Feature("Hunter's Quarry", "You can mark a target to deal extra damage on attacks", 3);
			Feature af3 = new Feature("Wilderness Guide", "You can travel in the wild better than anyone", 7);
			Feature af4 = new Feature("Hide in Plain Sight", "You can hide even when not completely hidden", 10);
			Feature af5 = new Feature("Stand Against the Tide", "You can grant disadvantage on some attacks", 15);
			Feature af6 = new Feature("Sicth Sense", "You can fight against hidden and even invisible creatures", 18);
			a1.addFeature(af1);
			a1.addFeature(af2);
			a1.addFeature(af3);
			a1.addFeature(af4);
			a1.addFeature(af5);
			a1.addFeature(af6);

			c1.addArchetype(a1);
			ArrayList<Choice> artps = new ArrayList<>();
			artps.add(a1);
			f5.setChoices(artps);
			c1.addFeature(f5);

			Skill s1 = new Skill("Acrobatics", "Make amazing acrobatics!", dexter);
			Skill s2 = new Skill("Animal Handling", "Train and handle animals", wisdom);
			Skill s3 = new Skill("Ahtletics", "Jump and climb", streng);
			Skill s4 = new Skill("History", "Knowledge about the past", intell);
			Skill s5 = new Skill("Insight", "Knowing when people are lying", wisdom);
			Skill s6 = new Skill("Intimidation", "Coercing people to do what you want", charis);
			Skill s7 = new Skill("Perception", "Your awareness of your surroundings", wisdom);
			Skill s8 = new Skill("Survival", "Your ability to travel in the wild", wisdom);

			c1.addSkill(s1);
			c1.addSkill(s2);
			c1.addSkill(s3);
			c1.addSkill(s4);
			c1.addSkill(s5);
			c1.addSkill(s6);
			c1.addSkill(s7);
			c1.addSkill(s8);

			d.addClass(c1);

			Race r1 = new Race("Lizardfolk");
			Feature rf1 = new Feature("Bite",
					"Your fanged maw is a natural weapon which you are proficient with. It deals 1d6 points of piercing damage.",
					0);
			Feature rf2 = new Feature("Cunning Artisan",
					"During a short rest you can create simple equipment from dead creatures.", 0);
			Feature rf3 = new Feature("Hold Breath", "You can hold your breath for 15 minutes.", 0);
			Feature rf4 = new Feature("Hunters Lore",
					"You are proficient in two of: Animal Handling, Nature, Perception, Stealth or Survival", 0);
			Feature rf5 = new Feature("Natural Amor(13+Dex)",
					"You have a natural armor of 13 + your Dexterity modifier.", 0);
			Feature rf6 = new Feature("Hungry Jaws",
					"Once per short rest you can as a bonus action make an attack with your bite, and gain temporary hitpoints equal to your Constitution modifier.",
					0);
			Feature rf7 = new Feature("Languages", "You speak, read and write Common and Draconic", 0);

			r1.addFeature(rf1);
			r1.addFeature(rf2);
			r1.addFeature(rf3);
			r1.addFeature(rf4);
			r1.addFeature(rf5);
			r1.addFeature(rf6);
			r1.addFeature(rf7);

			r1.addAbsi(consti, 2);
			r1.addAbsi(wisdom, 1);

			d.addRace(r1);

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
