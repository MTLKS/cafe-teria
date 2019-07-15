/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import cafeteria.function.*;

/**
 *
 * @author Matthew
 */
public class CafeMenuItem {
    private String name, desc, type;
    private double price;
    private Update upd = new Update();
    
    public CafeMenuItem(String name, String desc, double price, String type) {
        Encode encoName = new Encode(name);
        Encode encoDesc = new Encode(desc);
        
        this.name = encoName.getEncodedResult();
        this.desc = encoDesc.getEncodedResult();
        this.price = price;
        this.type = type;
    }
    
    public CafeMenuItem(String line) {
        String[] array = line.split(";");
        
        Encode encoName = new Encode(array[0]);
        Encode encoDesc = new Encode(array[1]);
        
        this.name = encoName.getEncodedResult();
        this.desc = encoDesc.getEncodedResult();
        this.price = Double.parseDouble(array[2]);
        this.type = array[3];
    }
    
    public void setName(String name) {
        Encode encoName = new Encode(name);
        this.name = encoName.getEncodedResult();
    }
    
    public void setDescription(String desc) {
        Encode encoDesc = new Encode(desc);
        this.desc = encoDesc.getEncodedResult();
    }
    
    public String getName() {
        Encode encoName = new Encode(name);
        return encoName.getDecodedResult();
    }
    
    public String getDesc() {
        Encode encoDesc = new Encode(desc);
        return encoDesc.getDecodedResult();
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
    
    public boolean insert() {
        Insert ins = new Insert();
        boolean status = ins.insert("menu.txt", this.toString());
        return status;
    }
    
    public boolean update() {
        boolean status = upd.update("menu.txt", name, 0, this.toString());
        return status;
    }
    
    public boolean update(CafeMenuItem menuItem) {
        boolean status = upd.update("menu.txt", name, 0, menuItem.toString());
        return status;
    }
    
    public boolean delete() {
        Delete del = new Delete();
        boolean status = del.delete("menu.txt", name, 0);
        return status;
    }
    
    @Override
    public String toString() {
        return name + ";" + desc + ";" + price + ";" + type;
    }
}
