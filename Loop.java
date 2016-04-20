import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Loop {

	private Timer timer;
	JFrame2 refFrame;
	TimerTask mainLoop;
	Date time;
	
	public Loop(JFrame2 frame)
	{
		refFrame = frame;
	}
	
	public void startLoop()
	{
		timer = new Timer();		
		mainLoop = new TimerTask() {
			
            public void run(){

    			time = new Date();
    			refFrame.label.setText(time.toString());
    			refFrame.repaint();
                
            }
            
        }; // end timer task
        
		timer.schedule(mainLoop, 0 /*starts now*/, 1000 /* every second */);
		
	}
	
	public void stopLoop()
	{
		timer.cancel();
	}
	
	public void pauseLoop()
	{
		timer.cancel();
	}
	
	public void resumeLoop()
	{
		
	}
}
