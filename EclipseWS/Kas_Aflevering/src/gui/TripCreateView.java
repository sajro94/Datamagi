package gui;

import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Trip;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TripCreateView extends Stage {

	private Trip trip;

	public Trip getTrip() {
		return trip;
	}

	public TripCreateView(Stage owner) {
		initOwner(owner);
		initStyle(StageStyle.DECORATED);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(300);
		setResizable(false);

		setTitle("Create Trip");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -----Labels-----
	private Label[] labels = { new Label("Navn"), new Label("Tidspunkt"), new Label("Pris"),
			new Label("Inklusiv Frokost"), new Label("Dato"), new Label("Sted") };
	// -----TextFields-----
	private TextField txfName = new TextField();
	private TextField txfPrice = new TextField();
	private TextField txfLocation = new TextField();
	private TextField txfTime = new TextField();
	// -----CheckBox-----
	private CheckBox chkLunch = new CheckBox();
	// -----DatePicker-----
	private DatePicker dtpDate = new DatePicker(LocalDate.now());
	// -----Controls-----
	private Control[] controls = { txfName, txfTime, txfPrice, chkLunch, dtpDate, txfLocation };
	// -----Buttons-----
	private Button btnCreate = new Button("Opret");

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Initialization-----
		HBox centerBox = new HBox();
		centerBox.getChildren().add(btnCreate);
		centerBox.setAlignment(Pos.CENTER);
		// -----Pane placement-----
		for (int i = 0; i < 6; i++) {
			pane.add(labels[i], 0, i);
			pane.add(controls[i], 1, i);
		}
		pane.add(centerBox, 0, 6, 2, 1);
		// -----Button Actions-----
		btnCreate.setOnAction(event -> createAction());
	}

	public void createAction() {
		if (allFilledCorrectly()) {
			String name = txfName.getText().trim();
			String timeStr = txfTime.getText().trim();
			String[] timePieces = timeStr.split("\\.");
			LocalTime time = LocalTime.of(Integer.parseInt(timePieces[0]), Integer.parseInt(timePieces[1]));
			double price = Double.parseDouble(txfPrice.getText().trim());
			boolean lunch = chkLunch.isSelected();
			String location = txfLocation.getText().trim();
			LocalDate date = dtpDate.getValue();
			trip = new Trip(name, time, price, lunch, location, date);
			hide();
		}
	}

	private boolean allFilledCorrectly() {
		boolean tester = true;
		String content = "";
		if (txfName.getText().trim().equals("")) {
			tester = false;
			content += String.format("Manglende navn.%n");
		}
		if (!txfTime.getText().trim().matches("^\\d{2}\\.\\d{2}$")) {
			tester = false;
			content += String.format("Tid i forkert format. Korrekt eks. 12.45.%n");
		}
		if (!txfPrice.getText().trim().matches("^\\d+\\.\\d{2}$")) {
			tester = false;
			content += String.format("Pris i forkert format. Korrekt eks. 75.00.%n");
		}
		if (txfLocation.getText().trim().equals("")) {
			tester = false;
			content += String.format("Manglende sted.%n");
		}
		if (!tester) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Manglende eller forkert udfyldelse.");
			alert.setContentText(content);
			alert.showAndWait();
		}
		return tester;
	}
}
