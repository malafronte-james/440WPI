package Data;

//Name(s): Stephen Toms
//Edited by: John Bach
//Date: 4/20/16

//imports
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
private static String outputFileName2;
private static PrintWriter out;
private static PrintWriter out2;

// Example variables to demonstrate that the print method works by grabbing values from an array

private float[] results; // array to store the cellData
private String userData;


//Default Constructor that sets the output file as "results.txt"
public WriteFile(TempData data){
   outputFileName = "/media/DISK_IMG/TPI_Output/results.txt";
   outputFileName2 = "/media/DISK_IMG/TPI_Output/results1.txt";
   userData = data.getUserData();
   
   //must put in a try catch incase you user does not have permission to write 
   try
   {
        out = new PrintWriter(outputFileName);
        out2 = new PrintWriter(outputFileName2);
   }
   catch (Exception e)
   {
        //Tell user that file was not created and why
        System.out.println("Could Not Write File: " + e);
   }
   
   
   
}

//Setters
public void setUserData(String d){
	try{
		userData = d;
	} catch(Exception e){
		System.out.println(e.getClass().getName() + " has an error.");
	}
}

public void setCellData(float[] a){
	try{
		   results = a;
	} catch(Exception e){
		System.out.println(e.getClass().getName() + " has an error.");
	}

}
  
public void printHeader(){
  //Print out the userData for the test and a character return to move to next line
  out.println(userData + "\n");
  out2.println(userData + "\n");
  
  //while loop to print header for each cells we are testing
  int i = 0;
  while(i < results.length){
      out.print("Cell " + (i + 1));
      out2.print("Cell " + (i + 1));
      if(i != results.length-1){
         out.print("\t");
         out2.print("\t");
      }
      i++;
  }
  //move cursor to next line
  out.println(" ");
  out2.println(" ");
} 
  
  
public void printData(){
   
   int curCell = 0; //variable to handle grabbing the current cell we are printing from the array
   
   while(curCell < results.length){
      
         out.printf("%.2f", results[curCell]);
         out2.printf("%.2f", results[curCell]);
         
         if(curCell != results.length-1){
            out.print("\t");
            out2.print("\t");
         }
         
         curCell++;
         
         if(curCell == results.length){
            out.println("");
            out2.println("");
         }
         
         
    }

}   
  
	 


public void stopWrite(){
   out.close();
   out2.close();
}



}