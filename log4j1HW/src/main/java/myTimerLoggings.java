import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);

    public static void main(String[] args) {
        Timer debugTimer = new Timer();
        Timer infoTimer = new Timer();
        Timer errorTimer = new Timer();

        debugTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug(String.format("Current Time: %tT", System.currentTimeMillis()));
            }
        }, 0, 1000);

        infoTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info(String.format("Current Time: %tR", System.currentTimeMillis()));
            }
        }, 0, 60000);

        errorTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error(String.format("Current Time: %tT", System.currentTimeMillis() + 3600000));
            }
        }, 0, 3600000);
    }
}
