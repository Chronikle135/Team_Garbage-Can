package at.acfhcampus.stud.team_garbagecan.Upgrades_7;

import static at.acfhcampus.stud.team_garbagecan.Main.getCash;
import static at.acfhcampus.stud.team_garbagecan.Main.setCash;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

public abstract class Upgrade7 {
    /* Variablen eins Upgrades */
    public int clickpower;                                                          //Ein Upgrade muss also haben: wie viel Geld pro Klick
    public String name;                                                             //Einen Namen
    public int amount;                                                              //Wie oft das Upgrade gekauft wurde
    public int cost;                                                                //Wie viel das Upgrade kostet
    public static List<Upgrade7> upgradeList = new ArrayList<>();                   //Erstellen einer Liste die bei der Erstellung eines neuen Upgrades dieses gleich in sich hinzufÃ¼gt
    private ShopItem7 shopItem;

    public Upgrade7(int clickpower, int amount, int cost, String name, String url) {
        this.clickpower = clickpower;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        upgradeList.add(this);                                                     //Fügt das erzeugte Upgrade in die erstellte Liste hinzu
        shopItem = new ShopItem7(new Image(url), this);                     //Pfad des Icons eines Upgrades
    }

    /* Funktionen der Upgrades */
    public BigInteger calcincome() {
        return BigInteger.valueOf((long) clickpower * amount);                           //Berechnung des Incomes fÃ¼r ein Upgrade als funktion. Wie viel ein Upgrade pro tick gibt mal der Anzahl des Upgrades
    }

    public void buy() {
        amount++;                                                                   //ErhÃ¶ht das Amount eines Upgrades wenn man es kauft
        setCash(getCash().subtract(BigInteger.valueOf(cost)));                      //Zieht die Kosten eines Upgrades nach dem Kaufen von der WÃ¤hrung die man hat ab
        cost = (int) (cost + Math.exp(amount * 0.5));                               //Berechnet mit Hilfe einer exponentiellen Wachstumsfunktion die nÃ¤chsten Kosten des Upgradekaufes
        shopItem.incAmount();                                                       //Ã„ndert die Anzahl eines Upgrades die angezeigt wird auf den korrekten Wert nach dem Kaufen
        shopItem.setPrice(cost);                                                    //Ã„ndert die Kosten eines Upgrades die angezeigt werden auf den korrekten Wert nach dem Kaufen
    }

    public void checkIfMoney() {
        if (getCash().longValue() >= cost)
            buy();                                                                  //checkt ob wir genug WÃ¤hrung haben um uns ein Upgrade zu kaufen, wenn ja wird es gekauft
        else
            System.out.println("WE DON´T HAVE THE CAPACITIES");                    //Wenn wir nicht genug WÃ¤hrung haben wird eine Fehlermeldung aufgefÃ¼hrt.
    }

    public int getClickpower() {
        return clickpower;
    }

    public int getAmount() {
        return amount;
    }

    public HBox getShopItem() {                                                     //Getter fÃ¼r die einzelnen Shopitems
        return shopItem.getShopElements();
    }
}
