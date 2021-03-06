package Opgave4Kreativ3;

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
        double side = 800;
        int minW = 10;
        double x = 0;
        double y = 0;
        Color color = Color.BLACK;

        Rectangle square = new Rectangle(x, y, side, side);
        square.setFill(color);
        pane.getChildren().add(square);
        square(pane, side / 2, x + side / 2, y, minW, color);
        square(pane, side / 2, x, y + side / 2, minW, color);

    }

    private void square(Pane pane, double side, double x, double y, int minW, Color color) {
        double newSide = side / 2;
        Color newColor = Color.MAGENTA;
        if (color == Color.BLACK) {
            newColor = Color.WHITE;
        } else {
            newColor = Color.BLACK;
        }

        Rectangle square = new Rectangle(x, y, side, side);
        square.setFill(newColor);
        pane.getChildren().add(square);

        if (newSide > minW) {
            square(pane, side / 2, x + side / 2, y, minW, newColor);
            square(pane, side / 2, x, y + side / 2, minW, newColor);
        }

    }

}
