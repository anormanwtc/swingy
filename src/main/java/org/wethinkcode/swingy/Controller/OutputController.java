package org.wethinkcode.swingy.Controller;

import org.wethinkcode.swingy.View.GUImenuView;
import org.wethinkcode.swingy.View.GeneralView;

import java.io.Console;

public class OutputController {
    public static GeneralView cons = new GeneralView();
    public static int ver = 2;

    public static void setVersion(int version) {
        ver = version;
    }

    public static String getLine() {
        Console cons = System.console();
        String line = null;
        if (ver == 1) {
            
        } else
            line = cons.readLine();
        return line;
    }

    public static void outputInfo(String info, int type) {
        if (ver == 2) {
            System.out.println(info);
        }
        else {
            if (type == 1) {
                // use gui
                System.out.println(info);
            }
        }
    }
}
