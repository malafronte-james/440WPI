/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfiles;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author John
 */
public class FileData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File myfile = new File("C:/Users/John/Documents/test.txt");
        
        if (myfile.createNewFile()){
            System.out.println("Empty File Successfully Created");
        }
        else{
            System.out.println("File already exists");
        }
        
        String file_path = "C:/Users/John/Documents/";
        String file_name = "test.txt";
        
        String myList[] = {"house", "cars", "boat"};
        
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
        
        WriteFile data = new WriteFile(file_path + file_name, true);
        for (String str: myList){
        data.writeToFile(str);
        }
        System.out.println("File has been edited");
    }
    
}
