package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class Müllverbrennung extends Upgrades implements Serializable {                                                                         //erstellung des Upgrades mit den richtigen Variablen
    private static final long serialVersionUID = 789421L;
    public Müllverbrennung(int income, int amount, int cost, String name, String url) {
        super(income, amount, cost, name, url);
    }

    public Müllverbrennung() {
        super(1000,0,150000,"Müllverbrennung", "/at/acfhcampus/stud/team_garbagecan/Mullverbrennung.png");


    }
}
