package at.acfhcampus.stud.team_garbagecan;

import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllabfuhr;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllverbrennung;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Upgrades;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.ÖffentlicheMülltonne;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Müllcontainer;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Mülltrennung;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Freiwillige_Helfer;
import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.Trashforce;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Mülllaster;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Müllmagnet;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Müllangel;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Müllspieß;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.Upgrade2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Timer;
import java.util.TimerTask;

import static at.acfhcampus.stud.team_garbagecan.Main.getCash;

public class Main extends Application {
    /* Globale Variablen */
    private static BigInteger cash = new BigInteger("0");
    final private int TICKRATE = 1000;
    private final int WIDTH = 200 + 200 + 300;
    private final int HEIGHT = 700;
    int clickingPower = 1;
    int changeTo;


    /* GUI Elemente */
    private HBox containerHBox = new HBox();
    private VBox rigthSideBoxTop = new VBox();
    private VBox rigthSideBoxBottom = new VBox();
    private VBox middleBox = new VBox();
    private VBox leftSideBox = new VBox();
    private VBox finalcontainer = new VBox();
    private HBox banner = new HBox();
    private HBox footer = new HBox();
    ImageView store;


    public void start(Stage stage) throws IOException {
        /* Objekte und Upggrades die wir brauchen */
        Müllverbrennung müllverbrennung = new Müllverbrennung();     //Manuelles erstellen von den Objekten, hat als Werte income, cost, name und amount
        Müllcontainer müllcontainer = new Müllcontainer();
        ÖffentlicheMülltonne öffentlicheMülltonne = new ÖffentlicheMülltonne();
        Freiwillige_Helfer freiwillige_Helfer = new Freiwillige_Helfer();
        Müllabfuhr müllabfuhr = new Müllabfuhr();
        Trashforce trashforce = new Trashforce();
        Mülltrennung mülltrennung = new Mülltrennung();
        Müllspieß müllspieß = new Müllspieß();
        Mülllaster mülllaster = new Mülllaster();
        Müllmagnet müllmagnet = new Müllmagnet();
        Müllangel müllangel = new Müllangel();


        /* GUI Initialisierungen */
        Image icon = new Image("/at/acfhcampus/stud/team_garbagecan/garbage-can.png");
        Text text = new Text();
        Text garbage = new Text();


        /* Texte und ihre Eigenschaften */
        text.setText("GARBAGE-CLICKER");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        garbage.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        garbage.setFill(Color.WHITE);
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

        /* Banner */

        banner.setMinWidth(WIDTH);
        banner.setMinHeight(100);
        banner.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/banner.jpg);");


