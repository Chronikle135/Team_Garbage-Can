package at.acfhcampus.stud.team_garbagecan;
import at.acfhcampus.stud.team_garbagecan.Upgrades;
import java.util.Timer;
import java.util.TimerTask;

public class canclicker {
    TimerTask cond = new TimerTask() {
        @Override
        public void run() {
            trash = +income;
        }
    };
    public static void main(String[] args) {
    Timer tick = new Timer();
    tick.schedule(cond,0,1000 );




    }

}

