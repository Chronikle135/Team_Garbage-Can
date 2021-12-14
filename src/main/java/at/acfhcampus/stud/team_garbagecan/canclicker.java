package at.acfhcampus.stud.team_garbagecan;
import java.util.Timer;
import java.util.TimerTask;

public class canclicker {
    public void main(String[] args) {
    Timer tick = new Timer();
    tick.schedule(cond,0,1000 );
    int trash;
    int income = 10;
        System.out.println();

    }

    TimerTask cond = new TimerTask() {
        @Override
        public void run() {
            garbage =+ income;
        }
    };
}

