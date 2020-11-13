package org.wethinkcode.swingy;

import javax.swing.SwingUtilities;
import org.wethinkcode.swingy.Controller.DisplayController;


public class MavenMain {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                DisplayController display = new DisplayController();
                display.main(args[0]);
            }
        });
    }
}
