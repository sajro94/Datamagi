package Opgave2Target;

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
        int ring = 30;
        int x = 200;
        int y = 200;
        Circle ring5 = new Circle(x, y, 5 * ring);
        ring5.setFill(Color.BLACK);
        Circle ring4 = new Circle(x, y, 4 * ring);
        ring4.setFill(Color.WHITE);
        Circle ring3 = new Circle(x, y, 3 * ring);
        ring3.setFill(Color.BLACK);
        Circle ring2 = new Circle(x, y, 2 * ring);
        ring2.setFill(Color.WHITE);
        Circle ring1 = new Circle(x, y, ring);
        ring1.setFill(Color.BLACK);
        pane.getChildren().addAll(ring5, ring4, ring3, ring2, ring1);
    }
}
