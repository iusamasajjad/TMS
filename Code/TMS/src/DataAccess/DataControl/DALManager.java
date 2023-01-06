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
import Model.dto.EmployeeDTO;
import Model.dto.Message;
import Model.dto.MessageType;
import Model.dto.Response;
import ui.users.User;
import ui.users.Verify;

  



public class DALManager {
    IConnection objConnection;
    DBReader objReader;
    RecordsMapper objMapper;
    RecordsAdder objAdder;
    RecordsModifier objModifier;
    Verify objVerify;
    
    public DALManager(RecordsMapper mapper){
    objConnection = new SQLConnection("jdbc:sqlserver://DESKTOP-46Q00AK:1433;databaseName=master;","master", "sa","root");
    objReader = new DBReader();
    objAdder = SMSFactory.getInstanceOfAdder();
    this.objMapper=mapper;
    objModifier = SMSFactory.getInstanceOfModifier();
     objVerify = SMSFactory.getInstanceOfVerify();
    }
    public ArrayList<EmployeeDTO> getEmployeesList(String searchKey) {
                
        Connection  dbConnection = objConnection.getConnection();
        String viewEmployeesQuery = "Select * from Employees";
        if(searchKey == null || searchKey.length() > 0)
        {
            viewEmployeesQuery += " where FirstName LIKE '%"+searchKey+"%' OR LastName LIKE '%"+searchKey+"%' OR Title LIKE '%"+searchKey+"%';";
        }
        ResultSet rs = objReader.getRecords(viewEmployeesQuery, dbConnection);
        return objMapper.getEmployees(rs);        
    }  

    public void saveEmployee(EmployeeDTO objEmp, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objAdder.saveEmployee(objEmp,objResponse,dbConnection);            
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

    public Response removeCitizen(String selectedId, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            if(dbConnection == null){
                objResponse.messagesList.add(new Message("error in conncetion", MessageType.Exception));
            }
            objModifier.removeCitizen(selectedId,objResponse,dbConnection);
            return  objResponse;           
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Ooops! Failed to delete employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
        return null;
    }
    public void AuthenticateUser(User objUser, Response objResponse) {
        try{
            Connection  dbConnection = objConnection.getConnection();
            objVerify.Verify(objUser, objResponse, dbConnection);
        }catch(Exception e){
        objResponse.messagesList.add(new Message("Login Failed", MessageType.Error));
        objResponse.messagesList.add(new Message(e.getMessage() + "\n"+e.getStackTrace(), MessageType.Exception));
        }
    
}
}
