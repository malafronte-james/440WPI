package Application;

import java.util.*;
import GUI.*;
import Utilities.*;
import Data.*;
import SPI.*;

public class MainLoop {
	
	private Timer timer;
	GUI_Monitor display;
	TempData data;
    SpiConnector spi = new SpiConnector();
    //Thresholds thresholds = new Thresholds();
    WriteFile file; 
    TimerTask mainLooper;
    int elapsedTime = 0;
    ThresholdListener k = null;
	
	public MainLoop(GUI_Monitor paramDisplay, TempData paramData)
	{
		display = paramDisplay;
		data = paramData;
		
	}
	
	public void startLoop()
	{
		 timer = new Timer();
	     mainLooper = new TimerTask(){
	         //sets up following calls to be run as one task.
	            
	        //	file.setUserData(data.UserData); 
	        //	file.printHeader();
	             
	          public void run(){
	        	  
	     
	           // spi.getSpiData(data.getNumberOfCells);
	            //passes gui data to spi.

	           // float[] cellData = spi.getSpiData(data.getNumberOfCells);
	            
	           // file.setCellData(cellData);
	          //  file.printData();
	            
	        	  
	              // Notify everybody that may be interested.

	        	  for (int i=0; i<8; i++){
	             //for (int i=0; i<numCells; i++){
	                thresholds.checkMinThresholds(userMinVoltage, i+1, cellData[i]);
	                    if(thresholds.checkMinThresholds = false){
	                       
	                  	
	                    } // endif
	                thresholds.checkMaxThresholds(userMaxVoltage, i+1, cellData[i]);
	                    if(thresholds.checkMaxThresholds = false){
		              		
	                    }//endif
	                    
	                }//end for loop
	            
	           // display.Monitor(cellData);
	          // passes spi data to monitor gui.
	        	  display.duration.setText(elapsedTime + "s");
	        	  elapsedTime++;
	        	  display.repaint();
	        	  
	          } 
	         };
	         
	         timer.schedule(mainLooper, 0, 1000);
	         //runs task every sec
	}
	
	public void stopLoop()
	{
		timer.cancel();
	}
	
	/**
	 * 
	 */
	public void pauseLoop()
	{
		stopLoop();
	}
	
	/**
	 * 
	 */
	public void resumeLoop()
	{
		startLoop();
	}

    
}
//end mainLoop