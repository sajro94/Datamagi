package example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
		pane.setPrefSize(400, 400);
		drawShapes(pane);
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(Pane pane) {
		Circle circle = new Circle(70, 70, 150);
		pane.getChildren().add(circle);
		circle.setFill(Color.DARKGOLDENROD);
		circle.setStroke(Color.AQUA);
		Rectangle rect = new Rectangle(40, 70, 100, 100);
		rect.setFill(Color.AZURE);
		rect.setStroke(Color.BLACK);
		pane.getChildren().add(rect);
		Line line = new Line(0, 0, 200, 200);
		line.setStroke(Color.RED);
		pane.getChildren().add(line);
	}
}
