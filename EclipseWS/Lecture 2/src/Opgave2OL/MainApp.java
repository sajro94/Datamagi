package Opgave2OL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
        int R = 50;
        Double T = 8.00;
        int off = 55;
        Color fill = null;
        Circle ring1 = new Circle(60, 60, R);
        Circle ring2 = new Circle(60 + off, 60 + off, R);
        Circle ring3 = new Circle(60 + 2 * off, 60, R);
        Circle ring4 = new Circle(60 + 3 * off, 60 + off, R);
        Circle ring5 = new Circle(60 + 4 * off, 60, R);
        ring1.setFill(fill);
        ring1.setStroke(Color.BLUE);
        ring1.setStrokeWidth(T);
        ring2.setFill(fill);
        ring2.setStroke(Color.YELLOW);
        ring2.setStrokeWidth(T);
        ring3.setFill(fill);
        ring3.setStroke(Color.BLACK);
        ring3.setStrokeWidth(T);
        ring4.setFill(fill);
        ring4.setStroke(Color.GREEN);
        ring4.setStrokeWidth(T);
        ring5.setFill(fill);
        ring5.setStroke(Color.RED);
        ring5.setStrokeWidth(T);
        pane.getChildren().addAll(ring1, ring2, ring3, ring4, ring5);
    }
}
