package extbp;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

	private ArrayList<Disability> annoyings;
	private ArrayList<Disability> minors;
	private ArrayList<Disability> majors;
	private ListView<Disability> lstMinors;
	private ListView<Disability> lstMajors;
	private ListView<Disability> lstAnnoyings;
	private ArrayList<ArrayList<Disability>> lists;

	@Override
	public void start(Stage primaryStage) throws Exception {
		lists = new ArrayList<>();
		generateMinors();
		generateMajors();
		generateAnnoyings();
		lists.add(minors);
		lists.add(majors);
		lists.add(annoyings);
		primaryStage.setTitle("Tabs");
		Group root = new Group();
		Scene scene = new Scene(root, 400, 550, Color.WHITE);

		TabPane tabPane = new TabPane();

		BorderPane borderPane = new BorderPane();

		// __________________________________________
		Tab tabMain = new Tab("Main");
		Tab tabMin = new Tab("Minor");
		lstMinors = new ListView<>();
		lstMinors.getItems().setAll(minors);
		changeLstFont(lstMinors);
		GridPane minPane = new GridPane();
		minPane.add(lstMinors, 0, 0);
		tabMin.setContent(minPane);

		// __________________________________________
		Tab tabMaj = new Tab("Major");
		lstMajors = new ListView<>();
		lstMajors.getItems().setAll(majors);
		changeLstFont(lstMajors);
		GridPane majPane = new GridPane();
		majPane.add(lstMajors, 0, 0);
		tabMaj.setContent(majPane);

		// __________________________________________
		Tab tabAnn = new Tab("Annoying");
		lstAnnoyings = new ListView<>();
		lstAnnoyings.getItems().setAll(annoyings);
		changeLstFont(lstAnnoyings);
		GridPane annPane = new GridPane();
		annPane.add(lstAnnoyings, 0, 0);
		tabAnn.setContent(annPane);

		// __________________________________________
		Tab[] tabs = { tabMain, tabMin, tabMaj, tabAnn };
		for (int i = 0; i < tabs.length; i++) {
			tabs[i].setClosable(false);
		}
		tabPane.getTabs().addAll(tabs);

		// bind to take available space
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());

		borderPane.setCenter(tabPane);
		root.getChildren().add(borderPane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private <T> void changeLstFont(ListView<T> lvW) {
		lvW.setCellFactory(cell -> {
			return new ListCell<T>() {
				@Override
				protected void updateItem(T item, boolean empty) {
					super.updateItem(item, empty);
					if (item != null) {
						setText(item.toString());
						setFont(Font.font("Monospaced"));
					}
				}
			};
		});
	}

	private void generateMinors() {
		minors = new ArrayList<>();
		String[] names = { "Partial Blindness/Deafness", "Weak", "Slow", "Fragile", "Addiction" };
		int[] values = { 3, 2, 2, 2, 3 };
		DisabilityTable minorAllergens = generateMinorAllergens();
		for (int i = 0; i < 5; i++) {
			minors.add(new Disability(names[i], values[i], ""));
		}
		minors.add(minorAllergens);

	}

	private void generateMajors() {
		majors = new ArrayList<>();
		String[] names = { "Phobia of Inanimate object", "Phobia of Magic", "Phobia of Animate Object",
				"Phobia of Creature", "Missing Limb", "Blind", "Deaf", "Mute", "Exhausted", "Addiction" };
		int[] values = { 5, 5, 5, 5, 7, 7, 7, 7, 5, 7 };
		DisabilityTable majorAllergens = generateMajorAllergens();
		for (int i = 0; i < names.length; i++) {
			majors.add(new Disability(names[i], values[i], ""));
		}
		majors.add(majorAllergens);
	}

	private void generateAnnoyings() {
		annoyings = new ArrayList<>();
		String[] names = { "Grotesque", "Clumsy", "Vacuum Cleaner", "Dursleyish", "Sedentary", "Truthful", "Inatentive",
				"Sherlock?", "Good Cop", "Clueless", "Butcher", "Cityslicker", "Unobservant", "Tone Deaf", "Faithless",
				"Oh Craps", "Orange Ninja", "Gryll" };
		String[] descs = { "Persuasion", "Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History",
				"Insight", "Intimidateion", "Investigation", "Medicine", "Nature", "Peception", "Perfomance",
				"Religion", "Sleight of Hand", "Stealth", "Survival" };
		for (int i = 0; i < names.length; i++) {
			annoyings.add(new Disability(names[i], 2, descs[i]));
		}
	}

	private DisabilityTable generateMajorAllergens() {
		String[] names = { "Nuts", "Fur", "Leather", "Metals", "Fabrics", "Trees", "Feathres", "Mold/fungus", "Oil",
				"Pixie Dust", "Slime(oozes)", "Acid", "Poison", "Meat", "Undead", "Dragons", "Water", "Nothing",
				"Potions" };
		int[] values = { 7, 7, 7, 7, 7, 7, 7, 9, 9, 10, 10, 10, 10, 10, 12, 12, 14, 0, 20 };
		int[] weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		DisabilityTable allergens = new DisabilityTable("Allergy", -2, "");
		for (int i = 0; i < 19; i++) {
			allergens.addDisability(weights[i], new Disability(names[i], values[i], ""));
		}
		return allergens;
	}

	private DisabilityTable generateMinorAllergens() {
		String[] names = { "Nuts", "Fur", "Leather", "Metals", "Fabrics", "Trees", "Feathres", "Mold/fungus", "Oil",
				"Pixie Dust", "Slime(oozes)", "Acid", "Poison", "Meat", "Undead", "Dragons", "Water", "Nothing",
				"Potions" };
		int[] values = { 2, 2, 2, 2, 2, 2, 2, 3, 3, 5, 5, 5, 5, 5, 6, 6, 7, 0, 10 };
		int[] weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		DisabilityTable allergens = new DisabilityTable("Allergy", -2, "");
		for (int i = 0; i < 19; i++) {
			allergens.addDisability(weights[i], new Disability(names[i], values[i], ""));
		}
		return allergens;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
