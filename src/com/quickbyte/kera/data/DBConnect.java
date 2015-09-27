/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.data;


import java.sql.*;


public class DBConnect{
    
    public boolean loginSuccess;
    
    private static String dbURL,
                          dbUsername,
                          dbPassword;
    
    public static Connection dbConnect(){
        
        
            
        try{     
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");   
            dbURL = "jdbc:derby:KeraUserData";
            dbUsername = "kera";
            dbPassword = "1234";
            Connection dbConnection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            
            return dbConnection; 
        }
        catch(Exception e){
            
            e.printStackTrace();
            return null;
            
        }
    }
    
    public static void main(String[]args){
        dbConnect();
    }

}