package at.acfhcampus.stud.team_garbagecan;

import at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades.*;
import at.acfhcampus.stud.team_garbagecan.Upgrades_2.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.*;
import java.math.BigInteger;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application implements Serializable {
    /* Globale Variablen */
    private static BigInteger cash = new BigInteger("0");
    final private int TICKRATE = 1000;
    private final int WIDTH = 200 + 200 + 300;
    private final int HEIGHT = 700;
    int clickingPower = 1;
    int changeTo;
    int time;
    BigInteger cashTrace = new BigInteger("0");


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /* GUI Elemente */
    private HBox containerHBox = new HBox();
    private VBox rigthSideBoxTop = new VBox();
    private VBox middleBox = new VBox();
    private VBox leftSideBox = new VBox();
    private VBox finalcontainer = new VBox();
    private HBox banner = new HBox();
    private HBox footer = new HBox();
    private HBox pause1 = new HBox();
    private HBox pause2 = new HBox();
    private HBox pause3 = new HBox();
    private HBox containerPauseBox = new HBox();
    Button canButton = new Button();
    Button pauseButton = new Button();
    Button continueButton = new Button();
    Button saveButton = new Button();
    Button loadButton = new Button();
    Scene mainScene = new Scene(finalcontainer, WIDTH, HEIGHT);
    Scene pauseScene = new Scene(containerPauseBox);
    Button errorButton = new Button();
    Popup save = new Popup();
    Popup load = new Popup();
    Label label = new Label("Saved successfully");

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
        /* Objekte und Upggrades die wir brauchen */
        Muellschiff muellschiff = new Muellschiff();
        Muelleimer muelleimer = new Muelleimer();
        Muellverbrennung müllverbrennung = new Muellverbrennung();     //Manuelles erstellen von den Objekten, hat als Werte income, cost, name und amount
        Muellcontainer müllcontainer = new Muellcontainer();
        OeffentlicheMuelltonne OeffentlicheMuelltonne = new OeffentlicheMuelltonne();
        Muellabfuhr muellabfuhr = new Muellabfuhr();
        //Restmuell restmuell = new Restmuell();
        //Papiermuell papiermuell = new Papiermuell();
        //Wertstoffhof wertstoffhof = new Wertstoffhof();

        Trashforce trashforce = new Trashforce();
        Muelltrennung muelltrennung = new Muelltrennung();
        //Glasmuell glasmuell = new Glasmuell();
        Muelllaster muelllaster = new Muelllaster();
        Muellmagnet muellmagnet = new Muellmagnet();
        Muellangel muellangel = new Muellangel();
        //Recycling recycling = new Recycling();
        Muelltuete muelltuete = new Muelltuete();
        //Muellsack  muellsack = new Muellsack();
        //Bioabfall bioabfall = new Bioabfall();
        //Sondermuell sondermuell = new Sondermuell();
        //Freiwillige_Helfer freiwillige_Helfer = new Freiwillige_Helfer();
        //Muellspiess müllspiess = new Muellspiess();


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* GUI Initialisierungen */
        Image icon = new Image("/at/acfhcampus/stud/team_garbagecan/garbage-can.png");
        Text text = new Text();
        Text garbage = new Text();
        Text klicksPerSec = new Text();
        Text clickPower = new Text();
        Text playTime = new Text();
        Text sumOfGarbage = new Text();
        Text notEnoughCans = new Text();

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Texte und ihre Eigenschaften */

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setWidth(5);
        shadow.setHeight(5);
        shadow.setOffsetX(3);
        shadow.setOffsetY(2);

        text.setText("GARBAGE-CLICKER");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 30));


        garbage.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        garbage.setFill(Color.WHITE);
        garbage.setTextAlignment(TextAlignment.CENTER);

        klicksPerSec.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        klicksPerSec.setFill(Color.AQUAMARINE);
        klicksPerSec.setEffect(shadow);


        clickPower.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        clickPower.setFill(Color.BEIGE);
        clickPower.setEffect(shadow);


        playTime.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        playTime.setFill(Color.CORAL);
        playTime.setEffect(shadow);

        sumOfGarbage.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        sumOfGarbage.setFill(Color.WHITE);
        sumOfGarbage.setEffect(shadow);


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Trashcanbutton */
        //Erstellen eines neuen Buttons
        canButton.setMinWidth(icon.getWidth() / 2);                                   //Höhe und Breite Variabel machen
        canButton.setMinHeight(icon.getHeight() / 2);                                 //Optische hexereien um dem ganzen ein Icon zuzuweisen und den Hintergrund auszublenden
        canButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/garbage-can.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        canButton.setOnMouseClicked(e -> clicki());                                   //Klickevent beim drücken des Buttons
        canButton.setEffect(shadow);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Boxensystem */
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Banner */

        banner.setMinWidth(WIDTH);
        banner.setMinHeight(100);
        banner.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/bannerNew.png);");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /* Mittlere Box */
        middleBox.setSpacing(20);
        middleBox.setAlignment(Pos.CENTER);
        middleBox.setMinWidth(300);
        middleBox.setPadding(new Insets(30, 10, 20, 10));
        middleBox.getChildren().addAll(garbage, canButton, klicksPerSec, playTime, clickPower, sumOfGarbage);
        middleBox.setMinHeight(HEIGHT - 150);
        middleBox.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/middleboxLight.png);");



        /*
                -fx-border-left: black;" +
                "-fx-border-style: solid none solid solid;" +
                "-fx-border-width: 5;"
         */
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Linke Box */

        leftSideBox.setMinWidth(200);
        leftSideBox.setMinHeight(HEIGHT - 150);
        leftSideBox.setPadding(new Insets(82, 5, 4, 5));
        leftSideBox.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/sideboxNGarbage.png);");
        for (Upgrade2 u : Upgrade2.upgradeList2) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            leftSideBox.getChildren().add(u.getShopItem2());
        }


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Rechte/Shop Box */
        rigthSideBoxTop.setMinWidth(200);
        rigthSideBoxTop.setMinHeight(HEIGHT - 150);
        rigthSideBoxTop.setPadding(new Insets(82, 5, 4, 5));
        rigthSideBoxTop.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/sideboxNClickpower.png);");
        //store = new ImageView("url(/at/acfhcampus/stud/team_garbagecan/store.jpg)");
        for (Upgrades u : Upgrades.upgradeList) {                                     //Durchiterieren der Upgradeliste wobei jedes Element in den Shop aufgenommen wird
            rigthSideBoxTop.getChildren().add(u.getShopItem());
        }

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        errorButton.setMinWidth(200);
        errorButton.setMinHeight(200);
        errorButton.setStyle("![](../../../../../resources/at/acfhcampus/stud/team_garbagecan/stopSignEmpty.png)");
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        pauseButton.setMinWidth(100);
        pauseButton.setMinHeight(25);
        pauseButton.setOnMouseClicked(f -> primaryStage.setScene(pauseScene));
        pauseButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/pause.png);");

        footer.setMinHeight(50);
        footer.setMinWidth(WIDTH);
        footer.setSpacing(30);
        footer.setAlignment(Pos.CENTER);
        footer.setPadding(new Insets(5, 5, 5, 5));
        footer.getChildren().addAll(pauseButton);
        footer.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/footer.png);");
