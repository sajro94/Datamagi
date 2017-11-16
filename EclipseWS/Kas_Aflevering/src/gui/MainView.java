package gui;

import application.model.Conference;
import application.model.Registration;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import storage.Storage;

public class MainView extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		thisStage = stage;
		stage.setTitle("Conference Administration System");
		GridPane pane = new GridPane();
		initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		// HotelCreateView htl = new HotelCreateView(stage);
		// htl.showAndWait();
		stage.show();

	}

	private ListView<Conference> lstConferences;
	private ListView<Registration> lstRegistrations;
	private TextArea txaConferenceInfo;
	private Button btnCreateConference;
	private Button btnCreateRegistration;
	private Stage thisStage;

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);
		initLstConference();
		pane.add(lstConferences, 0, 0);
		txaConferenceInfo = new TextArea();
		txaConferenceInfo.setDisable(true);
		pane.add(txaConferenceInfo, 1, 0);
		btnCreateConference = new Button("Opret Konference");
		btnCreateRegistration = new Button("Opret Registrering");
		pane.add(btnCreateConference, 0, 1);
		pane.add(btnCreateRegistration, 1, 1);
		pane.add(lstRegistrations, 2, 0);

		btnCreateConference.setOnAction(event -> createConferenceAction());
		btnCreateRegistration.setOnAction(event -> createRegistrationAction());
		lstConferences.selectionModelProperty().addListener(event -> conferencesSelectionAction());
	}

	private Object conferencesSelectionAction() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object createRegistrationAction() {
		// TODO Auto-generated method stub
		return null;
	}

	private void createConferenceAction() {
		ConferenceCreateView confVw = new ConferenceCreateView(thisStage);
		confVw.showAndWait();
	}

	private void initLstConference() {
		lstConferences = new ListView<>();
		lstConferences.getItems().setAll(Storage.getConference());
		lstRegistrations = new ListView<>();
		lstRegistrations.getItems().setAll(Storage.getRegistrations());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
