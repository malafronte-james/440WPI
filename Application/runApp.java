package Application;

/**
 * @author jmalafronte
 * Controls all GUIs
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import Data.*;
import GUI.*;
import SPI.*;
import Utilities.*;


public class runApp implements ActionListener, Observer
{
	TPIGUI main;
	GUI_Monitor monitor = new GUI_Monitor();
	GUIEndScreen endScreen = new GUIEndScreen();
	MainLoop loop;
	TempData data;
	WriteFile file;
	long lStartTime, lEndTime;
	SpiConnector spi = new SpiConnector();
	
	public runApp()
	{
		data = new TempData();
		file = new WriteFile(data);
		main = new TPIGUI();
		main.setVisible(true);
		
		// add actionlistener to main.startbutton object
		main.conNextButton.addActionListener(this);
		main.homeNextButton.addActionListener(this);
		main.conRefreshButton.addActionListener(this);
		main.checkRefreshButton.addActionListener(this);
		monitor.Pause_Button.addActionListener(this);
		endScreen.homeButton.addActionListener(this);
		
								
	}
	
		   public void actionPerformed(ActionEvent e) { 
			   
			   if(e.getSource() == endScreen.homeButton)
			   {
				   //set main to visible
            	   main.setVisible(true);
            	   monitor.setVisible(false);
            	   endScreen.setVisible(false);	 
			   }
			   
				if(e.getSource() == main.homeNextButton)
				{
					 if (main.generalInfoText.getText().isEmpty()){
			                JOptionPane.showMessageDialog( main.tabbedPane,
			                        "Please Enter Test Info");
			                //setTitle("System Setup");
			                }
			                
			                else{
			                
			                main.tabbedPane.setSelectedIndex(1);
			                main.tabbedPane.setEnabledAt(1, true);
			                }
				} // end homeNextButton
			   
			   // application start button
			   if(e.getSource() == main.conNextButton)
			   {
				   // save all the data to temp
				   data.setHiThreshold(Float.parseFloat(main.hiThresholdField.getText()));
				   data.setLowThreshold(Float.parseFloat(main.lowThresholdField.getText()));
				   data.setNumberOfCells(main.numberOfCells);
				   data.setAbortVoltage(Float.parseFloat(main.abortVoltageField.getText()));
				   data.setBatteryVoltage(Float.parseFloat(main.batteryVoltageField.getText()));
				   data.setCellAlarmThreshold(Float.parseFloat(main.cellAlarmField.getText()));
				   data.setGeneralTestInformation(main.generalInfoText.getText());
				   
				   
				   main.setVisible(false);
				   monitor.setVisible(true);
				   
				   loop = new MainLoop(monitor, data, file);
				   loop.thresholds.addObserver(this);
				   loop.startLoop();
				   lStartTime = System.nanoTime();
				   
			   }
			   
				if(e.getSource() == main.checkRefreshButton || e.getSource() == main.conRefreshButton)
				{
					main.printVoltage(spi.getSpiData(main.numberOfCells));
		            JOptionPane.showMessageDialog( null,
		                    "Activity Log is refreshed");
		            
				} // end refreshButton
			   
			   if (e.getSource() == monitor.Pause_Button)
			   {
				  // loop.stopLoop();
	               int confirm = JOptionPane.showConfirmDialog(null, "Abort?", "Paused", JOptionPane.YES_NO_OPTION); 
	               
	               if (confirm == JOptionPane.YES_OPTION)
	               {
	            	   
	            	   loop.stopLoop();
	            	   
	                  //create summary gui    
	            	   main.setVisible(false);
	            	   monitor.setVisible(false);
	            	   endScreen.setVisible(true);	 
	            	   
	            		lEndTime = System.nanoTime();

	            		long difference = lEndTime - lStartTime;
	            		
	            		//format the elapsed time
	                    System.out.println("Total execution time: " +
	                            String.format("%d min, %d sec",
	                                    TimeUnit.NANOSECONDS.toHours(difference),
	                                    TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                            TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
	            		System.out.println("Elapsed MilliSeconds: " + difference/1000000);
	            			            		

	               }
	               
	               else {
	                  //resume loop
	            	  loop.startLoop();
           	   
	            			        
	               }
			   }	  

		}
	   
		public void update(Observable obs, Object obj)
		{
			
			// print out that it's out of threshold and at which cell
			System.out.println("out of threshold at " + obj);
			
			// pause the loop
			loop.pauseLoop();
			
			// alarm
			
			// abort?
		}

}