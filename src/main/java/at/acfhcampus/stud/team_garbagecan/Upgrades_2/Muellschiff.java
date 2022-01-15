package at.acfhcampus.stud.team_garbagecan.Upgrades_2;

import java.io.Serializable;

public class Muellschiff extends Upgrade2 implements Serializable {
    private static final long serialVersionUID = 78978312777L;
    public Muellschiff() {
        super(10, 0, 50, "Müllschiff", "/at/acfhcampus/stud/team_garbagecan/Müllschiff.png");
    }
}
