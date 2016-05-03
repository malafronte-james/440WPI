package SPI;

import java.util.Observable;

/**
 *
 * @author Richard
 * @author JMalafronte
 * Checks thresholds
 */

public class Thresholds extends Observable{
    
	/**
	 * Check max Threshold
	 * @param max user set max
	 * @param cellNum cell number
	 * @param voltage voltage from SPI
	 * @return if it's in threshold or not
	 */
    public boolean checkLowThresholds(float max, int cellNum, float voltage){
            
            if(voltage <= max){ 
                return true;
            }
            else{
            	setChanged();
            	//notifyObservers(cellNum);
                return false;
            }
            
    } // end max
    
    /**
     * Check min Threshold
     * @param min user set min
     * @param cellNum cell number
     * @param voltage voltage from SPI
     * @return if it's in threshold or not
     */
    public boolean checkHiThresholds(float min, int cellNum, float voltage){
        
            if(voltage >= min){
                return true;
            }
            else{
            	setChanged();
            	//notifyObservers(cellNum);
                return false;
            }
            
    } // end min
    
} // end class
