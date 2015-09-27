/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.data;


import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class LoginAuthentication {
    
    public static String userName,
                         firstName;
                         
    private String passWord;
    
    private boolean loginSuccess;
   
    public boolean LoginAuthentication(String getUsername, String getPassword){
        
        Connection dbConnection = DBConnect.dbConnect();
        try{
            String SQL = "SELECT * FROM APP.USERS_TABLE WHERE USERNAME= ?";
            PreparedStatement queryStatement  = dbConnection.prepareStatement(SQL);
            queryStatement.setString(1, getUsername);
            
            
            ResultSet rs = queryStatement.executeQuery();
        
         if(rs.next()){
                
                userName = rs.getString("USERNAME");
                passWord = rs.getString("PASSWORD");
                firstName = rs.getString("FIRST_NAME");
                if((userName.equals(getUsername.trim())) && (passWord.equals(getPassword))){
                    
                    loginSuccess = true;
                    
                
                }
                else{
                
                    loginSuccess = false;
                
                }
         }
         else{
             
         }
            
            
        }catch(Exception e){
           e.printStackTrace();
            
        }
        return loginSuccess;
    }
    
}
