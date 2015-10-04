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

public class HistoryPanel extends JPanel{
    
    private JButton refreshButton;
    private String studentPull;
    private JScrollPane historyPane;
    private LoginAuthentication dataProcess = new LoginAuthentication();
    private final FrameComponents compGui = new FrameComponents();
    private JPanel historyPanel = new JPanel(new BorderLayout());
    
    public JPanel historyContainer(String user){
        studentPull = user;
        historyPanel.setBackground(Color.WHITE);
        
        refreshButton = new JButton("Refresh");
        compGui.ButtonProperties(refreshButton);
        refreshButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                refreshButtonActionPerformed(e);
            }
        });
        historyPanel.add(refreshButton, BorderLayout.NORTH);
        historyPanel.add(new JScrollPane(getHistory(user)), BorderLayout.CENTER);
        
        
        return historyPanel;
    }
    
    private JList getHistory(String user){
        HistoryControls fetchData = new HistoryControls();
        JList<String> historyList = new JList<>(fetchData.grabHistory(user));
        historyList.setFont(compGui.componentFont);
        return historyList;
    }
    
    private void refreshButtonActionPerformed(ActionEvent e){
        historyPanel.removeAll();
        historyPanel.revalidate();
        historyPanel.add(refreshButton, BorderLayout.NORTH);
        historyPanel.add(new JScrollPane(getHistory(studentPull)), BorderLayout.CENTER);
    }
    
}
