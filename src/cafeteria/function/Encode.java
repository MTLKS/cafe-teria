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
public class Encode {
    private String encodedResult;
    private String decodedResult;
    
    public Encode(String str) {
            encodedResult = str.replace(" ",  "%20");
            decodedResult = str.replace("%20", " ");
    }
    
    public String getEncodedResult() {
        return encodedResult;
    }
    
    public String getDecodedResult() {
        return decodedResult;
    }
}
