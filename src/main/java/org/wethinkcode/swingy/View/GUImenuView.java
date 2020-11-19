package org.wethinkcode.swingy.View;

import javax.swing.*;

import org.wethinkcode.swingy.Controller.OutputController;
import org.wethinkcode.swingy.Model.HeroModel;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GUImenuView extends JFrame implements WindowListener,ActionListener {
    static final long serialVersionUID = 4832168;
    List<HeroModel> heroes;
    static int next = 0;

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        OutputController.outputInfo(e.getActionCommand(), 1); 
    }
    @Override
    public void windowClosing(java.awt.event.WindowEvent e) {
        dispose();
        System.exit(0);
    }

    public static  void addComponentsToPane(Container pane) {
        JTextArea head = new JTextArea("Welcome to Swingy");
        head.setEditable(false);
        pane.add(head, BorderLayout.PAGE_START);
        
        JTextArea fullMap = new JTextArea("Map will load here");
        fullMap.setEditable(false);
        fullMap.setPreferredSize(new Dimension(200, 100));
        pane.add(fullMap, BorderLayout.CENTER);
    
        JTextField userText = new JTextField("");
        pane.add(userText, BorderLayout.PAGE_END);
        
        JButton newHero = new JButton("New Hero");
        newHero.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton exitButton = new JButton("Exit");
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton swapButton = new JButton("Swap to Console");
        swapButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JButton listButton = new JButton("Saves");
        listButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel left = new JPanel();
        JPanel right = new JPanel();
    
        left.add(newHero);
        left.add(exitButton);
        left.add(swapButton);
        left.add(listButton);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        pane.add(left, BorderLayout.LINE_START);
        pane.add(right, BorderLayout.LINE_END);
    
    }

    private void CreateAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
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
