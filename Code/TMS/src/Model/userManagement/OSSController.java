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
import Model.validator.CommonValidator;
import javax.swing.JOptionPane;


public class OSSController {
    DALManager objDAL;
    public OSSController(){
    objDAL = SMSFactory.getInstanceOfDALManager();
    }

    public ArrayList<EmployeeDTO> viewEmployees(String searchKey) {
        return objDAL.getEmployeesList(searchKey);
    }

    public Response addEmployee(EmployeeDTO objEmp) {
        Response objResponse = SMSFactory.getResponseInstance();
        CommonValidator.validateEmployee(objEmp,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveEmployee(objEmp,objResponse);
        }
        return objResponse;
    }

    public Response removeCitizen(String selectedId) {
        if(selectedId !=null)
        {
            System.out.println(selectedId);
        }
        Response objResponse = SMSFactory.getResponseInstance();
        objDAL.removeCitizen(selectedId, objResponse);
        return objResponse;
    }
}
