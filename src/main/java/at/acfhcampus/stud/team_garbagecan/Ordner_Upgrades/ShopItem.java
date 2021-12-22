package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ShopItem {

    HBox shopElements;
    ImageView icon;
    Button buy;
    Text name;
    Text price;
    Text amount;

    public ShopItem(Image image, Upgrades upgrades) {
        icon = new ImageView(image);
        icon.setFitHeight(32);
        icon.setFitWidth(32);
        shopElements = new HBox();
        buy = new Button();
        buy.setOnMouseClicked(e -> upgrades.checkIfMoney());
        this.name = new Text(upgrades.name + "");
        this.price = new Text(upgrades.cost + "");
        this.amount = new Text(upgrades.amount + "");
        shopElements.setSpacing(5);
        shopElements.getChildren().addAll(icon, buy, name, price, amount);
    }

    public HBox getShopElements() {
        return shopElements;
    }

    public void incAmount() {
        amount.setText(Integer.toString(Integer.parseInt(amount.getText()) + 1));
    }

    public void setPrice(int newPrice) {
        price.setText(Integer.toString(newPrice));
    }
}
