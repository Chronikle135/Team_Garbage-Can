package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Sondermuell extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 12378978943L;
    public Sondermuell() {
        super(550, 0, 5900, "Sondermüll", "/at/acfhcampus/stud/team_garbagecan/Mülltüte.png");
    }
}

