import java.util.*;

public class mainLoop {

    public void runLoop(TempData data) {
    //bring data collected from gui.
             
     SpiConnector spi = new SpiConnector();
     Thresholds thresholds = new Thresholds();
     WriteFile w = new WriteFile(); 
     MonitorGui display = new MonitorGui();
     Pause pause = new Pause
     
     Timer t = new Timer();
     TimerTask mainLooper = new TimerTask(){
     //sets up following calls to be run as one task.
        
        w.setUserData(data.UserData); 
        w.printHeader();
         
      public void run(){
 
        spi.getSpiData(data.getNumberOfCells);
        //passes gui data to spi.

        float[] cellData = spi.getSpiData(numCells);
        
        w.setCellData(cellData);
        w.printData();
        
         for (int i=0); i<numCells; i++){
            thresholds.checkMinThresholds(userMinVoltage, i+1, cellData[i]);
                if(thresholds.checkMinThresholds = false){
                   pause.pauseLoop(); 
                }//endif
            thresholds.checkMaxThresholds(userMaxVoltage, i+1, cellData[i]);
                if(thresholds.checkMaxThresholds = false){
                    pause.pauseLoop();
                }//endif
            }//end for loop
        
        display.Monitor(cellData);
      }// passes spi data to monitor gui.
        
     };
     
     t.schedule(mainLooper, 0, 1000);
     //runs task every sec
   }
    
}
//end mainLoop