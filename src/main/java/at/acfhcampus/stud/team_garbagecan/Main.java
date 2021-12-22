package at.acfhcampus.stud.team_garbagecan;

import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllverbrennung;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    BigInteger cash = new BigInteger("0");
    final private int TICKRATE = 1000;






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

        Text garbage = new Text(String.format("Amount of Garbage %d", cash));
        garbage.setX(100);
        garbage.setY(100);

        root.getChildren().addAll(text, garbage);
        stage.setScene(scene);
        stage.show();


        //Array mit einem Element dass die große Variabel für die Hauptwährung ist
        Müllverbrennung müllverbrennung = new Müllverbrennung();            //Manuelles erstellen von dem Objekt Müllverbrennung, hat als Werte income, cost, name und amount
        Timer tick = new Timer();                                           //Erstellen eines neuen Timers
        TimerTask getting = new TimerTask() {                               //Erstellen einer TimerTasks, also einer Aufgabe die mit dem Tick eines Timers ausgeführt wird
            @Override
            public void run() {
                cash = cash.add(müllverbrennung.calcincome());              //Berechnung des aktuellen Währungsstandes plus des incomes der Müllverbrennung
                garbage.setText(String.format("Amount of Garbage %d", cash));                                   //Zur Kontrolle ob das ganze funktioniert
            }
        };
        tick.schedule(getting, 0, TICKRATE);                         //Scheduler der einen Timertask ausführ in einer gewissen periodizität. In diesem Fall wird getting ausgeführt ab Zeitpunkt 0 und das alle 1000ms(Tickrate).

    }

    public static void main(String[] args) {
        launch(args);
    }
}
