package Application;

/**
 * @author jmalafronte
 * Controls all GUIs
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import Data.*;
import GUI.*;
import SPI.*;
import Utilities.*;


public class runApp implements ActionListener, ThresholdListener
{
	TPIGUI main;
	GUI_Monitor monitor = new GUI_Monitor();
	GUIEndScreen endScreen = new GUIEndScreen();
	MainLoop loop;
	TempData data;
	long lStartTime, lEndTime;
	
	public runApp()
	{
		main = new TPIGUI();
		main.setVisible(true);
		
		// add actionlistener to main.startbutton object
		main.conNextButton.addActionListener(this);
		monitor.Pause_Button.addActionListener(this);
		endScreen.homeButton.addActionListener(this);
				
	}
	
		   public void actionPerformed(ActionEvent e) { 
			   
			   if(e.getSource() == endScreen.homeButton)
			   {
            	   main.setVisible(true);
            	   monitor.setVisible(false);
            	   endScreen.setVisible(false);	 
			   }
			   
			   // application start button
			   if(e.getSource() == main.conNextButton)
			   {
				   
				   main.setVisible(false);
				   monitor.setVisible(true);
				   
				   loop = new MainLoop(monitor, data);
				   loop.startLoop();
				   lStartTime = System.nanoTime();
				   
			   }
			   
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
	            		
	            		// set mainLabel to elapsed time
	            		/*main.label.setText("Total execution time: " +
	                            String.format("%d min, %d sec",
	                                    TimeUnit.NANOSECONDS.toHours(difference),
	                                    TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                            TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
	            		
	            		monitor.counter = 0;
	            		monitor.label2.setText("");*/

	               }
	               
	               else {
	                  //resume loop
	            	   //loop.startLoop();
           	   
	            			        
	               }
			   }	  

		}
		   
		   
		@Override
		public void outOfThreshold(EventObject event) {
			
			//pause loop
			loop.pauseLoop();
			System.out.println("Out of threshold");
			
			//alert
		}
}