package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static at.acfhcampus.stud.team_garbagecan.Main.visibility;

public class ShopItem {

    HBox shopElements;
    VBox irgendwie;
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
        this.price = new Text(String.format("Price: %d", upgrades.cost));
        this.amount = new Text(String.format("Amount: %d", upgrades.amount));
        this.irgendwie = new VBox();
        irgendwie.getChildren().addAll(name, price,amount);
        irgendwie.setSpacing(1);
        shopElements.setSpacing(5);
        shopElements.getChildren().addAll(icon, buy, irgendwie);
        /*shopElements.setVisible(visibility(upgrades));*/
    }

    public HBox getShopElements() {
        return shopElements;
    }

    public void incAmount() {
        amount.setText(String.format("Amount: %d", Integer.parseInt(amount.getText().split(" ")[1]) + 1));
    }

    public void setPrice(int newPrice) {
        price.setText(String.format("Price: %d", newPrice));
    }
}
