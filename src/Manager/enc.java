/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author I.O.I
 */
public class enc {
    public static boolean checkPassword(String passwordText, String DbHash) {
        
        boolean password_verified = false;
        DbHash = DbHash.substring(0,2)+'a'+DbHash.substring(3);
        if (null == DbHash || !DbHash.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }
        password_verified = BCrypt.checkpw(passwordText, DbHash);
        return (password_verified);
    }
    public static String encryptPassword(String password){
        String pw = BCrypt.hashpw(password, BCrypt.gensalt());
        pw = pw.substring(0,2)+'y'+pw.substring(3);
        return pw;
    }
    
}
