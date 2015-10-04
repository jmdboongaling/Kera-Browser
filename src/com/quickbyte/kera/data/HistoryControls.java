/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;


public class HistoryControls {
    
    public DefaultListModel<String> grabHistory(String user){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String SQL = "SELECT * FROM APP.USER_HISTORY WHERE USERNAME = ? ORDER BY DATE_TIME DESC";
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            queryStatement.setString(1, user);
            ResultSet rs = queryStatement.executeQuery();
            while(rs.next()){
                listModel.addElement(new SimpleDateFormat("MMM dd, yyyy 'at' hh aa").format((rs.getTimestamp("DATE_TIME"))) + "   |   " + rs.getString("ADDRESS"));
            }
            return listModel;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void commitHistory(Timestamp dateTime, String address, String user){
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
