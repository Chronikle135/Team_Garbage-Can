package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Bioabfall extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 666666666L;
    public Bioabfall() {
        super(40, 0, 4500, "Bioabfall", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}

