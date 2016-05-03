package Utilities;

import java.util.*;

public class ThresholdEventSource {
	
		  private List _listeners = new ArrayList();
		  
		  public synchronized void addThresholdListener(ThresholdListener listener)  {
		    _listeners.add(listener);
		  }
		  public synchronized void removeThresholdListener(ThresholdListener listener)   {
		    _listeners.remove(listener);
		  }
		 
		  // call this method whenever you want to notify
		  //the event listeners of the particular event
		  private synchronized void fireThresholdEvent() {
			  
		    ThresholdEvent event = new ThresholdEvent(this);
		    Iterator i = _listeners.iterator();
		    while(i.hasNext())  {
		      ((ThresholdListener) i.next()).outOfThreshold(event);
		      
		    }
		  }
}
