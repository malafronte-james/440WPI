// Name(s): Stephen Toms   
// Date: 11/19/15
// Lab 8

// imports
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;




/**
   Author Stephen Toms
*/

/** 
     ex:
     Test 1, Time 20:13,18 5 Cells
        1,   2,   3,   4,   5
     2.50,1.50,0.45,2.50,2.50
     2.50,1.50,0.45,2.50,2.50
     2.50,1.50,0.45,2.50,2.50
     2.50,1.50,0.45,2.50,2.50
*/


public class WriteFile
{ 


   // Construct the Scanner and PrintWriter objects for writing
   private static String outputFileName;
   private static PrintWriter out;

   // Example variables to demonstarte that the print method works by grabbing values from an array

   private static double[] results; // array to store the scores
   private static String userData;


   //Default Constructor that sets the output file as "results.txt"
   public WriteFile(){
      outputFileName = "results.txt";
      
      //must put in a try catch incase you user does not have permission to write 
      try
      {
           out = new PrintWriter(outputFileName);
      }
      catch (Exception e)
      {
           //Tell user that file was not created and why
           System.out.println("Could Not Write File: " + e);
      }
      
      
      
   }

     
     
  //Setters
  public static void setUserData(String d){
      userData = d;
  }
  
  public static void setCellData(double[] a){
      results = a;
  }
     
     
     
 
     
  public static void printHeader(){
     //Print out the userData for the test and a charater return to move to next line
     out.println(userData + "\n");
     
     //while loop to print header for each cells we are testing
     int i = 0;
     while(i < results.length){
         out.print("   " + (i + 1));
         if(i != results.length-1){
            out.print(",");
         }
         i++;
     }
     //move cursor to next line
     out.println(" ");
  } 
     
     
  public static void printData(){
      
      int curCell = 0; //variable to handle grabbing the current cell we are printing from the array
      
      while(curCell < results.length){
         
            out.printf("%.2f", results[curCell]);
            
            if(curCell != results.length-1){
               out.print(",");
            }
            
            curCell++;
            
            if(curCell == results.length){
               out.println("");
            }
            
            
       }
  
  }   
     
	 

   
   public static void stopWrite(){
      out.close();
   }
   
   
   
}
