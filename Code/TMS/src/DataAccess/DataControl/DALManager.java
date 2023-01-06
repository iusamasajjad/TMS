/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DataControl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import Model.userManagement.SMSFactory;
import Model.dto.CitizenDTO;
import Model.dto.Message;
import Model.dto.MessageType;
import Model.dto.Response;


public class DALManager {
    IConnection objConnection;
    DBReader objReader;
    RecordsMapper objMapper;
    RecordsAdder objAdder;
    RecordsModifier objModifier;

    public DALManager(RecordsMapper mapper){
    objConnection = new SQLConnection("jdbc:sqlserver://DESKTOP-DTBFB9K:1433;databaseName=Tvcs;databaseName=Tvcs;","Tvcs", "sa","root");
    objReader = new DBReader();
    objAdder = SMSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = SMSFactory.getInstanceOfModifier();
    }
    public ArrayList<CitizenDTO> getCitizenList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewEmployeesQuery = "Select * from vehcileInfo";
        if(searchKey == null || searchKey.length() > 0)
        {
            viewEmployeesQuery += " where vehNo LIKE '%"+searchKey+"%' OR vehNo LIKE '%"+searchKey+"%' OR vehNo LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewEmployeesQuery, dbConnection);
        return objMapper.getCitizen(rs);        
    }  

    public void saveEmployee(CitizenDTO objEmp, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveEmployee(objEmp,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    public Response deleteEmployee(String selectedId, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objModifier.deleteEmployee(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }

}
