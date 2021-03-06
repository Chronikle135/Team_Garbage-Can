package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static at.acfhcampus.stud.team_garbagecan.Main.getCash;
import static at.acfhcampus.stud.team_garbagecan.Main.setCash;

public abstract class Upgrade2 implements Serializable {
    /* Variablen eins Upgrades */
    public int clickpower;                                                                                              //Ein Upgrade muss also haben: clickpower
    public String name;                                                                                                 //Einen Namen
    public int amount;                                                                                                  //Wie oft das Upgr^ade gekauft wurde
    public int cost;                                                                                                    //Wie viel das Upgrade kostet
    public static List<Upgrade2> upgradeList2 = new ArrayList<>();                                                      //Erstellen einer Liste die bei der Erstellung eines neuen Upgrades dieses gleich in sich hinzufÃ¼gt
    private ShopItem2 shopItem2;

    public Upgrade2(int clickpower, int amount, int cost, String name, String url) {
        this.clickpower = clickpower;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        upgradeList2.add(this);                                                                                         //Fügt das erzeugte Upgrade in die erstellte Liste hinzu
        shopItem2 = new ShopItem2(new Image(url), this);                                                       //Pfad des Icons eines Upgrades
    }

    public void checkIfMoney() {
        if (getCash().longValue() >= cost) {
            buy();                                                                                                      //checkt ob wir genug WÃ¤hrung haben um uns ein Upgrade zu kaufen, wenn ja wird es gekauft
        }
    }

    public void buy() {
        amount++;                                                                                                       //ErhÃ¶ht das Amount eines Upgrades wenn man es kauft
        setCash(getCash().subtract(BigInteger.valueOf(cost)));                                                          //Zieht die Kosten eines Upgrades nach dem Kaufen von der WÃ¤hrung die man hat ab
        cost = (int) (cost + (amount * 0.234 * cost));                                                                  //Berechnet mit Hilfe einer exponentiellen Wachstumsfunktion die nÃ¤chsten Kosten des Upgradekaufes
        shopItem2.incAmount(amount);                                                                                    //Ã„ndert die Anzahl eines Upgrades die angezeigt wird auf den korrekten Wert nach dem Kaufen
        shopItem2.setPrice(cost);                                                                                       //Ã„ndert die Kosten eines Upgrades die angezeigt werden auf den korrekten Wert nach dem Kaufen
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getClickpower() {
        return clickpower;
    }

    public int getAmount() {
        return amount;
    }

    public ShopItem2 getRealShopItem() {
        return shopItem2;
    }

    public HBox getShopItem2() {
        return shopItem2.getShopElements();
    }
}

