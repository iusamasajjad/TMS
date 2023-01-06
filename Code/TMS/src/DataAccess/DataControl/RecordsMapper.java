/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DataControl;

import java.sql.ResultSet;
import java.util.ArrayList;
import Model.dto.CitizenDTO;


public class RecordsMapper {

    ArrayList<CitizenDTO> getCitizen(ResultSet rs) {
        ArrayList<CitizenDTO> emplist = new ArrayList<>();
        try{
        while (rs.next())
            {
                CitizenDTO objEmp=new CitizenDTO();                
                objEmp.Id=rs.getString(1);
                objEmp.vehNumber= rs.getString(2);
                objEmp.vehOwner =rs.getString(3);
                objEmp.vehType=rs.getString(4); 
                objEmp.amount=rs.getString(5); 
                emplist.add(objEmp);
            }
        }catch (Exception e){
        }
        return emplist;
    }
    
}
