/*
 * This program creates the file location and writes to file 
 */
package data;
import java.io.IOException;
import java.io.File;

/*
 * @author John
 */

public class DataStorage {

    /*
     * Creates .txt file in two locations
     */    
    public static void main(String[] args) throws IOException {
        
        /*
         * Creates 2 locations for data storage. Names can be anything
         */        
        File dataToFlashDrive = new File("C:/Users/John/Documents/test.txt");
        File dataToCard = new File("C:/Users/John/Documents/test1.txt");
        
        dataToFlashDrive.createNewFile();
        dataToCard.createNewFile();
        
        String file_path = "C:/Users/John/Documents/";
        String file_name = "test.txt";
        
        /*
         * Random array to test
         */
        String myList[] = {"house", "cars", "boat"};
        
        /*
         * Calls TempData to store data into an array
         * Needs changed to match once TempData is changed
         * or cut out entirely if not needed
         */        
        try{
            TempData file = new TempData(file_path + file_name);
            String[] aryLines = file.OpenFile();
            
            int i;
            for (i=0; i < aryLines.length; i++){
                System.out.println(aryLines[i]);
            }
        }
        catch (IOException e) {
            System.out.println( e.getMessage());
        }
        /*
         * WriteFile writes information to .txt file(s) created
         */        
        WriteFile data = new WriteFile(file_path + file_name, true);
        WriteFile data1 = new WriteFile(file_path + "test1.txt", true);
        data.writeToFile("Column1\tColumn2\tColumn3\r\n");
        data1.writeToFile("Column1\tColumn2\tColumn3\r\n");
        
        for (int i = 0; i < myList.length; i++) {
            if (i > 0){
                data.writeToFile("\t");
                data1.writeToFile("\t");
            }
            data.writeToFile(myList[i]);
            data1.writeToFile(myList[i]);
        }
        
        System.out.println("File has been edited");
    }
    
}
