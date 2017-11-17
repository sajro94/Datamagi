package gui;

import java.time.LocalDate;

import application.model.Conference;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConferenceCreateView extends Stage {

	private Conference conference;

	public Conference getConference() {
		return conference;
	}

	public ConferenceCreateView(Stage owner) {

		initOwner(owner);
		initStyle(StageStyle.DECORATED);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(300);
		setResizable(false);

		setTitle("Conference Creation");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -----Labels-----
	private Label lblName = new Label("Navn");
	private Label lblLocation = new Label("Sted");
	private Label lblStartDate = new Label("Start Dato");
	private Label lblEndDate = new Label("Slut Dato");
	private Label lblPrice = new Label("Pris");
	// -----TextFields-----
	private TextField txfName;
	private TextField txfLocation;
	private TextField txfPrice;
	// -----Buttons-----
	private Button btnCreate;
	// -----Date Picker-----
	private DatePicker dtpckStart;
	private DatePicker dtpckEnd;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Actual initialization-----
		initTextFields();
		btnCreate = new Button("Opret");
		dtpckEnd = new DatePicker(LocalDate.now());
		dtpckStart = new DatePicker(LocalDate.now());
		pane.add(txfName, 1, 0);
		pane.add(txfLocation, 1, 1);
		pane.add(txfPrice, 1, 2);
		pane.add(dtpckStart, 1, 3);
		pane.add(dtpckEnd, 1, 4);
		pane.add(lblName, 0, 0);
		pane.add(lblLocation, 0, 1);
		pane.add(lblPrice, 0, 2);
		pane.add(lblStartDate, 0, 3);
		pane.add(lblEndDate, 0, 4);
		HBox btnHbox = new HBox();
		pane.add(btnHbox, 0, 5, 2, 1);
		btnHbox.getChildren().add(btnCreate);
		btnHbox.setAlignment(Pos.CENTER);

		btnCreate.setOnAction(event -> createConfAction());

	}

	private void createConfAction() {
		if (allFilledCorrectly()) {
			conference = new Conference(txfName.getText().trim(), txfLocation.getText().trim(), dtpckStart.getValue(),
					dtpckEnd.getValue(), Double.parseDouble(txfPrice.getText().trim()));
			openConferenceInfoView();
		}
	}

	private void openConferenceInfoView() {
		ConferenceInfoView confInfoVw = new ConferenceInfoView(this, conference);
		confInfoVw.showAndWait();
	}

	private boolean allFilledCorrectly() {
		String regexPrice = "^\\d+\\.\\d{2}$";
		boolean tester = true;
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Form Fejl");
		String content = "";
		if (txfLocation.getText().equals("")) {
			tester = false;
			content += String.format("Sted er ikke udfyldt.%n");
		}
		if (txfName.getText().equals("")) {
			tester = false;
			content += String.format("Navn er ikke udfyldt.%n");
		}
		if (!txfPrice.getText().trim().matches(regexPrice)) {
			tester = false;
			content += String.format(
					"Pris er ikke udfyldt, skal skrives som et kommatal med . som komma, maks to cifre efter komma.%n");
		}
		if (!dtpckEnd.getValue().isAfter(dtpckStart.getValue())) {
			tester = false;
			content += String.format("Slutdato skal være senere end startdato.%n");
		}
		if (!tester) {
			alert.setContentText(content);
			alert.showAndWait();
		}
		return tester;
	}

	private void initTextFields() {
		txfName = new TextField();
		txfLocation = new TextField();
		txfPrice = new TextField();
	}

}