        /* Mittlere Box */
        middleBox.setSpacing(30);
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setMinWidth(300);
        middleBox.setPadding(new Insets(20, 10, 20, 10));
        middleBox.getChildren().addAll(garbage, canButton);
        middleBox.setMinHeight(HEIGHT-100);
        middleBox.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/metalldark.jpg);" +
                "-fx-border-color: black;" +
                "-fx-border-style: solid;" +
                "-fx-border-width: 5;");

        /* Linke Box */
        leftSideBox.setMinWidth(200);
        leftSideBox.setMinHeight(HEIGHT-100);
        leftSideBox.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/metall.jpg);" +
                "-fx-border-left: black;" +
                "-fx-border-style: solid none solid solid;" +
                "-fx-border-width: 5;");

        /* Rechte/Shop Box Top */
        rigthSideBoxTop.setMinWidth(200);
        rigthSideBoxTop.setMinHeight((HEIGHT/2)-100);
        rigthSideBoxTop.setPadding(new Insets(5, 5, 20, 0));
        rigthSideBoxTop.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/metall.jpg);" +
                "-fx-border-color: black;" +
                "-fx-border-style: solid solid solid none;" +
                "-fx-border-width: 5;");
        //store = new ImageView("url(/at/acfhcampus/stud/team_garbagecan/store.jpg)");
        for (Upgrades u : Upgrades.upgradeList) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            rigthSideBoxTop.getChildren().add(u.getShopItem());
        }




        /* Rechte/Shop Box Bottom */
        rigthSideBoxBottom.setMinWidth(200);
        rigthSideBoxBottom.setMinHeight((HEIGHT/2)-100);

        rigthSideBoxBottom.setStyle("-fx-border-color: white;" +
                "-fx-border-style: solid;" +
                "-fx-border-width: 5;");
        for (Upgrade2 u : Upgrade2.upgradeList2) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            leftSideBox.getChildren().add(u.getShopItem2());
        }



        /* Box in der die mittlere, rechte und linke Box sind */
        containerHBox.setMaxHeight(HEIGHT);
        containerHBox.getChildren().addAll(banner, leftSideBox, middleBox, rigthSideBoxTop, rigthSideBoxBottom);

        /* Fertige Box in der alle anderen drinnen sind */
        finalcontainer.getChildren().addAll(banner, containerHBox, footer);

        /* Einblenden einer Hintergrundfarbe für die 3 zentralen Boxen zum Bugtesten */
        /*trashCanBox.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        shopBox.setBackground(new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY)));
        leftSideBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));*/

        /* Erstellen und Eigenschafte der Szene */
        Scene mainScene = new Scene(finalcontainer, WIDTH, HEIGHT);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Garbage-Clicker");
        stage.setScene(mainScene);
        stage.show();


        /* Timer und seine Funktionen */
        Timer tick = new Timer();                                                         //Erstellen eines neuen Timers
        TimerTask getting = new TimerTask() {                                             //Erstellen einer TimerTasks, also einer Aufgabe die mit dem Tick eines Timers ausgeführt wird
            @Override
            public void run() {
                for (Upgrades u : Upgrades.upgradeList) {                                 //Berechnung des aktuellen Währungsstandes plus des incomes von jedem Element in der Liste der Upgrades
                    cash = cash.add(u.calcincome());
                    u.getShopItem().setVisible(visibility(u));                            //Überprüfung der Sichtbarkeit jedes Upgrades
                }
                for (Upgrade2 u : Upgrade2.upgradeList2) {                                //Berechnung des aktuellen Währungsstandes plus des incomes von jedem Element in der Liste der Upgrades
                    u.getShopItem2().setVisible(visibility2(u));                          //Überprüfung der Sichtbarkeit jedes Upgrades
                }
            }
        };
        TimerTask money = new TimerTask() {
            @Override
            public void run() {
                garbage.setText(String.format("Amount of Garbage %n%d", cash.longValue()));
            }
        };
        tick.schedule(getting, 0, TICKRATE);                                        //Scheduler der einen Timertask ausführ in einer gewissen periodizität. In diesem Fall wird getting ausgeführt ab Zeitpunkt 0 und das alle 1000ms(Tickrate).
        tick.schedule(money,0, 1);
    }

    /* Funktionen die wir brauchen */
    private void clicki() {                                                             //Klickevent dass bei jedem Klick passiert
        for (Upgrade2 u: Upgrade2.upgradeList2) {
            changeTo += (u.getClickpower()*u.getAmount());
        }
        clickingPower = changeTo+1;
        changeTo = 0;
        cash = cash.add(BigInteger.valueOf(clickingPower));                             //clickingPower gibt an wie viel Währung man pro Klick bekommt
    }

    public void setClickingPower(int clickingPower) {
        this.clickingPower = clickingPower;
    }

    public static BigInteger getCash() {                                                //Getter damit wir uns die Cashvariabel von überall holen können und sie trotzdem noch protected ist
        return cash;
    }

    public static boolean visibility(Upgrades irgendwas) {//Boolean der uns sagt ob ein Upgrade sichtbar sein soll oder nicht
        if (irgendwas.getShopItem().isVisible()) return true;
        else return irgendwas.cost <= getCash().doubleValue();
    }
    public static boolean visibility2(Upgrade2 irgendwas) {//Boolean der uns sagt ob ein Upgrade sichtbar sein soll oder nicht
        if (irgendwas.getShopItem2().isVisible()) return true;
        else return irgendwas.cost <= getCash().doubleValue();
    }

    public static void setCash(BigInteger cash) {                                       //Setter für unsere Währung
        Main.cash = cash;
    }

    /* Main die unser Programm startet */
    public static void main(String[] args) {
        launch(args);
    }
}
