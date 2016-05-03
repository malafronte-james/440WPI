package SPI;
 
/**
 * 
 */

import static com.pi4j.wiringpi.Gpio.*;
import static com.pi4j.wiringpi.Spi.*;
import java.util.Arrays;

public class SpiConnector {
        //GUI TEST
        public static void testGUI(){
            System.out.println (" SPI RUNNING ");
    
        }

	static int ADEN = 0;
	static int SHEN = 1;
    static float AD_REF = 2.500F;
        
    static float spiOutputs;
    static float[] spiOutputArray;
      
	private static final int BIT_REVERSE_TABLE_256[] = {
	  0x00, 0x80, 0x40, 0xC0, 0x20, 0xA0, 0x60, 0xE0, 0x10, 0x90, 0x50, 0xD0, 0x30,
	  0x08, 0x88, 0x48, 0xC8, 0x28, 0xA8, 0x68, 0xE8, 0x18, 0x98, 0x58, 0xD8, 0x38,
	  0x04, 0x84, 0x44, 0xC4, 0x24, 0xA4, 0x64, 0xE4, 0x14, 0x94, 0x54, 0xD4, 0x34,
	  0x0C, 0x8C, 0x4C, 0xCC, 0x2C, 0xAC, 0x6C, 0xEC, 0x1C, 0x9C, 0x5C, 0xDC, 0x3C,
	  0x02, 0x82, 0x42, 0xC2, 0x22, 0xA2, 0x62, 0xE2, 0x12, 0x92, 0x52, 0xD2, 0x32,
	  0x0A, 0x8A, 0x4A, 0xCA, 0x2A, 0xAA, 0x6A, 0xEA, 0x1A, 0x9A, 0x5A, 0xDA, 0x3A,
	  0x06, 0x86, 0x46, 0xC6, 0x26, 0xA6, 0x66, 0xE6, 0x16, 0x96, 0x56, 0xD6, 0x36,
	  0x0E, 0x8E, 0x4E, 0xCE, 0x2E, 0xAE, 0x6E, 0xEE, 0x1E, 0x9E, 0x5E, 0xDE, 0x3E,
	  0x01, 0x81, 0x41, 0xC1, 0x21, 0xA1, 0x61, 0xE1, 0x11, 0x91, 0x51, 0xD1, 0x31,
	  0x09, 0x89, 0x49, 0xC9, 0x29, 0xA9, 0x69, 0xE9, 0x19, 0x99, 0x59, 0xD9, 0x39,
	  0x05, 0x85, 0x45, 0xC5, 0x25, 0xA5, 0x65, 0xE5, 0x15, 0x95, 0x55, 0xD5, 0x35,
	  0x0D, 0x8D, 0x4D, 0xCD, 0x2D, 0xAD, 0x6D, 0xED, 0x1D, 0x9D, 0x5D, 0xDD, 0x3D,
	  0x03, 0x83, 0x43, 0xC3, 0x23, 0xA3, 0x63, 0xE3, 0x13, 0x93, 0x53, 0xD3, 0x33,
	  0x0B, 0x8B, 0x4B, 0xCB, 0x2B, 0xAB, 0x6B, 0xEB, 0x1B, 0x9B, 0x5B, 0xDB, 0x3B,
	  0x07, 0x87, 0x47, 0xC7, 0x27, 0xA7, 0x67, 0xE7, 0x17, 0x97, 0x57, 0xD7, 0x37,
	  0x0F, 0x8F, 0x4F, 0xCF, 0x2F, 0xAF, 0x6F, 0xEF, 0x1F, 0x9F, 0x5F, 0xDF, 0x3F,
	}; 

	private static void strobe(int pin, int usec){
	  digitalWrite(pin, LOW);
	  delayMicroseconds(usec);
	  digitalWrite(pin, HIGH);
	}

