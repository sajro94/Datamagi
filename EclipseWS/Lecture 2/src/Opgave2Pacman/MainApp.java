package Opgave2Pacman;

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
        Circle body = new Circle(100, 100, 100);
        Circle eye = new Circle(100, 75, 5);
        Polygon mouth = new Polygon(100, 100, 300, 30, 300, 170);
        mouth.setFill(Color.WHITE);
        eye.setFill(Color.WHITE);
        body.setFill(Color.ORANGE);
        pane.getChildren().addAll(body, eye, mouth);
    }
}
