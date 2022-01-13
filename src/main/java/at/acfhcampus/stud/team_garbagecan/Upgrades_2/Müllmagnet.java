package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Müllmagnet extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 5477773111L;
    public Müllmagnet() {
        super(15, 0, 1200, "Müllmagnet", "/at/acfhcampus/stud/team_garbagecan/magnet.png");
    }
}
