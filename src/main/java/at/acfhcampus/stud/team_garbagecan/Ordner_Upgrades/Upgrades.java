package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import javafx.scene.image.Image;
import javafx.scene.layout.HBox;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static at.acfhcampus.stud.team_garbagecan.Main.getCash;
import static at.acfhcampus.stud.team_garbagecan.Main.setCash;

public abstract class Upgrades {                                                    //neue abstrakte Klasse die als Blueprint für alle Upgrades dient.
    /* Variablen eins Upgrades */
    public int income;                                                              //Ein Upgrade muss also haben: income (wie viel Geld pro Zeiteinheit
    public String name;                                                             //Einen Namen
    public int amount;                                                              //Wie oft das Upgrade gekauft wurde
    public int cost;                                                                //Wie viel das Upgrade kostet
    public static List<Upgrades> upgradeList = new ArrayList<>();                  //Erstellen einer Liste die bei der Erstellung eines neuen Upgrades dieses gleich in sich hinzufügt
    private ShopItem shopItem;

    public Upgrades(int income, int amount, int cost, String name, String url) {    //Ganz normaler Konstruktor für die Upgrades
        this.income = income;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        upgradeList.add(this);                                                      //Fügt das erzeugte Upgrade in die erstellte Liste hinzu
        shopItem = new ShopItem(new Image(url), this);                     //Pfad des Icons eines Upgrades
    }

    /* Funktionen der Upgrades */
    public BigInteger calcincome() {
        return BigInteger.valueOf((long) income * amount);                           //Berechnung des Incomes für ein Upgrade als funktion. Wie viel ein Upgrade pro tick gibt mal der Anzahl des Upgrades
    }

    public void buy() {
        amount++;                                                                   //Erhöht das Amount eines Upgrades wenn man es kauft
        setCash(getCash().subtract(BigInteger.valueOf(cost)));                      //Zieht die Kosten eines Upgrades nach dem Kaufen von der Währung die man hat ab
        cost = (int) (cost + Math.exp(amount * 0.5));                               //Berechnet mit Hilfe einer exponentiellen Wachstumsfunktion die nächsten Kosten des Upgradekaufes
        shopItem.incAmount();                                                       //Ändert die Anzahl eines Upgrades die angezeigt wird auf den korrekten Wert nach dem Kaufen
        shopItem.setPrice(cost);                                                    //Ändert die Kosten eines Upgrades die angezeigt werden auf den korrekten Wert nach dem Kaufen
    }

    public void checkIfMoney() {
        if (getCash().longValue() >= cost)
            buy();                                                                  //checkt ob wir genug Währung haben um uns ein Upgrade zu kaufen, wenn ja wird es gekauft
        else
            System.out.println("WE DON´T HAVE THE CAPACITIES");                    //Wenn wir nicht genug Währung haben wird eine Fehlermeldung aufgeführt.
    }

    public HBox getShopItem() {                                                     //Getter für die einzelnen Shopitems
        return shopItem.getShopElements();
    }
}
