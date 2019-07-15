/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.function;

/**
 *
 * @author Matthew
 */
import java.io.*;
import java.util.*;
public class Select {
    private String result;
    private ArrayList<String> array = new ArrayList();
    
    public boolean select(String file, String item, int index, boolean contain) {
        File f = new File("./files/" + file); //append file name to file dir
        result = null; //reset
        array = new ArrayList(); //reset
        
        try {
            try {
                f.createNewFile(); //create new file if not already created
            } catch (IOException ex) {
                System.out.println("Select: Cant create file");
                return false;
            }
            Scanner input = new Scanner(f);
            
            while (input.hasNext()) {
                String record = input.next();
                String details[] = record.split(";");
                
                try {
                    if (details[index].contains(item) && contain) {
                        result = record;
                        array.add(record);
                    } else if (details[index].equals(item) && !contain) {
                        result = record;
                        array.add(record);
                    }
                } catch (ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Select: Array out of bounds");
                    return false;
                }
            }
            
            input.close();
            System.out.println("Select: success " + result);
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Select: File not found");
            return false;
        }       
    }
    
    public boolean select(String file, String line) {
        File f = new File("./files/" + file);      
        result = null;
        array = new ArrayList();
        
        try {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                System.out.println("Select: Cant create file");
                return false;
            }
            Scanner input = new Scanner(f);
            
            while (input.hasNext()) {
                String record = input.next();
                
                if (record.contains(line)) {
                    result = record;
                    array.add(record);
                }
            }
            
            input.close();
            System.out.println("Select: success " + result);
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Select: File not found");
            return false;
        }       
    }
    
    public String getResult() {
        return result;
    }
    
    public String getItem(int i) {
        String arrayResult[] = result.split(";");
        return arrayResult[i];
    }
    
    public ArrayList<String> getArray() {
        return array;
    }
}
