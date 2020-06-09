/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ValidationChamps {
    public static boolean isTextFieldNotEmpty(TextArea tf){
        boolean b = false;
        if(tf.getText().length() != 0 || !tf.getText().isEmpty())
            b = true;
        return b;
    }
     public static boolean isTextFieldNotEmpty(ComboBox tf,String errorMessage){
        boolean b = false;
        String msg = null;
        if( !tf.getSelectionModel().isEmpty()){
            b = true;
            msg= errorMessage;
        } 
     
        return b;
        
    }
    
    
}
