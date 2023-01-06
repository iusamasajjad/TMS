/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.users;

import Model.dto.Message;
import Model.dto.MessageType;
import Model.userManagement.SMSFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.dto.Response;
import ui.dash;

/**
 *
 * @author Rafi
 */
public class Verify {
     public  void Verify(User objUser, Response objResponse, Connection dbConnection) {
        
               try{
                   if(dbConnection !=null) {
                       PreparedStatement p;
                       switch(objUser.username) {
                           case "admin":{
                               p = dbConnection.prepareStatement("Select * from users where userName=? and password=?;" );
                               p.setString(1,objUser.username);
                               p.setString(2, objUser.password);
                               ResultSet rs =p.executeQuery();
                               if(rs.next()){
                                   dash ob =new dash();
                                   ob.setVisible(true);  
                               }
                               else{ 
                                   Message msg =SMSFactory.getInstanceOfMessage();
                                   msg.Message="Login Failed! \n Username or Password is incorrect";
                                   msg.Type=MessageType.Error;
                                   objResponse.messagesList.add(msg);
                               } 
                               break;
                               }
                           default:
                               break;
                       }
                   }
                   dbConnection.close();
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Login Failed:User", MessageType.Error));
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="Login Failed! \n Username or Password is incorrect";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
    }
}
