package at.acfhcampus.stud.team_garbagecan;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllverbrennung;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Upgrades;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {

    private static BigInteger cash = new BigInteger("0");
    final private int TICKRATE = 1000;
    private final int WIDTH = 200 + 200 + 300;
    private final int HEIGHT = 700;
    private int clickingPower = 1;


    /* GUI Elements */
    private HBox containerHBox = new HBox();
    private VBox shopBox = new VBox();
    private VBox trashCanBox = new VBox();
    private VBox leftSideBox = new VBox();
    private VBox finalcontainer = new VBox();
    private HBox banner = new HBox();
    private HBox footer = new HBox();


    public void start(Stage stage) throws IOException {
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
         */

        Image icon = new Image("/at/acfhcampus/stud/team_garbagecan/garbage-can.png");
        stage.getIcons().add(icon);

        Button canButton = new Button();
        canButton.setMinWidth(icon.getWidth() / 2);
        canButton.setMinHeight(icon.getHeight() / 2);
        canButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/garbage-can.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        canButton.setOnMouseClicked(e -> clicki());
        trashCanBox.setSpacing(30);

        Text garbage = new Text();
        garbage.setTextAlignment(TextAlignment.CENTER);
        Text text = new Text();
        text.setText("GARBAGE-CLICKER");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 30));
        garbage.setFont(Font.font("Verdana", 20));

        containerHBox.setMaxHeight(HEIGHT);

        trashCanBox.setAlignment(Pos.CENTER);
        trashCanBox.setMinWidth(300);
        trashCanBox.setPadding(new Insets(20, 10, 20, 10));
        trashCanBox.getChildren().addAll(garbage, canButton);

        shopBox.setMinWidth(200);
        shopBox.getChildren().addAll(new Text("THIS IS THE SHOP TEST, DO NO PANIC"));

        leftSideBox.setMinWidth(200);
        leftSideBox.getChildren().addAll(new Text("THIS IS JUST A TEST, DO NOT PANIC"));

        trashCanBox.setMinHeight(HEIGHT);
        shopBox.setMinHeight(HEIGHT);
        leftSideBox.setMinHeight(HEIGHT);


        /*trashCanBox.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        shopBox.setBackground(new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY)));
        leftSideBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));*/

        containerHBox.getChildren().addAll(leftSideBox, trashCanBox, shopBox);
        finalcontainer.getChildren().addAll(banner, containerHBox,footer);
        Scene mainScene = new Scene(finalcontainer, WIDTH, HEIGHT);
        stage.setResizable(false);
        stage.setTitle("Garbage-Clicker");
        stage.setScene(mainScene);
        stage.show();


        Müllverbrennung müllverbrennung = new Müllverbrennung();                        //Manuelles erstellen von dem Objekt Müllverbrennung, hat als Werte income, cost, name und amount
        Timer tick = new Timer();                                                       //Erstellen eines neuen Timers
        TimerTask getting = new TimerTask() {                                           //Erstellen einer TimerTasks, also einer Aufgabe die mit dem Tick eines Timers ausgeführt wird
            @Override
            public void run() {
                for (Upgrades u : Upgrades.upgradeList) {                               //Berechnung des aktuellen Währungsstandes plus des incomes von jedem Element in der Liste der Upgrades
                    cash = cash.add(u.calcincome());
                }
                garbage.setText(String.format("Amount of Garbage%n%d", cash));           //Zur Kontrolle ob das ganze funktioniert
            }
        };
        tick.schedule(getting, 0, TICKRATE);                                      //Scheduler der einen Timertask ausführ in einer gewissen periodizität. In diesem Fall wird getting ausgeführt ab Zeitpunkt 0 und das alle 1000ms(Tickrate).

    }

    private void clicki() {
        cash = cash.add(BigInteger.valueOf(clickingPower));
    }

    public static BigInteger getCash() {                                                //Getter damit wir uns die Cashvariabel von überall holen können und sie trotzdem noch protected ist
        return cash;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
