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
import java.util.Scanner;
public class Delete {
    public boolean delete(String file, String item, int index) {
        File f = new File("./files/" + file);
        File temp = new File("./files/temp.txt");
        Select sel = new Select();
        sel.select(file, item, index, false);
        
        if (sel.getResult() != null) {
            try {
                Scanner input = new Scanner(f);
                
                while (input.hasNext()) {
                    String record = input.next();
                    if (!record.equals(sel.getResult())) {
                        Insert ins = new Insert();
                        ins.insert("temp.txt", record);
                    }
                }
                
                input.close();
                
                if (!f.delete()) {
                    System.out.println("Delete: File not deleted");
                    return false;
                }
                if (!temp.renameTo(f)) {
                    System.out.println("Delete: File not renamed");
                    return false;
                }
                
                return true;
            } catch(FileNotFoundException ex) {
                System.out.println("Delete: File not found");
                return false;
            }         
        } else {
            System.out.println("Delete: Item not found");
            return false;
        }
    }
}
