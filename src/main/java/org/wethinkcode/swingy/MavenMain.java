package org.wethinkcode.swingy;

import org.wethinkcode.swingy.Controller.DisplayController;


public class MavenMain {
    public static void main(String[] args) {
        DisplayController display = new DisplayController();
        display.main(args[0]);
    }
}
