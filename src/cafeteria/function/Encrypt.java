/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria.function;

import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 *
 * @author Matthew
 */
public class Encrypt {
    String hash;
    
    public Encrypt(String pass) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
            hash = bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("NoSuchAlgo");
        }
    }
    
    private String bytesToHex(byte[] hash) { 
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
        String hex = Integer.toHexString(0xff & hash[i]);
        if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    
    public String getHash() { 
        return hash;
    }
}
