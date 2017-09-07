package Opgave2Heart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
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
        Color fill = Color.RED;
        Color str = Color.RED;
        Circle left = new Circle(100, 100, 89);
        Circle right = new Circle(180, 100, 89);
        Polygon mass = new Polygon(26, 150, 254, 150, 140, 300);
        left.setStroke(str);
        left.setFill(fill);
        right.setStroke(str);
        right.setFill(str);
        mass.setStroke(str);
        mass.setFill(fill);
        pane.getChildren().addAll(left, right, mass);

    }
}
