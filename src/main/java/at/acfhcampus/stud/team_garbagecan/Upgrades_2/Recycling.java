package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Recycling extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 999978458345L;
    public Recycling() {
        super(30, 0, 2500, "Recycling", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}

