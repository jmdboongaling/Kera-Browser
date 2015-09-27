/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.gui;

import com.quickbyte.kera.data.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.text.SimpleDateFormat;

public class History extends JPanel{
    public JPanel containerPanel = new JPanel();
    
    
    private JScrollPane historyPane;
    private LoginAuthentication dataProcess = new LoginAuthentication();
    private final FrameComponents compGui = new FrameComponents();
    
    
    public JList getHistory(String user){
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> historyList = new JList<>(listModel);
        historyList.setFont(compGui.componentFont);
        String SQL = "SELECT * FROM APP.USER_HISTORY WHERE USERNAME = ? ORDER BY DATE_TIME DESC";
        
        System.out.println(user);
        try{
            Connection dbConnect = DBConnect.dbConnect();
            PreparedStatement queryStatement = dbConnect.prepareStatement(SQL);
            
            queryStatement.setString(1, user);
            ResultSet rs = queryStatement.executeQuery();
            while(rs.next()){
                listModel.addElement(new SimpleDateFormat("MMM dd, yyyy 'at' hh aa").format((rs.getTimestamp("DATE_TIME"))) + "   |   " + rs.getString("ADDRESS"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        //sessionList.setFixedCellHeight(1);
        return historyList;
    }
    
}
