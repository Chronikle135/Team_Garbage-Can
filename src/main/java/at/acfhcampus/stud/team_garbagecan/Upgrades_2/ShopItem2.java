package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.Serializable;

public class ShopItem2{

        /* Eigenschaften des Shopitems */
        HBox shopElements;
        VBox zwischenContainer;
        ImageView icon;
        Button buy;
        Text name;
        Text price;
        Text amount;

        public ShopItem2(Image image, Upgrade2 upgrades) {
            icon = new ImageView(image);                                                                //Icon das beim erstellen des Shopitems zugewiesen wird
            icon.setFitHeight(10);                                                                      //Höhe und Breite des Icons
            icon.setFitWidth(25);
            shopElements = new HBox();                                                                  //Erstellen der Box in der alle Elemente des Upgrades drinnen sind
            shopElements.setMinHeight(50);
            shopElements.setMinWidth(100);
            shopElements.setPadding(new Insets(5, 5, 5, 10));
            shopElements.setStyle("-fx-background-image: url(/at/acfhcampus/stud/team_garbagecan/shopitem.png);");

            buy = new Button();                                                                         //Button zum kaufen des Upgrades
            buy.setOnMouseClicked(e -> upgrades.checkIfMoney());                                        //Klickevent checkt zuerst ob man genug Geld hat, wenn ja wird es gekauft, wenn nein dann gibt es eine Fehlermeldung
            buy.setGraphic(icon);

            this.name = new Text(upgrades.name + "");                                                   //Erstellen der Textfelder für den Namen, Preis und Anzahl des Upgrades
            this.name.setFont(Font.font("Arial Bold", FontWeight.BOLD,13));
            this.name.setFill(Color.BLACK);

            this.price = new Text(String.format("Price: %d", upgrades.cost));
            this.price.setFont(Font.font("Arial Bold", FontWeight.BOLD, 10));
            this.price.setFill(Color.BLACK);

            this.amount = new Text(String.format("Amount: %d", upgrades.amount));
            this.amount.setFont(Font.font("Arial Bold", FontWeight.BOLD,10));
            this.amount.setFill(Color.BLACK);

            this.zwischenContainer = new VBox();                                                        //Neue Box in der dann alle Eigenschaften des Upgrades sind zum besseren Handhaben
            zwischenContainer.getChildren().addAll(name, price, amount);                                //Aufnehmen der Eigenschaften in dem Zwischencontainer
            zwischenContainer.setSpacing(1);                                                            //Weitere Formatierung
            shopElements.setSpacing(5);
            shopElements.getChildren().addAll(buy, zwischenContainer);                            //Aufnehmen der restlichen Eigenschaften und der Zwischenbox im finalen Shopelement
            shopElements.setAlignment(Pos.CENTER_LEFT);
            shopElements.setVisible(false);                                                             //Sichtbarkeit der Shopbox
        }

        /* Funktionen der Shopitems */

        public HBox getShopElements() {                                                                 //Getter fÃ¼r die Elemente
            return shopElements;
        }

        public void incAmount() {                                                                       //Funktion zur Anzeige der Anzahl eines Upgrades im Besitz
            amount.setText(String.format("Amount: %d", Integer.parseInt(amount.getText().split(" ")[1]) + 1));
        }

        public void setPrice(int newPrice) {                                                            //Funktion zur Anzeige des Preises eines Upgrades
            price.setText(String.format("Price: %d", newPrice));
        }
    }