//----------------------v-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Box in der die mittlere, rechte und linke Box sind */
        containerHBox.setMaxHeight(HEIGHT);
        containerHBox.getChildren().addAll(leftSideBox, middleBox, rigthSideBoxTop);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Fertige Box in der alle anderen drinnen sind */
        finalcontainer.getChildren().addAll(banner, containerHBox, footer);

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /*Pausescreen Container mit den einzelnen Boxen die als Menüpunkte dienen*/
        containerPauseBox.getChildren().addAll(pause1, pause2, pause3);
        containerPauseBox.setMinWidth(700);
        containerPauseBox.setMinHeight(700);

        containerPauseBox.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/pauseBackground.png);");
        // Continue Button
        pause1.setMinHeight(50);
        pause1.setMinWidth(200);
        pause1.setAlignment(Pos.CENTER);
        pause1.getChildren().addAll(continueButton);

        continueButton.setMinWidth(100);
        continueButton.setMinHeight(50);
        continueButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/continue.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        continueButton.setOnMouseClicked(t -> {
            primaryStage.setScene(mainScene);
            load.setOpacity(0);
            save.setOpacity(0);
        });
        pause2.setMinHeight(50);
        pause2.setMinWidth(300);
        pause2.setAlignment(Pos.CENTER);
        pause2.getChildren().addAll(saveButton);

        saveButton.setMinWidth(100);
        saveButton.setMinHeight(50);
        saveButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/save.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        saveButton.setOnMouseClicked(f -> {
            try {
                saveGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        //Load Button
        pause3.setMinHeight(50);
        pause3.setMinWidth(200);
        pause3.setAlignment(Pos.CENTER);
        pause3.getChildren().addAll(loadButton);

        loadButton.setMinWidth(100);
        loadButton.setMinHeight(50);
        loadButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/load.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");
        loadButton.setOnMouseClicked(f ->

        {
            try {
                loadGame();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Einblenden einer Hintergrundfarbe für die 3 zentralen Boxen zum Bugtesten */
        /*trashCanBox.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
        shopBox.setBackground(new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY)));
        leftSideBox.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));*/


//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /* Erstellen und Eigenschafte der Szene */
        primaryStage.getIcons().add(icon);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Garbage-Clicker");
        primaryStage.setScene(mainScene);
        primaryStage.show();

        save.centerOnScreen();
        save.setHeight(150);
        save.setWidth(150);
        save.getContent().add(label);
        save.show(primaryStage);
        save.setOpacity(0);

        load.centerOnScreen();
        load.setHeight(150);
        load.setWidth(150);
        load.getContent().add(label);
        load.show(primaryStage);
        load.setOpacity(0);
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /* Timer und seine Funktionen */
        Timer tick = new Timer();                                                         //Erstellen eines neuen Timers
        TimerTask getting = new TimerTask() {                                             //Erstellen einer TimerTasks, also einer Aufgabe die mit dem Tick eines Timers ausgeführt wird
            @Override
            public void run() {
                time++;
                for (Upgrades u : Upgrades.upgradeList) {                                 //Berechnung des aktuellen Währungsstandes plus des incomes von jedem Element in der Liste der Upgrades
                    cash = cash.add(u.calcIncome());
                    cashTrace = cashTrace.add(u.calcIncome());
                }
            }
        };
        TimerTask money = new TimerTask() {
            @Override
            public void run() {
                garbage.setText(String.format("Amount of Garbage %n%d", cash.longValue()));
                garbage.setEffect(shadow);
                playTime.setText("Time: " + time);
                sumOfGarbage.setText("Total Garbage: " + cashTrace);
                clickPower.setText("Click Power: " + clickingPower);
                klicksPerSec.setText("Garbage/s: " + perSecond());
                for (Upgrade2 u : Upgrade2.upgradeList2) {
                    changeTo += (u.getClickpower() * u.getAmount());
                    u.getShopItem2().setVisible(visibility2(u));
                    if (getCash().longValue() < u.getCost()) {
                        u.getShopItem2().setOpacity(0.3);
                        u.getRealShopItem().getBuy().setDisable(true);
                    } else {
                        u.getShopItem2().setOpacity(1);
                        u.getRealShopItem().getBuy().setDisable(false);
                    }
                }
                for (Upgrades u : Upgrades.upgradeList) {
                    u.getShopItem().setVisible(visibility(u));
                    if (getCash().longValue() < u.getCost()) {
                        u.getShopItem().setOpacity(0.3);
                        u.getRealShopItem().getBuy().setDisable(true);
                    } else {
                        u.getShopItem().setOpacity(1);
                        u.getRealShopItem().getBuy().setDisable(false);
                    }
                }
                clickingPower = changeTo + 1;
                changeTo = 0;
            }
        };
        tick.schedule(getting, 0, TICKRATE);                                        //Scheduler der einen Timertask ausführ in einer gewissen periodizität. In diesem Fall wird getting ausgeführt ab Zeitpunkt 0 und das alle 1000ms(Tickrate).
        tick.schedule(money, 0, 1);
        // Close Game

    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /* Funktionen die wir brauchen */
    private void clicki() {                                                             //Klickevent dass bei jedem Klick passiert

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                canButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/garbage-can.png);" +
                        "-fx-background-size: 100%;" +
                        "-fx-background-color: transparent;");
            }
        }, 200);//wait 1000ms before doing the action

        canButton.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/garbage-can_small_plus.png);" +
                "-fx-background-size: 100%;" +
                "-fx-background-color: transparent;");

        cash = cash.add(BigInteger.valueOf(clickingPower));                             //clickingPower gibt an wie viel Währung man pro Klick bekommt
        cashTrace = cashTrace.add(BigInteger.valueOf(clickingPower));
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static BigInteger getCash() {                                                //Getter damit wir uns die Cashvariabel von überall holen können und sie trotzdem noch protected ist
        return cash;
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static boolean visibility(Upgrades irgendwas) {                              //Boolean der uns sagt ob ein Upgrade sichtbar sein soll oder nicht
        if (irgendwas.getShopItem().isVisible()) return true;
        else return irgendwas.cost <= getCash().doubleValue();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static boolean visibility2(Upgrade2 irgendwas) {                             //Boolean der uns sagt ob ein Upgrade sichtbar sein soll oder nicht
        if (irgendwas.getShopItem2().isVisible()) return true;
        else return irgendwas.cost <= getCash().doubleValue();
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static int perSecond() {
        int sumOfIncome = 0;
        for (Upgrades u : Upgrades.upgradeList) {
            sumOfIncome += u.income * u.amount;
        }
        return sumOfIncome;
    }

    public void setCashTrace(BigInteger cashTrace) {
        this.cashTrace = cashTrace;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void setCash(BigInteger cash) {                                       //Setter für unsere Währung
        Main.cash = cash;
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /*Save Game */
    public void saveGame() throws IOException {
        FileOutputStream fos = new FileOutputStream("src/main/saveGame/saveGame.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Upgrades u : Upgrades.upgradeList) {
            oos.writeObject(u.getCost());
            oos.writeObject(u.getAmount());
        }
        for (Upgrade2 u : Upgrade2.upgradeList2) {
            oos.writeObject(u.getCost());
            oos.writeObject(u.getAmount());
        }
        oos.writeUTF(String.valueOf(cash));
        oos.writeUTF(String.valueOf(cashTrace));
        oos.writeUTF(String.valueOf(time));
        oos.close();
        save.setOpacity(1);
    }

    public void loadGame() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/saveGame/saveGame.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        for (Upgrades u : Upgrades.upgradeList) {
            u.setCost((Integer) ois.readObject());
            u.setAmount((int) ois.readObject());
            u.getRealShopItem().incAmount(u.amount);
        }
        for (Upgrade2 u : Upgrade2.upgradeList2) {
            u.setCost((Integer) ois.readObject());
            u.setAmount((int) ois.readObject());
            u.getRealShopItem().incAmount(u.amount);
        }
        setCash(BigInteger.valueOf(Long.parseLong(ois.readUTF())));
        setCashTrace(BigInteger.valueOf(Long.parseLong(ois.readUTF())));
        time = Integer.parseInt(ois.readUTF());
        ois.close();
        load.setOpacity(1);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    /* Main die unser Programm startet */
    public static void main(String[] args) {
        launch(args);
    }

}//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
