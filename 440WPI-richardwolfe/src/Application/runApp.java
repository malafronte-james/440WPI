package Application;

/**
 * @author jmalafronte
 * Controls all GUIs
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.EventObject;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import Data.*;
import GUI.*;
import SPI.*;
import Utilities.*;
import java.awt.Color;


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
	Double[][] tempArray;
        int pauseCount = 0;
	
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
                monitor.Abort.addActionListener(this);
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
				   System.out.println(data.getGeneralTestInformation());
				   //file.setCellData(spi.getSpiData(main.numberOfCells));
				   
				   main.setVisible(false);
				   monitor.setVisible(true);
				   
				   loop = new MainLoop(monitor, data, file);
				   loop.thresholds.addObserver(this);
				   loop.startLoop();
				   lStartTime = System.nanoTime();
				   
			   }
			   
				if(e.getSource() == main.checkRefreshButton || e.getSource() == main.conRefreshButton)
				{
					try{
						//System.out.println("Number of Cells: " + main.numberOfCells);
						
						float[] spiArray = spi.getSpiData(main.numberOfCells);
						//main.printVoltage(spi.getSpiData(main.numberOfCells));
						
						tempArray = new Double [main.numberOfCells] [2];
		                
		                int tempCell = 1;
		                
		                for (int i= 0; i < spiArray.length; i++){
		                     
		                    int j = 0;
		                    tempArray [i][j] = Double.valueOf(spiArray[i]);
		                    j++;
		                    tempArray [i][j] = Double.valueOf(tempCell);
		                    tempCell++;
		                }
						
						if (main.sortLowRadioButton.isSelected()){
			                
			                   final Comparator<Double[]> arrayComparator = new Comparator<Double[]>() {
			                    @Override
			                    public int compare(Double[] o1, Double[] o2) {
			                    return ((o1[0]).compareTo(o2[0]));
			                    }
			                };
			                Arrays.sort(tempArray, arrayComparator);
			                main.voltArea.setText("");
			                
			                for (int i= 0; i < tempArray.length; i++){
			                    
			                
			                main.voltArea.append("Cell : " + Math.round(tempArray [i][1]) + "    " + tempArray [i][0] + "   ");
			                //System.out.println("Cell : " + tempArray [i][1] + "    " + tempArray [i][0] + "   ");
			                
			                
			                 }
			                }
			                
			                else if (main.sortHighRadioButton.isSelected()){
			                
			                   final Comparator<Double[]> arrayComparatorDes = new Comparator<Double[]>() {
			                    @Override
			                    public int compare(Double[] o1, Double[] o2) {
			                    return ((o2[0]).compareTo(o1[0]));
			                    }
			                };
			                Arrays.sort(tempArray, arrayComparatorDes);
			                main.voltArea.setText("");
			                
			                for (int i= 0; i < tempArray.length; i++){
			                    
			                
			                main.voltArea.append("Cell " + Math.round(tempArray [i][1]) + ":    " + tempArray [i][0] + "   ");
			                //System.out.println("Cell " + tempArray [i][1] + ":    " + tempArray [i][0] + "   ");
			                
			                
			                 }
			                
			                }
			                
			                
			                else if (main.sortCellRadioButton.isSelected()){
			               
			                  main.voltArea.setText("");
			                  main.printVoltage(spiArray);
			                
			                }
						
						
					}
					catch (Exception e1)
					{
						main.voltArea.setText("No Data Available");
						e1.printStackTrace();
					}
					
		            JOptionPane.showMessageDialog( null,
		                    "Activity Log is refreshed");
		            
				} // end refreshButton
			   
			   
                          
                        if (e.getSource() == monitor.Pause_Button)
			   {
                             
                            if ((pauseCount % 2) == 0){
                                monitor.Pause_Button.setText("Resume");    
                                monitor.getContentPane().setBackground(Color.RED);
                                monitor.Abort.setVisible(true);
        
                                pauseCount++; 
                                
                                loop.stopLoop();
                                lEndTime = System.nanoTime();
                                
                                System.out.println("Loop Paused...");
                                System.out.println("Pause Count is: " + pauseCount);
       
                             }
        
                            else {
                                monitor.Pause_Button.setText("Pause ");    
                                monitor.getContentPane().setBackground(Color.WHITE);
                                monitor.Abort.setVisible(false);
                                    
                                pauseCount++;
                                
                                loop.resumeLoop();
                                System.out.println("Loop Resumed...");
                                System.out.println("Pause Count is: " + pauseCount);
            
                             } // end else
                            
                        } // end Pause Button Action Performed
            	   
			
	               
	               if (e.getSource() == monitor.Abort)
			   {
                               System.out.println("Abort Button Pressed...");
                               int dialogButton = JOptionPane.YES_NO_OPTION;
                               int dialogResult = (JOptionPane.showConfirmDialog(null,
                                "Do you really want to Abort the Test?", "Abort", dialogButton));
        
        
        
                            if (dialogResult == JOptionPane.YES_OPTION){
          
                                GUIEndScreen end = new GUIEndScreen();
                
                                    end.setResizable(false);
                                    end.setVisible( true );
                            
                                    System.out.println("Loop Aborted...");
                                    
                                    loop.stopFileWrite();
                                    
                                    pauseCount = 0;
                                    monitor.getContentPane().setBackground(Color.WHITE);
                                    
                                    
                                    monitor.Pause_Button.setText("Pause");
	            	   
                                    //create summary gui    
                                     main.setVisible(false);
                                    monitor.setVisible(false);
                                    endScreen.setVisible(true);	 

	            		long difference = lEndTime - lStartTime;
	            		
	            		// format the elapsed time and print to console
                                System.out.println("Total execution time: " +
	                            String.format("%d min, %d sec",
	                                    TimeUnit.NANOSECONDS.toMinutes(difference),
	                                    TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                            TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
	            		System.out.println("Elapsed MilliSeconds: " + difference/1000000);
	            			  
	            		// update test complete status
	            		endScreen.tComp.setText("Aborted");
	            		
	            		// update total elapsed time
	            		endScreen.tDuration.setText(
	                            String.format("%d min, %d sec",
	                                    TimeUnit.NANOSECONDS.toMinutes(difference),
	                                    TimeUnit.NANOSECONDS.toSeconds(difference) -
	                                            TimeUnit.MINUTES.toSeconds(TimeUnit.NANOSECONDS.toMinutes(difference))));
                            
                            } else {
                                
                                System.out.println("Abort Cancelled...");
           	   
                            } // end else
                        } // end Abort Action performed
                     
                } // end action performed
			     

		
	   
		public void update(Observable obs, Object obj)
		{
			
			// print out that it's out of threshold and at which cell
			System.out.println("out of threshold at " + obj);
			
			// pause the loop
			//loop.pauseLoop();
			
			// alarm
			
			// abort?
		}

}