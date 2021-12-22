package at.acfhcampus.stud.team_garbagecan;
import java.util.Timer;
import java.util.TimerTask;
import at.acfhcampus.stud.team_garbagecan.Upgradess.Müllverbrennung;
import javafx.application.Application;
import javafx.stage.Stage;

public class canclicker extends Application {
    public static void main() {
        int[] cash = {0};
        Müllverbrennung müllverbrennung = new Müllverbrennung();
        Timer tick = new Timer();
        TimerTask getting = new TimerTask() {
            @Override
            public void run() {
                cash[0] += müllverbrennung.calcincome();
                System.out.println(cash[0]);
            }
        };
        tick.schedule(getting,0, 100);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    main();
    }
}

