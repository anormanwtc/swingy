package org.wethinkcode.swingy.View;

import javax.swing.*;

import org.wethinkcode.swingy.Controller.OutputController;
import org.wethinkcode.swingy.Model.HeroModel;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class HeroChoiceView extends JFrame implements WindowListener,ActionListener {
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
    public  void addComponentsToPane(Container finishedMenu) {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        
        Dimension buttonSize = exitButton.getPreferredSize();
        GridLayout mapLayout = new GridLayout(0, 1);
        
        final JPanel menu = new JPanel();
        menu.setLayout(mapLayout);
        menu.setPreferredSize(new Dimension((int)(buttonSize.getWidth() * 2), (int)(buttonSize.getHeight() * 10)));
        int numheroes = heroes.size();
        int i;
        for(i = 1; i < 11 && i + next < numheroes; i++) {
            JButton hero = new JButton(heroes.get(i + next).toString());
            hero.addActionListener(this);
            menu.add(hero);
        }
        if (i + next < numheroes) {
            JButton nextButton = new JButton("next");
            nextButton.addActionListener(this);
        }
        if (next > 0){
            JButton prevButton = new JButton("previous");
            prevButton.addActionListener(this);
        }

        finishedMenu.add(menu);
    }

    private void CreateAndShowGUI() {
        GUImenuView frame = new GUImenuView();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponentsToPane(frame.getContentPane());
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
