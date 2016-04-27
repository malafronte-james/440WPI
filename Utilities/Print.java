package Utilities;
import static com.pi4j.wiringpi.Gpio.*;


// Name(s): Stephen Toms   





/**
   Rough method which can be improved for Printing a table of battery voltage
*/
public class Print
{ 
   public static void main(String[] args)
   {
   
     int hours = 01;
     int min = 10;
     int sec = 45;
     boolean print = true;
     int wait = 2000; //wait 2sec by default
     double sumVolts = 0;
     // array that has all of the battery voltages
     double[] volts = new double[]{1.00004, 2.98, 3.4, 5.50, 4.466, 1.00004, 2.98, 3.4, 5.50, 4.466, 1.00004, 2.98, 3.4, 5.50, 4.466, 1.00004, 2.98, 3.4, 5.50, 4.466}; 
     
	 	  
     for(int i = 0; i < volts.length; i++){
         sumVolts += volts[i];
     
     }   
        
     System.out.println(sumVolts);
        
        
        
     //our print method
     
     while(print){
         Print1(volts, hours, min, sec);
         try{
           Thread.sleep(wait);
         }catch(InterruptedException ex){
           //do stuff
         }
     }
    
   }
   
   public static void Print1(double[] volts, int hours, int min, int sec){
     
      //Print Time XX:XX:XX Hr:Min:Sec
      System.out.print("\nTime: " + hours + ":" + min + ":" + sec); 
      
      System.out.print("\nCELL VOLTAGE 1 TO 20: \n");
     
      //batteries 1-5
      System.out.printf("%.2f" + "\t" + "%.2f"+ "\t" + "%.2f" + "\t" + "%.2f" + "\t" + "%.2f", volts[0], volts[1], volts[2], volts[3], volts[4]);
      
      //batteries 6-10
      System.out.printf("\n" + "%.2f" + "\t" + "%.2f"+ "\t" + "%.2f" + "\t" + "%.2f" + "\t" + "%.2f", volts[5], volts[6], volts[7], volts[8], volts[9]);
      
      //batteries 11-15
      System.out.printf("\n" + "%.2f" + "\t" + "%.2f"+ "\t" + "%.2f" + "\t" + "%.2f" + "\t" + "%.2f", volts[10], volts[11], volts[12], volts[13], volts[14]);
      
      //batteries 15-20
      System.out.printf("\n" + "%.2f" + "\t" + "%.2f"+ "\t" + "%.2f" + "\t" + "%.2f" + "\t" + "%.2f", volts[15], volts[16], volts[17], volts[18], volts[19]);
            
   }
   
   
   public static void printStart(boolean print, int delay, int pin){
      print = true;
	  digitalWrite(pin, false);
	  delayMicroseconds(delay);
	  digitalWrite(pin, 1);
	  delayMicroseconds(delay);
   }
   
   
   public static void printStop(boolean print, int delay, int pin){
      print = false;
	  digitalWrite(pin, false);
	  delayMicroseconds(delay);
	  digitalWrite(pin, 0);
	  delayMicroseconds(delay);
   }
   
   
}
