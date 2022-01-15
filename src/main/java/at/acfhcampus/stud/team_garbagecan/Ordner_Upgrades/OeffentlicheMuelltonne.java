package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class OeffentlicheMuelltonne extends Upgrades implements Serializable {                                                                         //erstellung des Upgrades mit den richtigen Variablen
    public OeffentlicheMuelltonne() {
        super(50,0,120,7891231777L,"Mülltonnen", "/at/acfhcampus/stud/team_garbagecan/Mulltonne.png");
    }
}
