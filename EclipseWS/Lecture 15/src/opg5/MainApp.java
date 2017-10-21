package opg5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Degrees Converter");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private TextField txfC;
	private TextField txfF;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		Label lblC = new Label("C");
		pane.add(lblC, 0, 0);
		txfC = new TextField();
		pane.add(txfC, 1, 0, 2, 1);
		Label lblF = new Label("F");
		pane.add(lblF, 0, 1);
		txfF = new TextField();
		pane.add(txfF, 1, 1, 2, 1);
		Button btnConvertC = new Button("Convert to C");
		pane.add(btnConvertC, 1, 2);
		Button btnConvertF = new Button("Convert to F");
		pane.add(btnConvertF, 2, 2);
		btnConvertC.setOnAction(event -> fToCAction());
		btnConvertF.setOnAction(event -> cToFAction());
	}

	private void cToFAction() {
		double c = Double.valueOf(txfC.getText());
		double f = 9.0 / 5.0 * (double) c + 32.0;
		txfF.setText(String.valueOf(f));
	}

	private void fToCAction() {
		double f = Double.valueOf(txfF.getText());
		double c = (f - 32.0) * 5.0 / 9.0;
		txfC.setText(String.valueOf(c));
	}

}
