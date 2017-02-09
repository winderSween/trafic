package project3;
/**
 * @author huangshengwei
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
    
public class Scheduler {    
    private Lights light=new Lights(false,"SN","NS","SW");     
    public Scheduler() {    
        super();    
        light.light();        
        ScheduledExecutorService constrollTimer =Executors.newScheduledThreadPool(1);    
        constrollTimer.scheduleAtFixedRate(    
                new Runnable(){    
                    @Override    
                    public void run() {    
                        light = light.change();       
                            
                    }                       
                },45,45,     //green light time
                TimeUnit.MILLISECONDS);    
    }    
    
}  