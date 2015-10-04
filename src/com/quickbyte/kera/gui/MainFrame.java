package com.quickbyte.kera.gui;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class MainFrame extends JFrame{
    
    private JLabel webIcon;
    
    private JTextField addressField;
    
    private JButton goButton,
                    refreshButton,
                    optionsButton,
                    backButton,
                    forwardButton,
                    historyButton,
                    logoutButton;
    
   

    private final FrameComponents compGui = new FrameComponents();
    
    private Browser keraBrowser = new Browser();
    
    private BrowserView browserView = new BrowserView(keraBrowser);
    
    private CardLayout panelSwitch = new CardLayout();
    public MainFrame(){
        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        add(navigationPanel(), BorderLayout.NORTH);
        add(showPanel(), BorderLayout.CENTER);
        setVisible(true);
        
    }
    private JLabel navigationPanel(){
        backButton = new JButton(compGui.backIcon);
        compGui.ButtonProperties(backButton);
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        forwardButton = new JButton(compGui.forwardIcon);
        compGui.ButtonProperties(forwardButton);
        forwardButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        webIcon = new JLabel(compGui.webIcon);
        
        addressField = new JTextField();
        compGui.TextFieldProperties(addressField);
        addressField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadLink(e);
            }
        });
        
        goButton = new JButton(compGui.goIcon);
        compGui.ButtonProperties(goButton);
        goButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadLink(e);
            }
        });
        
        refreshButton = new JButton(compGui.refreshIcon);
        compGui.ButtonProperties(refreshButton);
        refreshButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadLink(e);
            }
        });
        
        
        historyButton = new JButton(compGui.historyIcon);
        historyButton.setText("History");
        historyButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        compGui.ButtonProperties(historyButton);
        historyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        
        logoutButton = new JButton(compGui.logoutIcon);
        logoutButton.setText("Logout");
        logoutButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        compGui.ButtonProperties(logoutButton);
        logoutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });
        JLabel optionsPanel = new JLabel(compGui.optionsGradientFiller);
        optionsPanel.setLayout(new GridLayout(1, 2));
        optionsPanel.add(historyButton);
        optionsPanel.add(logoutButton);
        final JPopupMenu optionsMenu = new JPopupMenu();
        optionsMenu.setBackground(Color.BLACK);
        optionsMenu.setBorderPainted(false);
        optionsMenu.add(optionsPanel);
        
        optionsButton = new JButton(compGui.optionsIcon);
        compGui.ButtonProperties(optionsButton);
        optionsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                optionsMenu.show(optionsButton, optionsButton.getX()-100, optionsButton.getY()+50);
               
                
            }
        });
        
        JPanel leftBar = new JPanel(new GridLayout(1, 3, 5, 5));
        leftBar.setOpaque(false);
        leftBar.add(backButton);
        leftBar.add(forwardButton);
        leftBar.add(webIcon);
        
        JPanel rightBar = new JPanel(new GridLayout(1, 3, 5, 5));
        rightBar.setOpaque(false);
        rightBar.add(goButton);
        rightBar.add(refreshButton);
        rightBar.add(optionsButton);
        
        
        JPanel navBar = new JPanel();
        navBar.setBorder(new EmptyBorder(10, 10, 10, 10));
        navBar.setBackground(Color.WHITE);
        navBar.setOpaque(false);
        navBar.setLayout(new BorderLayout(20, 5));
        navBar.add(leftBar, BorderLayout.WEST);
        navBar.add(addressField, BorderLayout.CENTER);
        navBar.add(rightBar, BorderLayout.EAST);
        
        JLabel containerPanel = new JLabel(compGui.gradientFiller);
        containerPanel.setLayout(new BorderLayout());
        containerPanel.setOpaque(false);

        containerPanel.add(navBar, BorderLayout.CENTER);

        
        return containerPanel;
    }
    
    private JPanel showPanel(){

        JPanel showPanel = new JPanel(panelSwitch);
        showPanel.add(browserView, "Browser");
        panelSwitch.show(showPanel, "Browser");
        
        URL homePage = getClass().getResource("/com/quickbyte/kera/resources/webpages/index.html");
        keraBrowser.loadURL(homePage.toString());
        return showPanel;
    }
    
    private void loadLink(ActionEvent e){
        keraBrowser.loadURL(addressField.getText());
    }
}