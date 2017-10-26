package bhe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Behind the Tables Roller");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	ListView<String> lstTables;
	Button btnSearch;
	TextField txfSearch;
	TextArea txaResult;

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txfSearch = new TextField();
		pane.add(txfSearch, 0, 0, 2, 1);
		btnSearch = new Button("Search");
		pane.add(btnSearch, 2, 0);
		lstTables = new ListView<>();
		pane.add(lstTables, 0, 1);
		txaResult = new TextArea();
		txaResult.setEditable(false);
		pane.add(txaResult, 1, 1);
		createStartList();

	}

	private void createStartList() {
		// TODO Auto-generated method stub

	}

}
