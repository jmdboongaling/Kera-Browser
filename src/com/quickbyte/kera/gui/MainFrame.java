package com.quickbyte.kera.gui;

import com.quickbyte.kera.data.*;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.events.StartLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.TitleEvent;
import com.teamdev.jxbrowser.chromium.events.*;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.*;
import java.awt.event.*;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame{
    
    
    
    private JLabel usernameLabel,
                   passwordLabel,
                   loadingLabel;
    
    private JButton loginButton,
                    guestButton,
                    goButton,
                    historyButton,
                    logoutButton;
    
    private JTextField usernameTextField,
                       addressTextField;
                       
    private JPasswordField passwordTextField;
    
    private CardLayout panelSwitch = new CardLayout();
    
    private JPanel visiblePanel;
    
    private Browser browser = new Browser();
    private BrowserView browserView = new BrowserView(browser);
    private final FrameComponents compGui = new FrameComponents();
    private LoginAuthentication dataProcess = new LoginAuthentication();
    private JPanel controlPanel(){
       
       JPanel navPanel = new JPanel(new BorderLayout(10, 10));
       navPanel.setBackground(new Color(255, 255, 255));
       navPanel.setOpaque(true);
       navPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
       
       addressTextField = new JTextField();
       compGui.TextFieldProperties(addressTextField);
       addressTextField.setEditable(false);
       addressTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                goActionPerformed(e);
            }
       });
       
       goButton = new JButton(new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/go.png")));
       compGui.ButtonProperties(goButton);
       goButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               goActionPerformed(e);
           }
       });
       goButton.setEnabled(false);
       JLabel addressLabel = new JLabel("Kera Web");
       addressLabel.setFont(compGui.componentFont);
       
       historyButton = new JButton( new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/history.png")));
       compGui.ButtonProperties(historyButton);
       historyButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               historyButtonActionPerformed(e);
           }
       });
       historyButton.setEnabled(false);
       
       JPanel x = new JPanel(new GridLayout(1, 2, 5, 0));
       x.setOpaque(false);
       x.add(goButton);
       x.add(historyButton);
       navPanel.add(addressLabel, BorderLayout.WEST);
       navPanel.add(addressTextField, BorderLayout.CENTER);
       navPanel.add(x, BorderLayout.EAST);
       navPanel.add(new JSeparator(), BorderLayout.SOUTH);
       
       return navPanel;
   }
    
    private JPanel loginPanel(){
        
        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(compGui.componentFont);
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(compGui.componentFont);
        
        usernameTextField = new JTextField();
        compGui.TextFieldProperties(usernameTextField);
        passwordTextField = new JPasswordField();
        compGui.TextFieldProperties(passwordTextField);
        passwordTextField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginButtonActionPerformed(e);
            }
        });
        
        loginButton = new JButton("Login");
        compGui.ButtonProperties(loginButton);
        loginButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginButtonActionPerformed(e);
            }
        });
        guestButton = new JButton("Sign in as guest");
        compGui.ButtonProperties(guestButton);
        guestButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                guestUserButtonActionPerformed(e);
            }
        });
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        buttonPanel.setOpaque(false);
        buttonPanel.add(loginButton);
        buttonPanel.add(guestButton);
        
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(5, 1, 5, 5));
        loginPanel.setOpaque(true);
        loginPanel.setBackground(new Color(255, 255, 255, 150));
        loginPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordTextField);
        loginPanel.add(buttonPanel);
        
        JPanel loginPage = new JPanel(new BorderLayout());
        loginPage.setBackground(Color.red);
        JLabel loginPageBackground = new JLabel(new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/login_page.jpg")));
        loginPageBackground.setLayout(new GridBagLayout());
        loginPageBackground.add(loginPanel);
        loginPage.add(loginPageBackground, BorderLayout.CENTER);
        
        return loginPage;
        
    }
    
    private JPanel browserPanel(){
        
        JPanel browserPanel = new JPanel(new BorderLayout());
        browserPanel.add(new JLabel("Test"), BorderLayout.CENTER);
        
        browserPanel.add(browserView, BorderLayout.CENTER);
        browser.addTitleListener(new TitleListener(){
            public void onTitleChange(TitleEvent e){
                setTitle("Kera Web Browser - " + e.getTitle());
            }
        });
        
        browser.addLoadListener(new LoadAdapter() {
            @Override
            public void onStartLoadingFrame(StartLoadingEvent event) {
                if (event.isMainFrame()) {
                    goButton.setIcon(new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/loading.gif")));
                    goButton.setBackground(Color.WHITE);
                }
            }

            @Override
            public void onFailLoadingFrame(FailLoadingEvent event) {
               System.out.println("Failed");
            }

            @Override
            public void onDocumentLoadedInMainFrame(LoadEvent event) {
                goButton.setIcon(new ImageIcon(getClass().getResource("/com/quickbyte/kera/resources/go.png")));
                goButton.setBackground(compGui.themeColor1);
                java.util.Date date= new java.util.Date();
                new CommitHistory(new Timestamp(date.getTime()), browser.getURL(), dataProcess.userName);
            }
        });
        return browserPanel;
    }
    
    private JPanel showPanel(){
        
        visiblePanel = new JPanel(new GridLayout(1, 1, 0, 0));
        visiblePanel.setLayout(panelSwitch);
        visiblePanel.add(loginPanel(), "loginForm");
        visiblePanel.add(browserPanel(), "browserPanel");
        
        panelSwitch.show(visiblePanel, "loginForm");
        
        
        return visiblePanel;
    }
    
    public MainFrame(){
        setTitle("Kera Web Browser - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.BLACK);
        add(controlPanel(), BorderLayout.NORTH);
        
        add(showPanel(), BorderLayout.CENTER);
        setVisible(true);
        
    }
    
    private void loginButtonActionPerformed(ActionEvent e){
        
        if(dataProcess.LoginAuthentication(usernameTextField.getText(), passwordTextField.getText())){
            panelSwitch.show(visiblePanel, "browserPanel");
            JOptionPane.showMessageDialog(null, "Welcome " + dataProcess.firstName);
            addressTextField.setEditable(true);
            goButton.setEnabled(true);
            historyButton.setEnabled(true);
            setTitle("Kera Web Browser - Welcome, " + dataProcess.firstName + "!");
            visiblePanel.add(new JScrollPane(new History().getHistory(dataProcess.userName)), "historyPanel");
        }else{
            JOptionPane.showMessageDialog(null, "Invalid Login Credentials!");
        }
        
    }
    
    private void goActionPerformed(ActionEvent e){
        browser.loadURL(addressTextField.getText());
                
        
    }
    
    private void historyButtonActionPerformed(ActionEvent e){
        panelSwitch.show(visiblePanel, "historyPanel");
    }
    
    private void guestUserButtonActionPerformed(ActionEvent e){
        panelSwitch.show(visiblePanel, "browserPanel");
        JOptionPane.showMessageDialog(null, "Welcome, Guest!");
        addressTextField.setEditable(true);
        goButton.setEnabled(true);
        browser.addLoadListener(null);
    }
    
   
    
}
