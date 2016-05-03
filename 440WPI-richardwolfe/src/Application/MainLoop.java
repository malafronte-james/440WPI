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
    
    String cellStr = "";
    
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
         file.setUserData(data.getGeneralTestInformation()); 
         file.setCellNum(data.getNumberOfCells());
         file.printHeader();
         
	     mainLooper = new TimerTask(){
	         //sets up following calls to be run as one task.
	             
	          public void run(){
	        	  
	        	// update gui fields
	        	display.tCompleted.setText("False");
	        	
	        	
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
                       for (int z=0; z<cellData.length; z++){
                            int q = (z+1);
                            
                            String w = Integer.toString(q);
                            String cellDataString = Float.toString(cellData[z]);
                            
                            cellStr += ("Cell " + w + ": " + cellDataString + "  \n");
                            
                            
                            
                            //display.appendVoltageArea("Cell " + q + ": " + cellData[z] + "  \n");
                        }
                      
                            display.setVoltageArea(cellStr);
                            cellStr = "";
                       
                           
                           
                           
                           
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
	public void stopFileWrite()
	{
                System.out.println("StopWrite started...");
                file.stopWrite();
                System.out.println("StopWrite complete");
	}
	
	/**
	 * Pause Loop
	 */
	public void stopLoop()
	{
		timer.cancel();
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