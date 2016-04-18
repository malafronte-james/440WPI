
package ampeater;

import java.util.*;

public class mainLoop {

    public static void main(String[] args) {

             
     SpiConnector spi = new SpiConnector();
     Thresholds thresholds = new Thresholds();
     Printer p = new Printer();
     TempData data = new TempData();
     //WriteFile w = new WriteFile(data.getFilePath()); 
     Pause pause = new Pause();
     MonitorGui display = new MonitorGui();
     
     Timer t = new Timer();
     TimerTask mainLooper = new TimerTask(){
     
      public void run(){
          
        spi.getSpiData(data.getNumberOfCells);

        float[] cellData = spi.getSpiData(numCells);
        
        w.Write(cellData);
        
         for (int i=0); i<numCells; i++){
            thresholds.checkMinThresholds(userMinVoltage, i+1, cellData[i]);
                if(thresholds.checkMinThresholds = false){
                   pause.checkPause(); 
                }//endif
            thresholds.checkMaxThresholds(userMaxVoltage, i+1, cellData[i]);
                if(thresholds.checkMaxThresholds = false){
                    pause.checkPause();
                }//endif
            }//end for loop
        
        
        p.Printer();
        
        display.Monitor(cellData);
      }
        
     };
     
     t.schedule(mainLooper, 1000, 1000);
     
   }
    
}
