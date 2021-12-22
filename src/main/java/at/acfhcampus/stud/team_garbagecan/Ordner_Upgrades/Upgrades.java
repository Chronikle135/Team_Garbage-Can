package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.math.BigInteger;

public abstract class Upgrades {                                                           //neue abstrakte Klasse die als Blueprint für alle Upgrades dient.
    public int income;                                                              //Ein Upgrade muss also haben: income (wie viel Geld pro Zeiteinheit
    public String name;                                                                    //Einen Namen
    public int amount;                                                              //Wie oft das Upgrade gekauft wurde
    public int cost;                                                                //Wie viel das Upgrade kostet


    public Upgrades(int income, int amount, int cost, String name) {                //Ganz normaler Konstruktor für die Upgrades
        this.income = income;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
    }

    public BigInteger calcincome(){                                                        //Berechnung des Incomes für ein Upgrade als funktion. Wie viel ein Upgrade pro tick gibt mal der Anzahl des Upgrades
        return BigInteger.valueOf(income*amount);
    }
}
