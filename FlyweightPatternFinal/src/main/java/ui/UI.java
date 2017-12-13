/*
 * Nicholas Perez and Joshua Hawks
 * 12/09/2017
 * UI.java
 * A UI for the flyweight pattern.
 */

package ui;

import flyweight.Circle;
import flyweight.IShape;
import flyweight.ShapeFactory;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

import java.time.Instant;
import java.util.Random;

/**
 * The UI class that provides the application with a GUI for the user
 * to interact with the application.
 *
 * @author Nicholas Perez & Joshua Hawks
 * @version 1.0
 */
public class UI extends Application{

    private static final int WINDOW_WIDTH_AND_HEIGHT = 600;
    private File file = songSwitch(sceneNames.HOME);
    private Stage stage;
    private Media media;
    private MediaPlayer player;

    //Used to assign how many circles need to be made.
    private int iteration = 20;

    //Used to select the scenes in the application.
    private enum sceneNames{

        HOME,
        GAMELOOP,
        CREDITS
    }

    //Used to help assign colors to the shapes.
    private String[] shapeColors = {"red", "green", "blue", "yellow", "purple"};

    //An inner class to help work with the inner parts of the events.
    private class FadeSwitch{
        private int index;

        /**
         * Constructor.
         */
        public FadeSwitch(){
            index = 0;
        }

        /**
         * A method for incrementing the index.
         */
        public void incrementByOne(){
            index++;
        }

        /**
         * Gets the index value.
         *
         * @return Returns the index value for arrays.
         */
        public int getIncrementation(){
            return index;
        }
    }

    /**
     * A method for starting the application.
     *
     * @param stage A stage parameter for working with the scenes and loading them for
     *              the application to display them to the user.
     */
    @Override
    public void start(Stage stage){

        this.stage = stage;

        stage.setTitle("Flyweight Pattern");
        stage.getIcons().add(new Image("flyweight_logo.png"));
        stage.setScene(startingScene());
        stage.show();

        //plays the music.
        mediaPlayer(file);

    }

    //A method to help with setting the correct song for the media player.
    private void mediaPlayer(File mediaFile){
        media = new Media(mediaFile.toURI().toString());
        player = new MediaPlayer(media);
        player.setCycleCount(MediaPlayer.INDEFINITE);
        player.setVolume(0.5);
        player.play();
    }

    //Starting view.
    private Scene startingScene(){
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setSpacing(10);
        box.getStylesheets().add("FlyweightCSS.css");

        Text title = new Text("Light Flies");
        title.getStyleClass().add("title");

        Button enter = new Button("Enter");

        enter.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event){
                player.stop();
                mediaPlayer(file = songSwitch(sceneNames.GAMELOOP));
                stage.setScene(gameLoop(iteration));
            }
        });

        box.getChildren().addAll(title, enter);

        return new Scene(box, WINDOW_WIDTH_AND_HEIGHT, WINDOW_WIDTH_AND_HEIGHT);
    }

    //A simple switch for changing up the music file.
    private File songSwitch(sceneNames currentScene){
        File file = null;

        switch(currentScene){
            case HOME:
                file = new File("bgm/04 A Deus.mp3");
                break;

            case GAMELOOP:
                file = new File("bgm/05 - naruto's daily life.mp3");
                break;

            case CREDITS:
                file = new File("bgm/03 Tribute.mp3");


        }
        return file;
    }

    //A scene for drawing the actual circle shapes.
    private Scene gameLoop(int iterations){

        String methodTimer = null;

        VBox box = new VBox();
        VBox header = new VBox();
        VBox body = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getStylesheets().add("FlyweightCSS.css");
        box.setSpacing(5);
        header.setAlignment(Pos.CENTER);
        header.setPrefSize(WINDOW_WIDTH_AND_HEIGHT, 50);
        body.setAlignment(Pos.CENTER);
        body.setPrefSize(WINDOW_WIDTH_AND_HEIGHT, 400);

        Canvas canvas = new Canvas(WINDOW_WIDTH_AND_HEIGHT, 300);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        IShape circle;
        Random random = new Random();

        Text title = new Text("Observe the Flyweight");
        title.getStyleClass().add("title");

        Text objectCounter = new Text("Number of Circle Objects: " + iteration);
        Text objectTimer = new Text("");

        Button makeCircles = new Button("Draw");
        Button credits = new Button("Credits");

        makeCircles.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                objectCounter.setText("Number of Circle Objects: " + iteration);
                stage.setScene(gameLoop(iteration = iteration * 2));
            }
        });

        credits.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                player.stop();
                mediaPlayer(file = songSwitch(sceneNames.CREDITS));
                stage.setScene(credits());
            }
        });

        //Gets current system time.
        Instant startTimer = Instant.now();

        //loop for drawing our circles
        for(int i = 0; i < iterations; i++){
            circle = (Circle) ShapeFactory.getCircle(shapeColors[random.nextInt(shapeColors.length)]);
            circle.draw(graphics);
        }

        //Get current system time for end timer
        Instant endTimer = Instant.now();

        //Used to make text to show milliseconds or seconds
        if(java.time.Duration.between(startTimer, endTimer).getSeconds() == 0){
            methodTimer = "Milliseconds: " + java.time.Duration.between(startTimer, endTimer).toMillis();
            objectTimer.setText(methodTimer);
        }else{
            methodTimer = "Seconds: " + java.time.Duration.between(startTimer, endTimer).getSeconds();
            objectTimer.setText(methodTimer);
        }


        header.getChildren().add(title);
        body.getChildren().add(canvas);

        box.getChildren().addAll(header, body, objectCounter, objectTimer, makeCircles, credits);

        return new Scene(box, WINDOW_WIDTH_AND_HEIGHT, WINDOW_WIDTH_AND_HEIGHT);
    }

    //Basic credits for the application and project.
    private Scene credits(){

        //Used for indexing in event handling.
        FadeSwitch fadeSwitch = new FadeSwitch();

        final String[] array = {"Thank you for coming", "Developers",
                "Josh Hawks\n&\nNicholas Perez", "Music",
                "A Deus\nby\nNoriyuki Iwadare", "Naruto's Daily Life\nby\nToshio Masuda",
                "Tribute\nby\nTenacious D", "Sources", "DZone\nJournalDev\nOODesign\n" +
                "Game Programming Patterns\nBlackWasp\ntutotialspoint(sorry Josh...)", "The End <(^ ^<) ^(^ ^)^ (> ^ ^)>"};

        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.getStylesheets().add("FlyweightCSS.css");

        Text message = new Text(array[fadeSwitch.getIncrementation()]);
        message.getStyleClass().add("credits");

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(5), message);
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), message);

        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        fadeOut.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){

                fadeSwitch.incrementByOne();
                if(fadeSwitch.getIncrementation() != array.length){
                    message.setText(array[fadeSwitch.getIncrementation()]);
                }else{
                    Platform.exit();
                }

                fadeIn.play();
            }
        });

        fadeIn.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                fadeOut.play();
            }
        });

        fadeOut.play();

        box.getChildren().add(message);

        return new Scene(box, WINDOW_WIDTH_AND_HEIGHT, WINDOW_WIDTH_AND_HEIGHT);
    }
}
