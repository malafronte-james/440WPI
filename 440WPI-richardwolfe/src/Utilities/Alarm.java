package Utilities;
import static com.pi4j.wiringpi.Gpio.*;

/**
 *
 * @author URAL
 */
/**
   Rough method which can be trigger alarm 
*/
public class Alarm
{ 
	boolean alarm;
	
   public Alarm(){
	   alarm = false;
     }
   
      private static void alarm(int pin, long usec){
	  digitalWrite(pin, false);
	  delayMicroseconds(usec);
	  digitalWrite(pin, LOW);
	  delayMicroseconds(usec);
	}

     
   //statrtAlarm(Short alarm);
   public void startLONGAlarm(){
      alarm = true;
      int pin = 16;
      alarm ( pin, 0); 
   
   }
   
   //startAlarm(Long alarm);
   public void startSHORTAlarm(){
      alarm = true;
      int pin = 18;
      alarm (pin, 0); 
   }
   //stopAlarm
   public void stopAlarm(){
      alarm = false;
   }
   
   
}

