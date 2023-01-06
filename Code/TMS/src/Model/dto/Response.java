/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dto;

import java.util.ArrayList;


public class Response {
    public ArrayList<Message> messagesList;
    public Response(){ 
        messagesList = new ArrayList<>();
    }

    public boolean hasError() {
        for(Message m : messagesList)
        {
            if(m.Type == MessageType.Error || m.Type == MessageType.Exception)
                return true;
        }
        return false;
}

    public String getErrorMessages() {
        StringBuilder sb = new StringBuilder();    
        for(Message m : messagesList)
        {
           if(sb.length() > 0) 
               sb.append(",\n");
            if(m.Type == MessageType.Error || m.Type == MessageType.Exception)
                sb.append(m.Message);
        }
        return sb.toString();
    }

    public boolean isSuccessfull() {
        return !hasError();
    }

    public boolean hasWarning() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean hasInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
