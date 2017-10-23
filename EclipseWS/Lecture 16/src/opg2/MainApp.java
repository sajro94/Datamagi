package opg2;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Gui Demo TextArea");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	Button btnAdd;
	TextField txfName;
	TextField txfTitle;
	CheckBox chkSenior;
	ListView<Person> lstPeople;
	ArrayList<Person> people;

	private void initContent(GridPane pane) {
		people = new ArrayList<>();

		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);
		Label lblName = new Label("Name:");
		pane.add(lblName, 0, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 0);
		Label lblTitle = new Label("Title:");
		pane.add(lblTitle, 0, 1);
		txfTitle = new TextField();
		pane.add(txfTitle, 1, 1);
		chkSenior = new CheckBox("Senior");
		pane.add(chkSenior, 0, 2);
		btnAdd = new Button("Add Person");
		pane.add(btnAdd, 2, 2);
		Label lblPpl = new Label("People:");
		lstPeople = new ListView<>();
		pane.add(lstPeople, 1, 2);
		btnAdd.setOnAction(event -> addPersonAction());
	}

	private void addPersonAction() {
		Person temp = new Person(txfTitle.getText().trim(), txfName.getText().trim(), chkSenior.isSelected());
		people.add(temp);
		lstPeople.getItems().add(temp);
	}

	public static void main(String[] args) {
		Application.launch(args);

	}

}
