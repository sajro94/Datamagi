package gui;

import java.util.ArrayList;

import application.model.Hotel;
import application.service.Service;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import storage.Storage;

public class HotelListView extends Stage {
	private ArrayList<Hotel> hotels;

	public ArrayList<Hotel> getHotels() {
		return hotels;
	}

	public HotelListView(Stage owner) {
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
	Label lblPrevious = new Label("Tidligere Brugte Hoteller");
	// -----ListViews-----
	ListView<Hotel> lvwHotels = new ListView<>();
	// -----Buttons-----
	Button btnAdd = new Button("Tilføj");
	Button btnNew = new Button("Nyt Hotel");

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Initialization-----
		lvwHotels.getItems().setAll(Storage.getHotels());
		lvwHotels.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		// -----Pane placement-----
		pane.add(lblPrevious, 0, 0);
		pane.add(lvwHotels, 0, 1);
		pane.add(btnNew, 0, 2);
		pane.add(btnAdd, 1, 1);
		// -----Button Actions-----
		btnAdd.setOnAction(event -> addHotelsAction());
		btnNew.setOnAction(event -> newHotelAction());
	}

	private void newHotelAction() {
		HotelCreateView hcvw = new HotelCreateView(this);
		hcvw.showAndWait();
		if (hcvw.getHotel() != null) {
			Service.createHotel(hcvw.getHotel());
			lvwHotels.getItems().setAll(Storage.getHotels());
		}
	}

	private void addHotelsAction() {
		hotels = new ArrayList<>();
		for (Hotel h : lvwHotels.getSelectionModel().getSelectedItems()) {
			hotels.add(h);
		}
		hide();
	}
}
