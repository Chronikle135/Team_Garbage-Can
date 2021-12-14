package at.acfhcampus.stud.team_garbagecan;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.Color;



import java.io.IOException;

public class Main extends Application{

    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
         */

        Group root = new Group();
        Scene scene = new Scene(root, 960, 590);
        stage.setResizable(false);
        stage.setTitle("Garbage-Clicker");

        Text text = new Text();
        text.setText("GARBAGE-CLICKER");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));


        Image icon = new Image("/at/acfhcampus/stud/team_garbagecan/garbage-can.png");
        stage.getIcons().add(icon);



        root.getChildren().add(text);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
