package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Muellsack extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 783111123748L;
    public Muellsack() {
        super(100, 0, 3500, "Müllsack", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}

