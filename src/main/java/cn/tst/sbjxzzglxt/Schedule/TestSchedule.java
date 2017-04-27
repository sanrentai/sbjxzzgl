package cn.tst.sbjxzzglxt.Schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author ZERO
 */
@Singleton
public class TestSchedule {
//    @Schedule(second = "*/10", minute = "*", hour = "*", persistent = false)
    public void doWork() {
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
        System.out.println("ScheduleExample.doWork() invoked at " + simpleDateFormat.format(currentTime));
    }
    
}
