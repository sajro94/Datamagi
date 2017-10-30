package template;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		GridPane root = initContent();
		Scene scene = new Scene(root);

		stage.setTitle("Loops");
		stage.setScene(scene);
		stage.show();
	}

	private GridPane initContent() {
		GridPane pane = new GridPane();
		Canvas canvas = new Canvas(400, 400);
		pane.add(canvas, 0, 0);
		drawShapes(canvas.getGraphicsContext2D());
		return pane;
	}

	// ------------------------------------------------------------------------

	private void drawShapes(GraphicsContext gc) {
		/*
		 * arrowHead(100, 75, gc); arrowHead(100, 125, gc); arrowHead(20, 50, gc);
		 * fan(100, 100, 9, gc);
		 */
		/*
		 * horLines(10, 100, gc, 5); verLines(10, 10, gc, 5);
		 *
		 * incLines(gc, 5);
		 */

		// incCircles(100, 100, gc, 5);
		// cone(20, 100, gc, 10, 80);
		// ellipses(100, 100, gc, 8);
		// texter(gc, "Datamatiker", 10, 10);
		xAxis(10, 180, 20, 11, gc);

	}

	private void xAxis(int x, int y, int off, int ticks, GraphicsContext gc) {
		gc.strokeLine(x, y, x + off * (ticks + 1), y);
		int th = 5;
		for (int i = 0; i < ticks; i++) {
			if (i % 5 == 0) {
				gc.strokeLine(x + i * off, y - th * 2, x + i * off, y + th * 2);
			} else {
				gc.strokeLine(x + i * off, y - th, x + i * off, y + th);
			}
		}
		arrowRHead(x + (ticks + 1) * off, y, gc);
	}

	private void arrowRHead(int x, int y, GraphicsContext gc) {
		int l = 10;
		int h = 5;
		gc.strokeLine(x, y, x - l, y - h);
		gc.strokeLine(x, y, x - l, y + h);
	}

}
