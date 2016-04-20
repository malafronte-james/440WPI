import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class runApp implements ActionListener
{
	JFrame1 main;
	JFrame2 monitor = new JFrame2();
	Loop loop;
	long lStartTime, lEndTime;
	
	public runApp()
	{
		main = new JFrame1();
		
		// add actionlistener to main.startbutton object
		main.startButton.addActionListener(this);
		monitor.pauseButton.addActionListener(this);
				
	}
		   public void actionPerformed(ActionEvent e) { 
			   if(e.getSource() == main.startButton)
			   {
				   
				   main.setVisible(false);
				   monitor.setVisible(true);
				   
				   loop = new Loop(monitor);
				   loop.startLoop();
				   lStartTime = System.nanoTime();
				   
			   }
			   
			   if (e.getSource() == monitor.pauseButton)
			   {
				   loop.stopLoop();
	               int confirm = JOptionPane.showConfirmDialog(null, "Abort?", "Paused", JOptionPane.YES_NO_OPTION); 
	               
	               if (confirm == JOptionPane.YES_OPTION)
	               {
	                  //create summary gui    
	            	   main.setVisible(true);
	            	   monitor.setVisible(false);
	            	   
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
	            		main.label.setText("Total execution time: " +
	                            String.format("%d min, %d sec",
	                                    TimeUnit.NANOSECONDS.toHours(difference),
	                                    TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                            TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
	            		
	            		monitor.counter = 0;
	            		monitor.label2.setText("");

	               }
	               
	               else {
	                  //resume loop
	            	   loop.startLoop();
	            			        
	               }
			   }	  

		}
}
