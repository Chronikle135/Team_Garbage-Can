package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Muellmagnet extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 5477773111L;
    public Muellmagnet() {
        super(400, 0, 40000, "Müllmagnet", "/at/acfhcampus/stud/team_garbagecan/magnet.png");
    }
}
