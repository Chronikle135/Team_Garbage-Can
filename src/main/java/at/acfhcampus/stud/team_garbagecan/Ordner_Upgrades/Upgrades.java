package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import at.acfhcampus.stud.team_garbagecan.Main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public abstract class Upgrades {                                                    //neue abstrakte Klasse die als Blueprint für alle Upgrades dient.
    public int income;                                                              //Ein Upgrade muss also haben: income (wie viel Geld pro Zeiteinheit
    public String name;                                                             //Einen Namen
    public int amount;                                                              //Wie oft das Upgrade gekauft wurde
    public int cost;                                                                //Wie viel das Upgrade kostet
    public static List <Upgrades> upgradeList = new ArrayList<>();                  //Erstellen einer Liste die bei der Erstellung eines neuen Upgrades dieses gleich in sich hinzufügt

    public Upgrades(int income, int amount, int cost, String name) {                //Ganz normaler Konstruktor für die Upgrades
        this.income = income;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        upgradeList.add(this);                                                      //Fügt das erzeugte Upgrade in die erstellte Liste hinzu
    }

    public BigInteger calcincome(){
        return BigInteger.valueOf((long) income *amount);                           //Berechnung des Incomes für ein Upgrade als funktion. Wie viel ein Upgrade pro tick gibt mal der Anzahl des Upgrades
    }
    public void buy(){
        amount++;                                                                   //Erhöht das Amount eines Upgrades wenn man es kauft
        cost = (int) (cost*Math.exp(amount/7));                                     //Berechnet mit Hilfe einer exponentiellen Wachstumsfunktion die nächsten Kosten des Upgradekaufes
    }
    public void checkIfMoney(){
        if ( Main.getCash().longValue() >= cost) buy();                             //checkt ob wir genug Währung haben um uns ein Upgrade zu kaufen, wenn ja wird es gekauft
        else System.out.println("WE DON´T HAVE THE CAPACITIES");                    //Wenn wir nicht genug Währung haben wird eine Fehlermeldung aufgeführt.
    }
}
