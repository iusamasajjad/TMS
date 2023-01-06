/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.Warden;

import Model.validator.*;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Model.dto.Response;

/**
 *
 * @author Mukhtiar-HPC
 */
public class CommonHandler {

    public static void handleResponse(Response objResponse,JComponent uiComponent) {
        if(objResponse.hasError()){
            if(uiComponent instanceof JLabel){
                ((JLabel)uiComponent).setText(objResponse.getErrorMessages());
                ((JLabel)uiComponent).setForeground(Color.RED);
            }
        }
    }
    
}
