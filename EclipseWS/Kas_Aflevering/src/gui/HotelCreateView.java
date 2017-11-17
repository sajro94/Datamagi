package gui;

import java.util.ArrayList;

import application.model.ExtraService;
import application.model.Hotel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.Storage;

public class HotelCreateView extends Stage {
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public HotelCreateView(Stage owner) {
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
	private Label lblName = new Label("Navn");
	private Label lblAdress = new Label("Adresse");
	private Label lblPriceSingle = new Label("Pris, Enkelt");
	private Label lblPriceDouble = new Label("Pris, Dobbelt");
	private Label lblExtras = new Label("Ekstra");
	// -----TextFields-----
	private TextField txfName = new TextField();
	private TextField txfAdress = new TextField();
	private TextField txfPriceSingle = new TextField("500.00");
	private TextField txfPriceDouble = new TextField("600.00");
	// -----ListViews-----
	private ListView<ExtraService> lvwExtras = new ListView<>();
	// -----Buttons-----
	private Button btnAddExtra = new Button("Tilføj Ekstra");
	private Button btnFinishHotel = new Button("Opret Hotel");

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Initialization-----
		lvwExtras.getItems().setAll(new ArrayList<>());
		lvwExtras.setPrefSize(160.0, 90.0);
		// -----Pane placement-----
		pane.add(lblName, 0, 0);
		pane.add(lblAdress, 0, 1);
		pane.add(lblPriceSingle, 0, 2);
		pane.add(lblPriceDouble, 0, 4);
		pane.add(lblExtras, 1, 2);
		pane.add(txfName, 1, 0);
		pane.add(txfAdress, 1, 1);
		pane.add(txfPriceSingle, 0, 3);
		pane.add(txfPriceDouble, 0, 5);
		pane.add(lvwExtras, 1, 3, 1, 3);
		pane.add(btnAddExtra, 1, 6);
		pane.add(btnFinishHotel, 0, 6);
		// -----Button Actions-----
		btnAddExtra.setOnAction(event -> addExtraAction());
		btnFinishHotel.setOnAction(event -> finishHotelAction());
	}

	private void finishHotelAction() {
		if (isAllFilledCorrectly()) {
			String name = txfName.getText().trim();
			String address = txfAdress.getText().trim();
			double priceSingle = Double.parseDouble(txfPriceSingle.getText().trim());
			double priceDouble = Double.parseDouble(txfPriceDouble.getText().trim());
			hotel = new Hotel(name, address, priceDouble, priceSingle);
			hide();
		}
	}

	private boolean isAllFilledCorrectly() {
		boolean allFilledCorrectly = true;
		String contentText = "";
		if (txfName.getText().trim().equals("")) {
			allFilledCorrectly = false;
			contentText += String.format("Navn er ikke udfyldt.%n");
		}
		if (txfAdress.getText().trim().equals("")) {
			allFilledCorrectly = false;
			contentText += String.format("Adresse er ikke udfyldt.%n");
		}
		if (!txfPriceSingle.getText().trim().matches("^\\d+\\.\\d{2}$")) {
			allFilledCorrectly = false;
			contentText += String.format("Pris skal være et komma tal med maks to cifre efter komma(.).%n");
		}
		if (!txfPriceDouble.getText().trim().matches("^\\d+\\.\\d{2}$")) {
			allFilledCorrectly = false;
			contentText += String.format("Pris skal være et komma tal med maks to cifre efter komma(.).%n");
		}
		if (!allFilledCorrectly) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Fejl i udfyldelse");
			alert.setContentText(contentText);
			alert.showAndWait();
		}
		return allFilledCorrectly;
	}

	private void addExtraAction() {
		ExtraAddView eavw = new ExtraAddView(this);
		eavw.showAndWait();
		if (eavw.getExtra() != null) {
			lvwExtras.getItems().add(eavw.getExtra());
		}
	}
}
