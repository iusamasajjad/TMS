/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.validator;

import Model.dto.CitizenDTO;
import Model.dto.Message;
import Model.dto.MessageType;
import Model.dto.Response;


public class CommonValidator {

    public static void validateEmployee(CitizenDTO objEmp, Response objResponse) {
        if(objEmp.FirstName == null || objEmp.FirstName.length() < 3){
            objResponse.messagesList.add(new Message("FIrst Name is not valid, Provide valid first name with at least 3 characters.",MessageType.Error));
        }else if(objEmp.Address.length() <10){
            objResponse.messagesList.add(new Message("Address is not valid, Provide valid Address with at least 10 characters.",MessageType.Error));
        }else if(objEmp.Country.length() <4){
            objResponse.messagesList.add(new Message("Country is not valid, Provide valid Country with at least 3 characters.",MessageType.Error));
        }else if(objEmp.BirthDate == null){
            objResponse.messagesList.add(new Message("Birth Date is not valid, Provide valid Birth Date.",MessageType.Error));
        }else if(objEmp.Title == null){
            objResponse.messagesList.add(new Message("Title is not valid, Provide valid Title.",MessageType.Error));
        }else if(objEmp.City == null){
            objResponse.messagesList.add(new Message("City should not null, Provide valid City.",MessageType.Error));
        }
        // Todo validate the rest
    }
    
}
