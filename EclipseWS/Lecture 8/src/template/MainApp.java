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

	private void texter(GraphicsContext gc, String text, int x, int y) {
		int i = 0;
		int offset = 0;
		int off = 10;
		while (i < text.length()) {
			i++;
			gc.fillText(text.substring(0, i), x, y + offset);
			offset += off;
		}
	}

	private void ellipses(int x, int y, GraphicsContext gc, int lines) {
		int h = 30;
		int l = 15;
		int off = 10;
		while (l <= off * lines) {
			gc.strokeOval(x - l, y - h, l * 2, h * 2);
			l += off;
		}
	}

	private void cone(int sX, int sY, GraphicsContext gc, int minR, int maxR) {
		int off = 10;
		int r = minR;
		while (r <= maxR) {
			gc.strokeOval(sX, sY - r, r * 2, r * 2);
			r += off;
		}
	}

	private void incCircles(int x, int y, GraphicsContext gc, int lines) {
		int off = 20;
		int r = off;
		while (r <= off * lines) {
			gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
			r += off;
		}
	}

	private void incLines(GraphicsContext gc, int lines) {
		int midX = 100;
		int l = 20;
		int y = 20;
		int off = 20;
		int offset = 0;
		while (offset <= off * (lines - 1)) {
			gc.strokeLine(midX - l / 2, y + offset, midX + l / 2, y + offset);
			l += off;
			offset += off;
		}
	}

	private void verLines(int x, int y, GraphicsContext gc, int lines) {
		int ex = 100;
		int off = 20;
		int offset = 0;
		while (offset <= off * (lines - 1)) {
			gc.strokeLine(x, y + offset, ex, y + offset);
			offset += off;
		}
	}

	private void horLines(int x, int y, GraphicsContext gc, int lines) {
		int eY = 10;
		int off = 20;
		int offset = 0;
		while (offset <= off * (lines - 1)) {
			gc.strokeLine(x + offset, y, x + offset, eY);
			offset += off;
		}
	}

	private void arrowHead(int x, int y, GraphicsContext gc) {
		int l = 20;
		int h = 4;
		gc.strokeLine(x, y, x + l, y - h);
		gc.strokeLine(x, y, x + l, y + h);
	}

	private void arrowRHead(int x, int y, GraphicsContext gc) {
		int l = 10;
		int h = 5;
		gc.strokeLine(x, y, x - l, y - h);
		gc.strokeLine(x, y, x - l, y + h);
	}

	private void fan(int x, int y, int lines, GraphicsContext gc) {
		int eX = 0;
		int eY = 0;
		int offset = 0;
		int off = 25;
		while (offset <= off * (lines - 1)) {
			gc.strokeLine(x, y, eX + offset, eY);
			offset += off;
		}
	};

}
