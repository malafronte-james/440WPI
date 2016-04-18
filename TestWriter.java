// Modified by: Stephen Toms
// Date Last Updated:  4/7/2016

// Source file: TestWriter.java
// Purpose: 

    public class TestWriter
   {
   
      
   
      public static void main (String args[])
      {
      
      
      
      //basic test varibales for the example loop
      
      boolean loop = true; //loop control variable
      int i = 0; //a variable to control a condition to terminate the loop
      double[] exArray = new double[] {2.40, 3.05, 5.70, 6.66, 8.30, 2.50, 2.50};
      String userData = "Test time: 1:45, Date: 4/13/2016, Testing " + exArray.length + " Cells";

      
               
      //Create the WriteFile Object and Open the Writing Stream
      WriteFile outFile = new WriteFile();            
    
      //Pass the user Data to the WriteFile Class
      outFile.setUserData(userData);
    
      //Pass the Cell Data to the WriteFile Class
      outFile.setCellData(exArray);
      
      //Print the header
      outFile.printHeader();
    
    
      //exmaple of a main loop
      while(loop){
      
      
         //set the array with new values
         outFile.setCellData(exArray);
      
         //within the main loop we call the printData() method so that it prints out only the array of values we want
         outFile.printData();
         
         
         
         //increment the variable handling the loop control method so that this test program terminates
         i++;
         
         //run this loop 10 times
         if(i > 9){
            loop = false;
         }
         
      }
      
      
      
      
      //Close the file stream
      //this will be called right when the program is ending/terminated
      //if this is called no data will be saved to the file
      outFile.stopWrite();
               
               
               
               
               
               
      }//end main
   
   }//end TestWriter