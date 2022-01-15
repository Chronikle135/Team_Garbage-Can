package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Muelleimer extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 73151677891L;
    public Muelleimer() {
        super(50, 0, 500, "Mülleimer", "/at/acfhcampus/stud/team_garbagecan/Muelleimer.png");
    }
}
