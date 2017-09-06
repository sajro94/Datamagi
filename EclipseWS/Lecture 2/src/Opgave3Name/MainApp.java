package Opgave3Name;

import java.util.concurrent.TimeUnit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
        Double x = 50.00;
        Double y = 50.00;
        Text name = new Text("Flemming Heidemann Pedersen");
        name.setX(x);
        double width = name.getLayoutBounds().getWidth() + 10;
        double height = name.getLayoutBounds().getHeight() + 10;
        name.setY(height / 2 + y);
        Rectangle box = new Rectangle(x - 5, y - 5, width, height);
        box.setFill(null);
        box.setStroke(Color.DARKCYAN);
        box.setStrokeWidth(2.5);
        pane.getChildren().addAll(name, box);
    }
}
