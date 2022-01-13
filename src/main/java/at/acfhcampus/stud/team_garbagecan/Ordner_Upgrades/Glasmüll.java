package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class Glasmüll extends Upgrades implements Serializable {
    private static final long serialVersionUID = 45663153215L;
    public Glasmüll() {
        super(250, 0, 5500, "Glasmüll", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}
