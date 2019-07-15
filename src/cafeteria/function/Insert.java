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
public class Insert {
    public boolean insert(String file, String line) {
        File f = new File("./files/" + file);
        
        String tempArray[] = line.split(";");
        Select sel = new Select();
        sel.select(file, tempArray[0], 0, false);
        if (sel.getResult() == null) {
            try {
                PrintWriter pw;
                pw = new PrintWriter(new FileWriter(f, true));
                pw.println(line);
                pw.close();
                System.out.println("Insert: success");
                return true;
            } catch (IOException ex) {
                System.out.println("Insert: fail");
                return false;
            }    
        } else {
            System.out.println("Insert: Line not unique");
            return false;
        }
    }
    
    public boolean insert(String file, String line, int x) {
        File f = new File("./files/" + file);
        
        String tempArray[] = line.split(";");
        
        try {
            PrintWriter pw;
            pw = new PrintWriter(new FileWriter(f, true));
            pw.println(line);
            pw.close();
            System.out.println("Insert: success");
            return true;
        } catch (IOException ex) {
            System.out.println("Insert: fail");
            return false;
        }    
    }
}
