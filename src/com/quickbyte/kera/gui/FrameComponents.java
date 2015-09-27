/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.gui;

import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;



public class FrameComponents extends JFrame{
    
    public Font headerFont = new Font("Verdana", Font.PLAIN, 16),
                componentFont = new Font("Verdana", Font.PLAIN, 15);
    
    /*public final ImageIcon loginBackground = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/login_background.jpg")),
                           systemFrameBackground = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/systemframe_background.jpg")),
                           searchIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/search_icon.png")),
                           logoutIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/logout_icon.png")),
                           sheduleSessionIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/schedule_icon.png")),
                           optionsIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/settings_icon.png")),
                           helpIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/help_icon.png")),
                           qbAdminIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/admin_icon.png")),
                           updateIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/update_icon.png")),
                           printIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/print_icon.png")),
                           refreshIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/refresh_icon.png")),
                           accomplishIcon = new ImageIcon(getClass().getResource("/com/quickbyte/fims/resources/accomplish_icon.png"));
    */
    public final Color themeColor1 = new Color(51,102,153),
                       themeColor2 = new Color(192,192,192);
                       
    /*
    public final JLabel loginPageBackground = new JLabel(loginBackground),
                        systemPageBackground = new JLabel(systemFrameBackground);
                        
    public FrameComponents(){
        systemPageBackground.setPreferredSize(systemPageBackground.getMaximumSize());
    }*/
    public JLabel LabelProperties(JLabel label){
        
        label.setFont(componentFont);
        return label;
    }
    
    public JTextField TextFieldProperties(JTextField textfield){

        textfield.setFont(componentFont);
        textfield.setMinimumSize(textfield.getMaximumSize());
        
        return textfield;
    }
    
    public JButton ButtonProperties(JButton button){
        
        
        button.setFont(componentFont);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(themeColor1);
        button.setForeground(Color.WHITE);
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
				
                button.setBackground(themeColor2);
                button.setForeground(Color.BLACK);
                           
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                button.setBackground(themeColor1); 
                button.setForeground(Color.WHITE);
                            
            }
        });
        return button;
    }
    
    public JButton ButtonProperties(JButton button, String buttonText){
        
        
        button.setFont(componentFont);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBackground(themeColor1);
        button.setForeground(Color.WHITE);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
				
                button.setBackground(themeColor2);
                button.setForeground(Color.WHITE);
                button.setText(buttonText);
                           
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                button.setBackground(themeColor1); 
                button.setForeground(Color.BLACK);
                button.setText("");
                            
            }
        });
        return button;
    }
    
    public JLabel DateTimeProperties(JLabel timeLabel){
        
        final DateFormat timeFormat = new SimpleDateFormat("hh:mm:ssa MM-dd-yyyy");
        ActionListener timerListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                Date date = new Date();
                String time = timeFormat.format(date);
                timeLabel.setText(time);
            }
        };
        
        Timer timer = new Timer(1000, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        
        return timeLabel;
        
    }
}
