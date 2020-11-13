package org.wethinkcode.swingy.View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class GUImenuView extends JFrame implements WindowListener,ActionListener {
    static final long serialVersionUID = 4832168;
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        System.out.println("Hero selected");
    }
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
        dispose();
        System.exit(0);
    }
    public  void addComponentsToPane(int heroes, Container finishedMenu) {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        
        Dimension buttonSize = exitButton.getPreferredSize();
        GridLayout mapLayout = new GridLayout(0, 1);
        
        final JPanel menu = new JPanel();
        menu.setLayout(mapLayout);
        menu.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2), (int)(buttonSize.getHeight() * heroes)));
        for(int i = 0; i < heroes; i++) {
            JButton hero = new JButton("hero");
            hero.addActionListener(this);
            menu.add(hero);
        }
        finishedMenu.add(menu);
    }

    private void CreateAndShowGUI() {
        int heroes = 5; ///

        GUImenuView frame = new GUImenuView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(heroes, frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void main() {
        CreateAndShowGUI();
    }
    
    public void windowActivated(java.awt.event.WindowEvent e) {}
    public void windowClosed(java.awt.event.WindowEvent e) {}
    public void windowDeactivated(java.awt.event.WindowEvent e) {}
    public void windowDeiconified(java.awt.event.WindowEvent e) {}
    public void windowIconified(java.awt.event.WindowEvent e) {}
    public void windowOpened(java.awt.event.WindowEvent e) {}
}
