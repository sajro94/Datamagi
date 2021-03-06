package Opgave2b;

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
        int xOff = 100;
        Color fill = Color.YELLOW;
        Circle circle = new Circle(70 + xOff, 70, 150);
        pane.getChildren().add(circle);
        circle.setFill(fill);
        circle.setStroke(Color.AQUA);
        Rectangle rect = new Rectangle(40 + xOff, 70, 100, 100);
        rect.setFill(fill);
        rect.setStroke(Color.BLACK);
        pane.getChildren().add(rect);
        Line line = new Line(0 + xOff, 0, 200 + xOff, 200);
        line.setStroke(fill);
        line.setStrokeWidth(3.4);
        pane.getChildren().add(line);
    }
}
