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
import com.google.gson.JsonElement;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		System.out.println("Test");
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Combine Names");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		try {
			System.out.println(new File(".").getCanonicalPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stage.setScene(scene);
		stage.show();
	}

	private Controller controller = new Controller();
	private Character character = new Character("Test Character");

	private TextArea txaInfo;
	private TextField txfChoice;
	private Button btnChsArchetype;
	private Button btnChsClass;
	private Button btnChsSkills;
	private Button btnShowCharacter;
	private Button btnSetLvl;
	private TextField txfLevel;
	private Label lblChoice;
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
		txaInfo = new TextArea();
		txaInfo.setEditable(false);
		txaInfo.setMinHeight(160);
		txaInfo.setMinWidth(320);
		pane.add(txaInfo, 0, 0, 4, 1);
		// Label to indicate choice field
		lblChoice = new Label("Choice");
		pane.add(lblChoice, 0, 1);
		// TextField for choice
		txfChoice = new TextField();
		pane.add(txfChoice, 1, 1, 3, 1);
		// Button to show and choose Class
		btnChsClass = new Button("Show Classes");
		pane.add(btnChsClass, 1, 2);
		// Button to show and choose Archetype
		btnChsArchetype = new Button("Show Archetypes");
		pane.add(btnChsArchetype, 2, 2);
		// Button to show and choose skills
		btnChsSkills = new Button("Show Skills");
		pane.add(btnChsSkills, 3, 2);
		// Button to show and choose race
		btnChsRace = new Button("Show Races");
		pane.add(btnChsRace, 4, 2);
		// Button to show features
		btnShowCharacter = new Button("Show Character");
		pane.add(btnShowCharacter, 2, 3);
		// Textfield to set and show level
		txfLevel = new TextField("1");
		txfLevel.setStyle("");
		pane.add(txfLevel, 0, 3);
		// Button to change level
		btnSetLvl = new Button("Set Level");
		pane.add(btnSetLvl, 0, 2);
		// Button to save to file
		btnSave = new Button("Save");
		pane.add(btnSave, 1, 4);
		btnChsSkills.setOnAction(event -> this.controller.chooseSkillsAction());
		btnChsClass.setOnAction(event -> this.controller.chooseClassAction());
		btnChsArchetype.setOnAction(event -> this.controller.chooseArchetypeAction());
		btnChsRace.setOnAction(event -> this.controller.chooseRaceAction());
		btnShowCharacter.setOnAction(event -> this.controller.showCharacterAction());
		btnSetLvl.setOnAction(event -> this.controller.setLevelAction());
		btnSave.setOnAction(event -> this.controller.saveFile());

	}

	private class Controller {
		private Database d = new Database();
		private Die d4 = new Die("d4", 1, 4);
		private Die d6 = new Die("d6", 1, 6);
		private Die d8 = new Die("d8", 1, 8);
		private Die d10 = new Die("d10", 1, 10);
		private Die d12 = new Die("d12", 1, 12);
		private Die d20 = new Die("d20", 1, 20);
		private Die d100 = new Die("d100", 1, 100);
		private Ability streng = new Ability("Strength");
		private Ability dexter = new Ability("Dexterity");
		private Ability consti = new Ability("Constitution");
		private Ability intell = new Ability("Intelligence");
		private Ability wisdom = new Ability("Wisdom");
		private Ability charis = new Ability("Charisma");

		public void saveFile() {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			ArrayList<String> lines = new ArrayList<>();
			JsonElement tree = gson.toJsonTree(character);
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

		private boolean showClasses = false;
		private boolean showArchtypes = false;
		private boolean showSkills = false;
		private boolean showRaces = false;

		private void createVighter() {
			Class c1 = new Class("Vighter", d10, streng, dexter, 2);
			Feature f1 = new Feature("Fighting Style",
					"Choose a fighting Style from the following:\nArchery\nDefense\nDueling\nGreat Weapon Fighting\nProtection\nTwo-Weapon Fighting",
					1);
			Feature f2 = new Feature("Second Wind", "Use a bonus action to heal for 1d10+Vighter Level hp", 1);
			Feature f3 = new Feature("Maneuvers",
					"Your learn two maneuvers, plus one additional at 3rd, 7th, 10th, 15th, 18th", 2);
			Feature f4 = new Feature("Action Surge", "Gain the use of an extra Action and possible Bonus Action", 2);
			Feature f5 = new Feature("Martial Archetype", "Choose your archetype", 3);
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
			c1.addFeature(f5);
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

		private void chooseClassAction() {
			if (showClasses) {
				int choice = Integer.parseInt(txfChoice.getText());
				if (choice <= d.getClasses().size()) {
					txaInfo.setText("You chose a class");
					character.setCharClass(d.getClasses().get(choice - 1));
				}
				btnChsClass.setText("Show Classes");
				showClasses = false;
			} else {
				showClasses = true;
				String content = "";
				int i = 1;
				for (Class c : this.d.getClasses()) {
					content += i + ". " + c.getName() + "\n";
					i++;
				}
				btnChsClass.setText("Choose Class");
				txaInfo.setText(content);
			}

		}

		private void chooseArchetypeAction() {
			if (showArchtypes) {
				int choice = Integer.parseInt(txfChoice.getText());
				ArrayList<Archetype> testList = character.getCharClass().getArchetypes();
				if (choice <= testList.size()) {
					txaInfo.setText("You chose an archetype");
					character.setArchetype(testList.get(choice - 1));
				}
				showArchtypes = false;
				btnChsArchetype.setText("Show Archetypes");
			} else {
				String content = "";
				int i = 1;
				for (Archetype a : character.getCharClass().getArchetypes()) {
					content += i + ". " + a.getName() + "\n";
					i++;
				}
				txaInfo.setText(content);
				btnChsArchetype.setText("Choose Archetype");
				showArchtypes = true;
			}
		}

		private void chooseSkillsAction() {
			if (showSkills) {
				ArrayList<Skill> testList = character.getCharClass().getSkillList();
				String choice = txfChoice.getText().trim();
				String[] choices = choice.split(",");
				for (String s : choices) {
					int test = Integer.parseInt(s);
					if (test <= testList.size()) {
						character.addSkill(testList.get(test - 1));
					}
				}
				showSkills = false;
				btnChsSkills.setText("Show Skills");
			} else {
				String content = "";
				int i = 1;
				for (Skill s : character.getCharClass().getSkillList()) {
					content += i + ". " + s.getName() + "\n";
					i++;
				}
				content += String.format("As your input give a comma seperated list of %s numbers.%n",
						character.getCharClass().getSkills());
				txaInfo.setText(content);
				showSkills = true;
				btnChsSkills.setText("Choose skills");
			}
		}

		public void chooseRaceAction() {
			if (showRaces) {
				int choice = Integer.parseInt(txfChoice.getText());
				ArrayList<Race> testList = d.getRaces();
				if (choice <= testList.size()) {
					txaInfo.setText("You chose a race");
					character.setRace(testList.get(choice - 1));
				}
				btnChsRace.setText("Show Races");
				showRaces = false;
			} else {
				String content = "";
				int i = 1;
				for (Race r : d.getRaces()) {
					content += i + ". " + r.getName() + "\n";
					i++;
				}
				txaInfo.setText(content);
				btnChsRace.setText("Choose Race");
				showRaces = true;
			}
		}

		private void showCharacterAction() {
			String content = String.format("Name: %s%nClass: %s%nLevel: %s%n%nFeatures:%n%s%n", character.getName(),
					character.getCharClass().getName(), character.getLevel(), character.featuresToString());
			content += String.format("Proficiencies: %n%s%n", character.skillsToString());
			txaInfo.setText(content);
		}

		private void setLevelAction() {
			int lvl = Integer.parseInt(txfLevel.getText());
			character.setLevel(lvl);
		}
	}

}
