package opg1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainAPP extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Combine Names");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfName;
	private TextField txfFirst;
	private TextField txfLast;

	public void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);
		txfName = new TextField();
		pane.add(txfName, 0, 1, 3, 1);
		txfFirst = new TextField();
		pane.add(txfFirst, 0, 0, 1, 1);
		txfLast = new TextField();
		pane.add(txfLast, 2, 0);

		Button btnCombine = new Button("Combine");
		pane.add(btnCombine, 0, 2);
		btnCombine.setOnAction(event -> combineAction());
	}

	private void combineAction() {
		String first = txfFirst.getText().trim();
		String last = txfLast.getText().trim();
		String name = first + " " + last;
		txfName.setText(name);
	}
}
