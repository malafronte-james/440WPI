package Application;

/**
 * @author rmorales
 * @author jmalafronte
 * 
 * Controls loop for getting SPI data and writing to file.
 */

import java.util.*;
import GUI.*;
import Utilities.*;
import Data.*;
import SPI.*;

public class MainLoop{
	
	private Timer timer;
	GUI_Monitor display;
	TempData data;
    SpiConnector spi = new SpiConnector();
    Thresholds thresholds = new Thresholds();
    WriteFile file; 
    TimerTask mainLooper;
    int elapsedTime = 0;
    boolean max, min;
	
	public MainLoop(GUI_Monitor paramDisplay, TempData paramData, WriteFile paramfile)
	{
		display = paramDisplay;
		data = paramData;
		file = paramfile;
		
	}
	
	/**
	 * Start Loop
	 */
	public void startLoop()
	{
		 timer = new Timer();
		 
		 // print user/header data to file
         file.setUserData(data.getUserData()); 
         file.printHeader();
         
	     mainLooper = new TimerTask(){
	         //sets up following calls to be run as one task.
	             
	          public void run(){
	        	  
	     
	            //spi.getSpiData(data.getNumberOfCells());
	            //passes gui data to spi.

	            float[] cellData = spi.getSpiData(data.getNumberOfCells());
	            
	            file.setCellData(cellData);
	            System.out.println("Printing to file...");
	            file.printData();
	            

	        	  // check thresholds for each cell
	             for (int i=0; i<data.getNumberOfCells(); i++){
	                min = thresholds.checkLowThresholds(data.getLowThreshold(), i+1, cellData[i]);                  
	                max = thresholds.checkHiThresholds(data.getHiThreshold(), i+1, cellData[i]);                    
	                    
	                }//end for loop             
	             
	              // passes spi data to monitor gui.
	        	  display.duration.setText(elapsedTime + "s");
	        	  elapsedTime++;
	        	  display.repaint();
	        	  
	          } 
	         };
	         
	       // runs task every second
	       timer.schedule(mainLooper, 0, 1000);
	         
	}
	
	/**
	 * Stop Loop
	 */
	public void stopLoop()
	{
		timer.cancel();
	}
	
	/**
	 * Pause Loop
	 */
	public void pauseLoop()
	{
		stopLoop();
	}
	
	/**
	 * Resume Loop
	 */
	public void resumeLoop()
	{
		startLoop();
	}

    
}
//end mainLoop