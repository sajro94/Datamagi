package gui;

import application.model.Conference;
import application.model.Hotel;
import application.model.Trip;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ConferenceInfoView extends Stage {

	private Conference conference;

	public ConferenceInfoView(Stage owner, Conference conference) {
		this.conference = conference;
		initOwner(owner);
		initStyle(StageStyle.DECORATED);
		initModality(Modality.APPLICATION_MODAL);
		setMinHeight(100);
		setMinWidth(300);
		setResizable(false);

		setTitle("Conference View");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		setScene(scene);
	}

	// -----Labels-----
	Label lblHotels = new Label("Hotels");
	Label lblTrips = new Label("Trips");
	// -----ListViews-----
	ListView<Hotel> lvwHotels = new ListView<>();
	ListView<Trip> lvwTrips = new ListView<>();
	// -----Buttons-----
	Button btnHotel = new Button("Tilføj Hotel");
	Button btnTrip = new Button("Tilføj Udflugt");

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);
		// -----Initialize ListViews-----
		updateListViews();
		// -----Pane placement-----
		pane.add(lblHotels, 0, 0);
		pane.add(lblTrips, 1, 0);
		pane.add(lvwHotels, 0, 1);
		pane.add(lvwTrips, 1, 1);
		pane.add(btnHotel, 0, 2);
		pane.add(btnTrip, 1, 2);
		// -----Button Events-----
		btnHotel.setOnAction(event -> createHotelAction());
		btnTrip.setOnAction(event -> createTripAction());
	}

	public void createHotelAction() {
		HotelListView hlvw = new HotelListView(this);
		hlvw.showAndWait();
		if (hlvw.getHotels() != null) {
			for (Hotel h : hlvw.getHotels()) {
				conference.addHotel(h);
			}
		}
		updateListViews();
	}

	public void createTripAction() {
		TripCreateView tcvw = new TripCreateView(this);
		tcvw.showAndWait();
		if (tcvw.getTrip() != null) {
			conference.addTrip(tcvw.getTrip());
		}
		updateListViews();
	}

	private void updateListViews() {
		lvwTrips.getItems().setAll(conference.getTrips());
		lvwHotels.getItems().setAll(conference.getHotels());
	}
}
