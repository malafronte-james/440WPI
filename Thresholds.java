/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPI;

/**
 *
 * @author Richard
 */
public class Thresholds {
    
    
    /*float[] cellData = spi.getSpiData(numCells); 
     for (int i=0; i<numCells; i++){
         Thresholds.checkMaxThresholds(userdataforMaxVoltage, i+1, cellData[i]);
         Thresholds.checkMinThresholds(userdataforMaxVoltage, i+1, cellData[i]);
     }*/
   
    
    public static boolean checkMaxThresholds(float max, int cellNum, float voltage){
            
            if(voltage <= max){ 
                return true;
            }
            else{
                return false;
            }
    } // end max
    
    public static boolean checkMinThresholds(float min, int cellNum, float voltage){
        
            if(voltage >= min){
                return true;
            }
            else{
                return false;
            }
    } // end min
    
} // end class
