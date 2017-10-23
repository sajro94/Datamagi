package opg5;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	static GUI gui;

	public static void main(String[] args) {
		gui = new GUI("Name List", args);
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		gui.start(primaryStage);

	}

}
