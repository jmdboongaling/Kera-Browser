package com.quickbyte.kera.gui;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;


public class Start {
    public static void main(String[] args) {
        UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.WHITE));
        new MainFrame();
    }
}