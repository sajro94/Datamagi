package opg2;

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

	private TextField txfOne;
	private TextField txfTwo;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		txfOne = new TextField();
		pane.add(txfOne, 0, 0, 2, 1);
		txfTwo = new TextField();
		pane.add(txfTwo, 0, 1, 2, 1);
		Button btnSwap = new Button("Swap");
		pane.add(btnSwap, 0, 2);
		btnSwap.setOnAction(event -> swapAction());
	}

	private void swapAction() {
		String temp = this.txfOne.getText().trim();
		this.txfOne.setText(txfTwo.getText().trim());
		this.txfTwo.setText(temp);
	}
}
