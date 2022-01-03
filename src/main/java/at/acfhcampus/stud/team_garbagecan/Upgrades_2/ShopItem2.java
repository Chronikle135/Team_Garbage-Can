package at.acfhcampus.stud.team_garbagecan.Upgrades_2;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.*;

public class ShopItem2 {

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
            icon.setFitHeight(32);                                                                      //HÃ¶he und Breite des Icons
            icon.setFitWidth(32);
            shopElements = new HBox();                                                                  //Erstellen der Box in der alle Elemente des Upgrades drinnen sind
            buy = new Button();                                                                         //Button zum kaufen des Upgrades
            buy.setOnMouseClicked(e -> upgrades.checkIfMoney());                                        //Klickevent checkt zuerst ob man genug Geld hat, wenn ja wird es gekauft, wenn nein dann gibt es eine Fehlermeldung
            this.name = new Text(upgrades.name + "");                                                   //Erstellen der Textfelder fÃ¼r den Namen, Preis und Anzahl des Upgrades
            this.price = new Text(String.format("Price: %d", upgrades.cost));
            this.amount = new Text(String.format("Amount: %d", upgrades.amount));
            this.zwischenContainer = new VBox();                                                        //Neue Box in der dann alle Eigenschaften des Upgrades sind zum besseren Handhaben
            zwischenContainer.getChildren().addAll(name, price, amount);                                //Aufnehmen der Eigenschaften in dem Zwischencontainer
            zwischenContainer.setSpacing(1);                                                            //Weitere Formatierung
            shopElements.setSpacing(5);
            shopElements.getChildren().addAll(icon, buy, zwischenContainer);                            //Aufnehmen der restlichen Eigenschaften und der Zwischenbox im finalen Shopelement
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

