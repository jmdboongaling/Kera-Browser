/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quickbyte.kera.gui;

import com.teamdev.jxbrowser.chromium.*;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class KeraBrowser{
    
    private Browser keraBrowser;
    private BrowserView browserView;
    private CardLayout switchPanel;
    
    public JPanel KeraBrowser(){
        
        return new JPanel();
    }
    private JPanel browserView(){
        keraBrowser = new Browser();
        browserView = new BrowserView(keraBrowser);
        
        return new JPanel();
    }
}
