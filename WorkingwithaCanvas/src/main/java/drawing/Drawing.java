package drawing;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Drawing extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("Drawing on a Canvas!");
        stage.setScene(getScene());
        stage.show();
    }

    Scene getScene(){
        VBox box = new VBox();

        Canvas canvas = new Canvas(500, 500);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GraphicsContext graphics = canvas.getGraphicsContext2D();

                //mouse position
                double x = event.getX();
                double y = event.getY();

                Random random = new Random();

//                //draw line
//                graphics.setStroke(Color.BLUE);
//                graphics.setLineWidth(20);
//                graphics.strokeLine(x,y,random.nextInt(100) - 50,random.nextInt(100) - 50);

//                //drawing a rectangle
//                graphics.setStroke(Color.RED);
//                graphics.setFill(Color.CHARTREUSE);
//                graphics.setLineWidth(2);
//
//                graphics.strokeRect(x, y, 100, 100);
//                graphics.fillRect(x, y, 100, 100);

                //polygon
                graphics.setFill(Color.PINK);
                graphics.fillPolygon(new double[] {x, x + 20, x + 40, x + 30, x + 10},
                        new double[] {y, y - 10, y, y + 10, y + 10}, 5);

            }
        });


        box.getChildren().add(canvas);




        return new Scene(box, 500, 500);
    }
}
