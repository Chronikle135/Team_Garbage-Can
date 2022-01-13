package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class Müllabfuhr extends Upgrades implements Serializable {                                                                         //erstellung des Upgrades mit den richtigen Variablen
    private static final long serialVersionUID = 6529685098267757690L;
    public Müllabfuhr() {
        super(0,0,250,"Müllabfuhr", "/at/acfhcampus/stud/team_garbagecan/Mullabfuhr.png");
    }
}
