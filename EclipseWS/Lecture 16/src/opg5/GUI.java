package opg5;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GUI {

	private String title;
	private ArrayList<String> boys;
	private ArrayList<String> girls;
	private ArrayList<String> names;

	public GUI(String title, String[] args) {
		this.title = title;
		boys = new ArrayList<>();
		girls = new ArrayList<>();
		names = this.boys;
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
	private ToggleGroup group;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);

		pane.setPadding(new Insets(20));
		pane.setHgap(20);
		pane.setVgap(10);

		lblNames = new Label("Names:");
		pane.add(lblNames, 0, 1);
		lblName = new Label("Name:");
		pane.add(lblName, 0, 2);
		lstNames = new ListView<>();
		lstNames.setPrefHeight(120);
		pane.add(lstNames, 1, 1);
		txfName = new TextField();
		pane.add(txfName, 1, 2);
		btnAdd = new Button("Add Name");
		pane.add(btnAdd, 2, 2);

		HBox box = new HBox();
		group = new ToggleGroup();
		RadioButton rbb = new RadioButton("Boys");
		rbb.setToggleGroup(group);
		RadioButton rbg = new RadioButton("Girls");
		rbg.setToggleGroup(group);
		rbb.setUserData(true);
		rbg.setUserData(false);
		box.getChildren().addAll(rbb, rbg);
		pane.add(box, 1, 0);
		group.getToggles().get(0).setSelected(true);
		group.selectedToggleProperty().addListener(event -> toggleBoyGirl());
		btnAdd.setOnAction(event -> addNameAction());

	}

	private void toggleBoyGirl() {
		boolean boy = (boolean) group.getSelectedToggle().getUserData();
		if (boy) {
			names = boys;
		} else {
			names = girls;
		}
		lstNames.getItems().setAll(names);
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
