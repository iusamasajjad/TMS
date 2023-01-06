/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.userManagement;

import DataAccess.DataControl.DALManager;
import DataAccess.DataControl.RecordsAdder;
import DataAccess.DataControl.RecordsMapper;
import DataAccess.DataControl.RecordsModifier;

import Model.dto.Message;
import static Model.dto.MessageType.Error;
import Model.dto.Response;
import ui.users.Verify;


public class SMSFactory {

    static DALManager getInstanceOfDALManager() {
        return new DALManager(new RecordsMapper());
    }

    public static OSSController getInstanceOfSMSController() {
        return new OSSController();
    }

    static Response getResponseInstance() {
        return new Response();
    }

    public static RecordsAdder getInstanceOfAdder() {
        return new RecordsAdder();
    }

    public static RecordsModifier getInstanceOfModifier() {
        return new RecordsModifier();
    }
     public static Message getInstanceOfMessage() {
        return new Message("asd",Error);
    }
     public static Verify getInstanceOfVerify() {
       return new Verify();
    }

 }
