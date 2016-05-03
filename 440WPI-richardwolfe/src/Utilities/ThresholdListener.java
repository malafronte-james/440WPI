package Utilities;

import java.util.EventObject;

/**
 * To listen for out of threshold notifications
 * @author jmalafronte
 *
 */
public interface ThresholdListener 
{
	public void outOfThreshold(EventObject e);
	
}
