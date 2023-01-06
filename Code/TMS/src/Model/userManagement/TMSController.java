/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.userManagement;

import DataAccess.DataControl.DALManager;
import java.util.ArrayList;
import Model.dto.CitizenDTO;
import Model.dto.Response;
import Model.validator.CommonValidator;


public class TMSController {
    DALManager objDAL;
    public TMSController(){
    objDAL = SMSFactory.getInstanceOfDALManager();
    }

    public ArrayList<CitizenDTO> viewCitizen(String searchKey) {
        return objDAL.getCitizenList(searchKey);
    }

    public Response addEmployee(CitizenDTO objEmp) {
        Response objResponse = SMSFactory.getResponseInstance();
        CommonValidator.validateEmployee(objEmp,objResponse);
        if(objResponse.isSuccessfull()){
            objDAL.saveEmployee(objEmp,objResponse);
        }
        return objResponse;
    }

    public Response deleteEmployee(String selectedId) {
        Response objResponse = SMSFactory.getResponseInstance();
        objDAL.deleteEmployee(selectedId, objResponse);
        return objResponse;
    }
}
