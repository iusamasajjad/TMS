/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.DataControl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.dto.CitizenDTO;
import Model.dto.Message;
import Model.dto.MessageType;
import Model.dto.Response;


public class RecordsAdder {

    void saveEmployee(CitizenDTO objEmp, Response objResponse, Connection dbConnection) {
        try{
            PreparedStatement p = dbConnection.prepareStatement("INSERT INTO EMployees (FirstName,LastName,Title,TitleOfCourtesy,BirthDate,Address,Country,City,PostalCode,HomePhone,Notes) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
            p.setString(1, objEmp.LastName);
            p.setString(2, objEmp.FirstName);
            p.setString(3, objEmp.Title);
            p.setString(4, objEmp.TitleOfCourtesy);
            p.setString(5, objEmp.BirthDate);
            p.setString(6, objEmp.Address);
            p.setString(7, objEmp.Country);
            p.setString(8, objEmp.City);
            p.setString(9, objEmp.postalCode);
            p.setString(10, objEmp.HomePhone);
            p.setString(11, objEmp.Notes);
            int rowsInserted = p.executeUpdate();
            if(rowsInserted > 0){
                objResponse.messagesList.add(new Message("Employee added successfully.", MessageType.Information));
            }
        }catch(SQLException e){
            objResponse.messagesList.add(new Message("Ooops! Failed to create employee, Please contact support that there an issue while saving new employee.", MessageType.Error));
            objResponse.messagesList.add(new Message(e.getMessage() + "\n Stack Track:\n"+e.getStackTrace(), MessageType.Exception));
        }
    }

}
