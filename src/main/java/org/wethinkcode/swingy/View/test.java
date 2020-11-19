package org.wethinkcode.swingy.View;

/*
* BorderLayoutDemo.java
*
*/
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

public class test {
   public static boolean RIGHT_TO_LEFT = false;
   
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
    pane.add(left, BorderLayout.LINE_START);
    pane.add(right, BorderLayout.LINE_END);

}
   
   /**
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event dispatch thread.
    */

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
   
   public static void main(String[] args) {
       /* Use an appropriate Look and Feel */
       try {
           //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
       } catch (UnsupportedLookAndFeelException ex) {
           ex.printStackTrace();
       } catch (IllegalAccessException ex) {
           ex.printStackTrace();
       } catch (InstantiationException ex) {
           ex.printStackTrace();
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
       /* Turn off metal's use bold fonts */
       UIManager.put("swing.boldMetal", Boolean.FALSE);
       
       //Schedule a job for the event dispatch thread:
       //creating and showing this application's GUI.
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               createAndShowGUI();
           }
       });
   }
}