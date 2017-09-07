package Opgave2Smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
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
        Circle head = new Circle(200, 200, 100);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        Circle eye1 = new Circle(165, 175, 10);
        eye1.setStroke(Color.BLACK);
        eye1.setFill(Color.WHITE);
        Circle eye2 = new Circle(235, 175, 10);
        eye2.setStroke(Color.BLACK);
        eye2.setFill(Color.WHITE);
        Line mouth = new Line(155, 245, 245, 245);
        pane.getChildren().addAll(head, eye1, eye2, mouth);
    }
}
