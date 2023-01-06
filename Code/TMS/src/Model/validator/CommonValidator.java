/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.validator;

import Model.dto.EmployeeDTO;
import Model.validator.UserDTO;
import Model.dto.Message;
import Model.dto.MessageType;
import Model.dto.Response;
import Model.userManagement.SMSFactory;
import ui.users.User;


public class CommonValidator {

    public static void validateEmployee(EmployeeDTO objEmp,UserDTO objuser, Response objResponse) {
        if(objEmp.FirstName == null || objEmp.FirstName.length() < 3){
            objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
        }else if(objEmp.LastName.length() <10){
            objResponse.messagesList.add(new Message("Address is not valid, Provide valid Address with at least 10 characters.",MessageType.Error));
        }else if(objuser.Email.length() <4){
            objResponse.messagesList.add(new Message("Country is not valid, Provide valid Country with at least 3 characters.",MessageType.Error));
        }else if(objuser.Username == null){
            objResponse.messagesList.add(new Message("Birth Date is not valid, Provide valid Birth Date.",MessageType.Error));
        }else if(objuser.Password == null){
            objResponse.messagesList.add(new Message("Title is not valid, Provide valid Title.",MessageType.Error));
        }else if(objEmp.Id == null){
            objResponse.messagesList.add(new Message("City should not null, Provide valid City.",MessageType.Error));
        }
        // Todo validate the rest
    }

    public static void validateUser(User objUser, Response objResponse) {
        if(objUser.username==null || objUser.password==null){
            Message msg =SMSFactory.getInstanceOfMessage();
            msg.Message="Username or Password cannot be null";
            msg.Type=MessageType.Error;
            objResponse.messagesList.add(msg);
        }
    }
    
}
