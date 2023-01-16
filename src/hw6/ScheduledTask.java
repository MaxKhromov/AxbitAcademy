package hw6;

import java.util.TimerTask;

public class ScheduledTask extends TimerTask {
    public ScheduledTask() {
    }

    @Override
    public void run() {
        System.out.println("tic tac");
    }
}
