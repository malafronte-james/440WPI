/*
 * Textfiles for data storage
 * 
 */
package textfiles;
import java.io.IOException;
import java.io.File;

/*
 * @author John
 */

public class FileData {

    /*
     * Creates .txt file in two locations
     */
    
    public static void main(String[] args) throws IOException {
        File myfile = new File("C:/Users/John/Documents/test.txt");
        File myfile1 = new File("C:/Users/John/Documents/test1.txt");
        
        myfile1.createNewFile();
        
        /*
         * Just tests that the file was created
         */
         
        if (myfile.createNewFile()){
            System.out.println("Empty File Successfully Created");
        }
        else{
            System.out.println("File already exists");
        }
        
        String file_path = "C:/Users/John/Documents/";
        String file_name = "test.txt";
        
        /*
         * Random string created to test
         */
         
        String myList[] = {"house", "cars", "boat"};
        
        /*
         * Calls read file to test if it works, readfile.java will eventually be deleted
         */
        
        try{
            ReadFile file = new ReadFile(file_path + file_name);
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
         * WriteFile writes information to .txt file created
         */
        
        WriteFile data = new WriteFile(file_path + file_name, true);
        WriteFile data1 = new WriteFile(file_path + "test1.txt", true);
        for (String str: myList){
        data.writeToFile(str);
        data1.writeToFile(str);
        }
        System.out.println("File has been edited");
    }
    
}
