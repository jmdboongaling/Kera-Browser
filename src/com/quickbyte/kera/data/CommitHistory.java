/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.data;

import java.sql.*;

public class CommitHistory {
    public CommitHistory(Timestamp dateTime, String address, String user){
        try{
            String SQL = "INSERT INTO APP.USER_HISTORY (DATE_TIME, ADDRESS, USERNAME)"+
                         " VALUES(?, ?, ?)";
            Connection dbConn = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConn.prepareStatement(SQL);
            
            queryStatement.setTimestamp(1, dateTime);
            queryStatement.setString(2, address);
            queryStatement.setString(3, user);
            
            queryStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
