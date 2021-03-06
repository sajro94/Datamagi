package Opgave4Kreativ2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		Pane root = initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Shapes");
		stage.setScene(scene);
		stage.show();
	}

	private Pane initContent() {
		Pane pane = new Pane();
		pane.setPrefSize(1200, 1200);
		drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		double radius = 500;
		int minR = 1;
		int x = 1000;
		int y = 500;
		Rectangle rect = new Rectangle(0, 0, 1920, 1080);
		rect.setFill(new Color(0.2, 0.2, 0.2, 1));
		pane.getChildren().add(rect);

		Circle first = new Circle(x, y, radius);
		first.setFill(Color.AQUAMARINE);
		pane.getChildren().add(first);
		halfer(pane, radius / 2, x, y + radius / 2, minR, "Ver");
		halfer(pane, radius / 2, x, y - radius / 2, minR, "Ver");

	}

	private void halfer(Pane pane, double radius, double x, double y, int minR, String dir) {
		String direction = "None";
		Color fill = Color.AZURE;
		switch (dir) {
		case "Ver":
			direction = "Hor";
			fill = Color.CRIMSON;
			break;
		case "Hor":
			direction = "Ver";
			fill = Color.AQUAMARINE;
			break;
		default:
			break;
		}

		Circle circ = new Circle(x, y, radius);
		circ.setFill(fill);
		pane.getChildren().add(circ);
		double newR = radius / 2;
		if (newR > minR) {
			switch (dir) {
			case "Ver":
				halfer(pane, newR, x, y - radius / 2, minR, direction);
				halfer(pane, newR, x, y + radius / 2, minR, direction);
				break;
			case "Hor":
				halfer(pane, newR, x - radius / 2, y, minR, direction);
				halfer(pane, newR, x + radius / 2, y, minR, direction);
				break;
			default:
				break;
			}
		}

	}

}
