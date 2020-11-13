// package org.wethinkcode.swingy.View;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;

// public class GUImessageView extends JFrame{
//     static final long serialVersionUID = 4832168;
//     public  void addComponentsToPane(String msgInfo, Container finishedMsg) {
//         JButton swapButton = new JButton("Swap to Console");
//         JLabel info = new JLabel(msgInfo, SwingConstants.CENTER);
//         GridLayout msgLayout = new GridLayout(0,1);
//         final JPanel msg = new JPanel();
//         msg.setLayout(msgLayout);
//         msg.setPreferredSize(new Dimension(300,300));
//         msg.add(swapButton);
//         msg.add(info);
//         finishedMsg.add(msg);
//     }

//     private void CreateAndShowGUI(String args) {

//         GUImessageView frame = new GUImessageView();
//         frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//         frame.addComponentsToPane(args, frame.getContentPane());
//         frame.pack();
//         frame.toFront();
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//     }
//     public void main(String args) {
//         CreateAndShowGUI(args);
//     }
// }
