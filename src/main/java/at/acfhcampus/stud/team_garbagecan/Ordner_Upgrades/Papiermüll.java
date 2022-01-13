package at.acfhcampus.stud.team_garbagecan.Ordner_Upgrades;

import java.io.Serializable;

public class Papiermüll extends Upgrades implements Serializable {
    private static final long serialVersionUID = 45678919L;
    public Papiermüll() {
        super(150, 0, 1500, "Papiermüll", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}
