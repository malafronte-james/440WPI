import java.util.*;

public class mainLoop {

    public void runLoop(TempData data) {
    //bring data collected from gui.
             
     SpiConnector spi = new SpiConnector();
     Thresholds thresholds = new Thresholds();

     //WriteFile w = new WriteFile(data.getFilePath()); 
     Pause pause = new Pause();
     MonitorGui display = new MonitorGui();
     
     Timer t = new Timer();
     TimerTask mainLooper = new TimerTask(){
     //sets up following calls to be run as one task.
         
      public void run(){
          
        spi.getSpiData(data.getNumberOfCells);

        float[] cellData = spi.getSpiData(numCells);
        
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
        
        display.Monitor.textBox.setText(String.parseText(cellData));
      }
        
     };
     
     t.schedule(mainLooper, 0, 1000);
     //runs task every sec
   }
    
}
