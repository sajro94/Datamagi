package opg7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Theater t;

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) {
		t = new Theater();
		stage.setTitle("Degrees Converter");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	private int seatColMax = 0;
	private TextField txfPrice;

	private void initContent(GridPane pane) {
		GridPane secondpane = new GridPane();
		secondpane.setGridLinesVisible(false);
		// set padding of the pane
		secondpane.setPadding(new Insets(20));
		// set horizontal gap between components
		secondpane.setHgap(10);
		// set vertical gap between components
		secondpane.setVgap(10);
		GridPane innerPane = new GridPane();
		pane.add(innerPane, 0, 0);
		pane.add(secondpane, 0, 1);
		generateSeats(innerPane);
		txfPrice = new TextField();
		secondpane.add(txfPrice, 1, 1);
		Label lblPrice = new Label("Price");
		secondpane.add(lblPrice, 0, 1);
		Label lblInfo = new Label(
				"Either click on a seat above\nor input your desired price and click the buy seat below.");
		secondpane.add(lblInfo, 1, 2);
		Button btnBuySeat = new Button("Buy Seat");
		secondpane.add(btnBuySeat, 0, 3);

	}

	private void generateSeats(GridPane pane) {
		for (int i = 0; i < t.getTheater().length; i++) {
			seatColMax++;
			for (int j = 0; j < t.getTheater()[i].length; j++) {
				Button temp = new Button(String.valueOf(t.getTheater()[i][j]));
				pane.add(temp, j, i + 1);
				int row = i;
				int col = j;
				temp.setOnAction(event -> buySeatAction(row, col));
			}
		}
	}

	private void buySeatAction(int row, int col) {
		System.out.println(row + "|" + col);
	}

}
