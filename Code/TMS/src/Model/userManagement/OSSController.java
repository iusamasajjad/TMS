/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.userManagement;

import DataAccess.DataControl.DALManager;
import java.util.ArrayList;
import Model.dto.EmployeeDTO;
import Model.dto.Response;
import Model.validator.UserDTO;
import Model.validator.CommonValidator;
import ui.users.User;


public class OSSController {
    DALManager objDAL;
    public OSSController(){
    objDAL = SMSFactory.getInstanceOfDALManager();
    }

    public ArrayList<EmployeeDTO> viewEmployees(String searchKey) {
        return objDAL.getEmployeesList(searchKey);
    }

    public Response addEmployee(EmployeeDTO objEmp,UserDTO objuser) {
        Response objResponse = SMSFactory.getResponseInstance();
        CommonValidator.validateEmployee(objEmp,objuser,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveEmployee(objEmp,objResponse);
        }
        return objResponse;
    }

    public Response removeCitizen(String selectedId) {
        Response objResponse = SMSFactory.getResponseInstance();
        objDAL.removeCitizen(selectedId, objResponse);
        return objResponse;
    }

    public Response Authenticate(User objUser) {
        
        Response objResponse = SMSFactory.getResponseInstance();
        CommonValidator.validateUser(objUser,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.AuthenticateUser(objUser,objResponse);
        }
        return objResponse;
    }
}
