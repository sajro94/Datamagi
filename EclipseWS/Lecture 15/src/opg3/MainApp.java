package opg3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Swap");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfNumber;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(true);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txfNumber = new TextField("15");
		pane.add(txfNumber, 0, 0, 2, 1);

		Button btnUp = new Button("Up");
		Button btnDown = new Button("Down");
		pane.add(btnUp, 0, 1);
		pane.add(btnDown, 1, 1);
		btnUp.setOnAction(event -> modifyAction(1));
		btnDown.setOnAction(event -> modifyAction(-1));
	}

	private void modifyAction(int change) {
		int num = Integer.parseInt(txfNumber.getText().trim());
		num += change;
		txfNumber.setText(String.valueOf(num));
	}

}