	public static float[] getSpiData (int numCells){ 
           
           if (numCells == 0){
               numCells = numCells + 12;
           }
            
	   int fd1, result, i, j;
           j=0;
	   byte address;
	   byte[] buffer;
           buffer = new byte[100];
           
           short tmp_rdg;
	   short[] cell_rdgs;
           cell_rdgs = new short[12];
           float[] cell_values;
           cell_values = new float[12];
           
           
	   //int cell; // unsigned char
           //char cellChar = 0;
           
           byte cell;
	   
	   wiringPiSetup();
	   pinMode(ADEN, OUTPUT);
           pinMode(SHEN, OUTPUT);
	   digitalWrite(ADEN, LOW);
	   digitalWrite(SHEN, HIGH);

	   //System.out.printf("Initializing\n");

	   // Configure the interface.
	   
	   // 62500 indicates bus speed.
	   fd1 = wiringPiSPISetup(0, 62500);
	  
	   //System.out.printf("Init result SPI0: %d\n", fd1);
	  
	   
	   //System.out.printf("Reading Cell Voltages\n");
	   i=0;
	
        // reads first 6 cells, reads second 6 cells, repeats the process
           
	
	      // address box 1
	      address = 0;
	      buffer[0] = (byte)(0x00FF & BIT_REVERSE_TABLE_256[address]);
              //byte [] bufferByte = new byte[]{(byte)buffer[0]};
              //takes the buffer, writes it to SPI writing and reading at the same time
	      
              //0 = which SPI module you are using, a buffer that has a message in it, and also recieves any data, 1 = number of bytes you want to send
              result = wiringPiSPIDataRW(0, buffer, 1);
	      strobe(SHEN, 25);
	      delayMicroseconds(25);

	      // read cells
              // takes a 0x18 (setup for the A to D, or it with cell, 3 bit number between 0 and 7)
	      
              
              for(cell=0;cell<6;cell++){
                 buffer[0] = (byte) (0x18 | cell);
                 // sets up what order the bits come back in
	         buffer[1] = (byte) 0xE0;
                 // dummy variable 
	         buffer[2] = (byte) 0x00;
                //write the address enable high 
	         digitalWrite(ADEN, HIGH);
	         result = wiringPiSPIDataRW(0, buffer, 3);
                 //pull the usefull A to D data out of the buffer, value in byte 1, shift it 8 bits to the left and or it with byte 2
	         digitalWrite(ADEN, LOW);
	         cell_rdgs[cell] = (short) (0x0FFF & (buffer[1]) << 8 | (buffer[2]));
	         delayMicroseconds(100);
	      }
              // Next Adress - repeat same process
	      address = 1;
	      buffer[0] = (byte)(0x00FF & BIT_REVERSE_TABLE_256[address]);
	      result = wiringPiSPIDataRW(0, buffer, 1);
	      strobe(SHEN, 25);
	      delayMicroseconds(25);

	      for(cell=0;cell<6;cell++){
	         buffer[0] = (byte) (0x18 | cell);
	         buffer[1] = (byte) 0xE0;
	         buffer[2] = (byte) 0x00;

	        digitalWrite(ADEN, HIGH);
	         result = wiringPiSPIDataRW(0, buffer, 3);
	         digitalWrite(ADEN, LOW);
                 //cell_rdgs[cell+6] = (short)((short)buffer[1] & 0x0FFF);
                 cell_rdgs[cell+6] = (short) (0x0FFF & (buffer[1]) << 8 | (buffer[2]));
                 
                 // pointer is instead of a label like buffer, instead of a value, it has a memory address
                 // (*(buffer + 1) is the same as buffer[1] - getting whatever data is stored in buffer 1, and shifting it 8 bits to the left
                 // if a 2 d is 12 bits long, in memory you cant have 3 or 4 bits stored, so we have 2 bytes, each byte is 8 bits. can have anything for the first 4 bits
                 // buffer [1] << 8 gets the left value 
                 
                 
	         delayMicroseconds(100);
	      }
	      digitalWrite(ADEN, LOW);

	      try{
	      for(cell=0; cell < numCells; cell++){
	    	  
                 cell_values[cell] = cell_rdgs[cell] * (AD_REF / 4096);
                 spiOutputs = cell_values[cell];
                 //System.out.printf("Cell %d: %1.2f\n", cell+1, spiOutputs);
                // AmpeaterDisplay.appendDisplay(String.format("Cell %d: %1.2f\n", cell+1, spiOutputs));
                
              }
	      }catch(Exception e) {
	    	  System.out.println("Error happened in SPI Connector");
	      }
                //System.out.println("\nVoltage Reading Complete.");
                System.out.printf("\033[12A");
                     j++;
                
                spiOutputArray = cell_values;
                return spiOutputArray;
        }// end main

        /*public static float[] getSpiOutputs(float[] spiOutputs){
            System.out.println("getSpiOutputs running...");
            System.out.println(Arrays.toString(spiOutputs));
            AmpeaterDisplay.setDisplay(Arrays.toString(spiOutputs));
            System.out.println("getSpiOutputs Complete.");
            return spiOutputs;
            
        }*/
        
}
