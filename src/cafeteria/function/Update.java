/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.function;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Matthew
 */
public class Update {
    public boolean update(String file, String item, int index, String newLine) {
        File f = new File("./files/" + file);
        File temp = new File("./files/temp.txt");
        Select sel = new Select();
        Select selNew = new Select();
        Insert ins = new Insert();
        
        sel.select(file, item, index, false);
        selNew.select(file, newLine);
        
        if (sel.getResult() == null) {
            System.out.println("Update: Item not found");
            return false;
        } else if (selNew.getResult() != null) {
            System.out.println("Update: New line not unique");
            return false;
        } else {
            try {
                Scanner input = new Scanner(f);
                
                while (input.hasNext()) {
                    String record = input.next();
                    if (!record.equals(sel.getResult())) {    
                        ins.insert("temp.txt", record);
                    } else {
                        ins.insert("temp.txt", newLine);
                    }
                }
                
                input.close();
                
                if (!f.delete()) {
                    System.out.println("Update: File not deleted");
                    return false;
                }
                if (!temp.renameTo(f)) {
                    System.out.println("Update: File not renamed");
                    return false;
                }
                
                System.out.println("Update: Success");
                return true;
            } catch(FileNotFoundException ex) {
                System.out.println("Update: File not found");
                return false;
            } 
        }
    }
}
