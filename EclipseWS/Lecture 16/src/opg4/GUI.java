package opg4;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI {

	private String title;
	private ArrayList<String> names;

	public GUI(String title, String[] args) {
		this.title = title;
		names = new ArrayList<>();
	}

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(title);
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private Label lblNames;
	private Label lblName;
	private ListView<String> lstNames;
	private TextField txfName;
	private Button btnAdd;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		names = new ArrayList<>();

		lblNames = new Label("Names:");
		pane.add(lblNames, 0, 0);
		lblName = new Label("Name:");
		pane.add(lblName, 0, 1);
		lstNames = new ListView<>();
		pane.add(lstNames, 1, 0);
		txfName = new TextField();
		pane.add(txfName, 1, 1);
		btnAdd = new Button("Add Name");
		pane.add(btnAdd, 2, 1);
		btnAdd.setOnAction(event -> addNameAction());

	}

	private void addNameAction() {
		if (txfName.getText().trim().equals("")) {
			System.out.println("Add a name!");
		} else {
			names.add(txfName.getText().trim());
			lstNames.getItems().setAll(names);
		}
	}

}
