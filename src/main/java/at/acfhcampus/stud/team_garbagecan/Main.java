package at.acfhcampus.stud.team_garbagecan;

import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllabfuhr;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllverbrennung;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Upgrades;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.ÖffentlicheMülltonne;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Upgrade2;
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
    /* Globale Variablen */
    private static BigInteger cash = new BigInteger("0");
    final private int TICKRATE = 1000;
    private final int WIDTH = 200 + 200 + 300;
    private final int HEIGHT = 700;
    private int clickingPower = 1;


    /* GUI Elemente */
    private HBox containerHBox = new HBox();
    private VBox rigthSideBox = new VBox();
    private VBox middleBox = new VBox();
    private VBox leftSideBox = new VBox();
    private VBox finalcontainer = new VBox();
    private HBox banner = new HBox();
    private HBox footer = new HBox();


    public void start(Stage stage) throws IOException {
        /* Objekte und Upggrades die wir brauchen */
        Müllverbrennung müllverbrennung = new Müllverbrennung();                       //Manuelles erstellen von den Objekten, hat als Werte income, cost, name und amount
        Müllabfuhr müllabfuhr = new Müllabfuhr();
        ÖffentlicheMülltonne öffentlicheMülltonne = new ÖffentlicheMülltonne();

        /* GUI Initialisierungen */
        Image icon = new Image("/at/acfhcampus/stud/team_garbagecan/garbage-can.png");
        Text text = new Text();
        Text garbage = new Text();


        /* Texte und ihre Eigenschaften */
        text.setText("GARBAGE-CLICKER");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 30));
        garbage.setFont(Font.font("Verdana", 20));
        garbage.setTextAlignment(TextAlignment.CENTER);


        /* Trashcanbutton */
        Button canButton = new Button();                                              //Erstellen eines neuen Buttons
        canButton.setMinWidth(icon.getWidth() / 2);                                   //Höhe und Breite Variabel machen
        canButton.setMinHeight(icon.getHeight() / 2);                                 //Optische hexereien um dem ganzen ein Icon zuzuweisen und den Hintergrund auszublenden
        canButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/garbage-can.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        canButton.setOnMouseClicked(e -> clicki());                                   //Klickevent beim drücken des Buttons


        /* Boxensystem */

        /* Mittlere Box */
        middleBox.setSpacing(30);
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setMinWidth(300);
        middleBox.setPadding(new Insets(20, 10, 20, 10));
        middleBox.getChildren().addAll(garbage, canButton);
        middleBox.setMinHeight(HEIGHT);

        /* Linke Box */
        leftSideBox.setMinWidth(200);
        leftSideBox.setMinHeight(HEIGHT);
        for (Upgrade2 u : Upgrade2.upgradeList) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            leftSideBox.getChildren().add(u.getShopItem());
        }

        /* Rechte/Shop Box */
        rigthSideBox.setMinWidth(200);
        rigthSideBox.setMinHeight(HEIGHT);
        for (Upgrades u : Upgrades.upgradeList) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            rigthSideBox.getChildren().add(u.getShopItem());
        }

        /* Box in der die mittlere, rechte und linke Box sind */
        containerHBox.setMaxHeight(HEIGHT);
        containerHBox.getChildren().addAll(leftSideBox, middleBox, rigthSideBox);

        /* Fertige Box in der alle anderen drinnen sind */
        finalcontainer.getChildren().addAll(banner, containerHBox, footer);

        /* Einblenden einer Hintergrundfarbe für die 3 zentralen Boxen zum Bugtesten */
        middleBox.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        rigthSideBox.setBackground(new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY)));
        leftSideBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        /* Erstellen und Eigenschafte der Szene */
        Scene mainScene = new Scene(finalcontainer, WIDTH, HEIGHT);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Garbage-Clicker");
        stage.setScene(mainScene);
        stage.show();


        /* Timer und seine Funktionen */
        Timer tick = new Timer();                                                       //Erstellen eines neuen Timers
        TimerTask getting = new TimerTask() {                                           //Erstellen einer TimerTasks, also einer Aufgabe die mit dem Tick eines Timers ausgeführt wird
            @Override
            public void run() {
                for (Upgrades u : Upgrades.upgradeList) {                               //Berechnung des aktuellen Währungsstandes plus des incomes von jedem Element in der Liste der Upgrades
                    cash = cash.add(u.calcincome());
                    u.getShopItem().setVisible(visibility(u));                          //Überprüfung der Sichtbarkeit jedes Upgrades
                }
                garbage.setText(String.format("Amount of Garbage %d", cash.longValue()));
            }
        };
        tick.schedule(getting, 0, TICKRATE);                                      //Scheduler der einen Timertask ausführ in einer gewissen periodizität. In diesem Fall wird getting ausgeführt ab Zeitpunkt 0 und das alle 1000ms(Tickrate).
    }

    /* Funktionen die wir brauchen */
    private void clicki() {                                                             //Klickevent dass bei jedem Klick passiert
        cash = cash.add(BigInteger.valueOf(clickingPower));                             //clickingPower gibt an wie viel Währung man pro Klick bekommt
    }

    public static BigInteger getCash() {                                                //Getter damit wir uns die Cashvariabel von überall holen können und sie trotzdem noch protected ist
        return cash;
    }

    public static boolean visibility(Upgrades irgendwas) {                              //Boolean der uns sagt ob ein Upgrade sichtbar sein soll oder nicht
        return irgendwas.cost <= getCash().doubleValue();
    }

    public static void setCash(BigInteger cash) {                                       //Setter für unsere Währung
        Main.cash = cash;
    }

    /* Main die unser Programm startet */
    public static void main(String[] args) {
        launch(args);
    }
}
