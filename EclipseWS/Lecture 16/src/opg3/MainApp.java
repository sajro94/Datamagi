package opg3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gui Demo TextArea");
		GridPane pane = new GridPane();
		initContent(pane);

		personWindow = new PersonInputWindow("Create Person", primaryStage);
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	Button btnAdd;
	ListView<Person> lstPeople;
	ArrayList<Person> people;
	PersonInputWindow personWindow;

	private void initContent(GridPane pane) {
		people = new ArrayList<>();

		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		btnAdd = new Button("Add Person");
		pane.add(btnAdd, 0, 0);
		new Label("People:");
		lstPeople = new ListView<>();
		pane.add(lstPeople, 1, 0);
		btnAdd.setOnAction(event -> addPersonAction());
	}

	private void addPersonAction() {
		personWindow.showAndWait();
		if (personWindow.getActualPerson() != null) {
			lstPeople.getItems().add(personWindow.getActualPerson());
		}
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
