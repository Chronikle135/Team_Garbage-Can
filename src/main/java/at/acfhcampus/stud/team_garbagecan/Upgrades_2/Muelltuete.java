package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Muelltuete extends Upgrade2  implements Serializable {
    private static final long serialVersionUID = 45678781123L;
    public Muelltuete() {
        super(500, 0, 20000, "Mülltüte", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}