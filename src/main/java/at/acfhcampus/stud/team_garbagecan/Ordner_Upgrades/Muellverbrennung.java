package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;


import java.io.Serializable;

public class Muellverbrennung extends Upgrades implements Serializable {                                                                         //erstellung des Upgrades mit den richtigen Variablen
    public Muellverbrennung() {
        super(10, 0, 5, 789421L, "Müllverbrennung", "/at/acfhcampus/stud/team_garbagecan/Mullverbrennung.png");
    }
}
