package Opgave3b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
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
        Line ground = new Line(0, 200, 400, 200);
        ground.setStroke(Color.BLACK);
        Rectangle house = new Rectangle(80, 80, 120, 120);
        house.setStroke(Color.RED);
        house.setFill(Color.RED);
        Polygon roof = new Polygon(60, 80, 140, 20, 220, 80);
        roof.setStroke(Color.GREEN);
        roof.setFill(Color.GREEN);
        Rectangle window = new Rectangle(100, 100, 40, 40);
        window.setStroke(Color.BLACK);
        window.setFill(Color.BLACK);
        Circle sun = new Circle(300, 60, 40);
        sun.setStroke(Color.BLACK);
        sun.setFill(Color.YELLOW);
        Polygon trunk = new Polygon(300, 200, 310, 170, 315, 140, 325, 140, 330, 170, 340, 200);
        trunk.setStroke(Color.BLACK);
        trunk.setFill(Color.BROWN);
        Circle crown = new Circle(320, 140, 30);
        crown.setStroke(Color.DARKGREEN);
        crown.setFill(Color.GREEN);
        pane.getChildren().addAll(ground, house, roof, sun, window, trunk, crown);
    }
}
