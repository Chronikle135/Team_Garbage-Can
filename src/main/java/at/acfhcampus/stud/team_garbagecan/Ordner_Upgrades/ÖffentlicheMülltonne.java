package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class ÖffentlicheMülltonne extends Upgrades implements Serializable {                                                                         //erstellung des Upgrades mit den richtigen Variablen
    private static final long serialVersionUID = 7891231777L;
    public ÖffentlicheMülltonne() {
        super(0,0,120,"Mülltonnen", "/at/acfhcampus/stud/team_garbagecan/Mulltonne.png");
    }
}
