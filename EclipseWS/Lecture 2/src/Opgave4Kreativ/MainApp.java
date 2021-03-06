package Opgave4Kreativ;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
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
        double width = 60;
        int maxx = 15 * (int) width;

        Rectangle first = new Rectangle(0, 0, width, maxx);
        first.setStroke(null);
        first.setFill(null);
        pane.getChildren().add(first);
        halfer(pane, first.getHeight() / 2, width, width, 0, maxx, 1);
    }

    private void halfer(Pane pane, double height, double x, double width, double y, int max, int color) {
        System.out.println(x);
        // Top Rectangle
        Rectangle top = new Rectangle(x, y, width, height);
        switch (color) {
        case 1:
            top.setStroke(Color.FIREBRICK);
            top.setFill(Color.FIREBRICK);
            break;
        case -1:
            top.setStroke(Color.AQUA);
            top.setFill(Color.AQUA);
            break;
        default:
            break;
        }
        double test = x + width;
        if (test < max) {
            halfer(pane, height / 2, x + width, width, y, max, 1);
        }
        if (x >= width * 2) {
            pane.getChildren().add(top);
        }
        // Bottom Rectangle
        Rectangle bottom = new Rectangle(x, y + height, width, height);
        switch (color) {
        case -1:
            bottom.setStroke(Color.FIREBRICK);
            bottom.setFill(Color.FIREBRICK);
            break;
        case 1:
            bottom.setStroke(Color.AQUA);
            bottom.setFill(Color.AQUA);
            break;
        default:
            break;
        }
        if (test < max) {
            halfer(pane, height / 2, x + width, width, y + height, max, -1);
        }
        if (x >= width * 2) {
            pane.getChildren().add(bottom);
        }
    }

}
