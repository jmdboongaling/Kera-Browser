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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;



public class FrameComponents extends JFrame{
    
    public Font headerFont = new Font("Verdana", Font.PLAIN, 16),
                componentFont = new Font("Verdana", Font.PLAIN, 15);
    
    public final ImageIcon webIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/web_icon.png")),
                           backIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/back_icon.png")),
                           forwardIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/forward_icon.png")),
                           goIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/go_icon.png")),
                           refreshIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/refresh_icon.png")),
                           optionsIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/options_icon.png")),
                           historyIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/history_icon.png")),
                           logoutIcon = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/logout_icon.png")),
                           gradientFiller = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/gradient_filler.jpg")),
                           optionsGradientFiller = new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/options_gradient_filler.jpg"));
    
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
    
    public void TextFieldProperties(JTextField textfield){

        textfield.setFont(componentFont);
        textfield.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        textfield.setForeground(Color.WHITE);
        textfield.setMinimumSize(textfield.getMaximumSize());
        textfield.setOpaque(false);
        
        
    }
    
    public void ButtonProperties(JButton button){
        
        
        button.setFont(componentFont);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBackground(null);
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
				
                
                button.setBorder(new MatteBorder(0, 0, 2, 0, Color.WHITE));
                           
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                button.setBorder(new MatteBorder(0, 0, 2, 0, Color.BLACK));
                            
            }
        });
       
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
