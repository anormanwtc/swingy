package org.wethinkcode.swingy.Controller;

import org.wethinkcode.swingy.View.*;
import org.wethinkcode.swingy.Model.HeroModel;

import java.util.List;
import java.io.Console;

public class DisplayController {
    List<HeroModel> heroes = null;
    TextfileController saves = new TextfileController();
    ConsoleView menu;
    GUImenuView guiMenu = new GUImenuView();

    public DisplayController() {
        heroes = saves.ReadFile();
        menu = new ConsoleView(heroes);
    }

    public void main(String arg) {
        if (arg.equals("gui")) {
            System.out.println("gui selected");
            this.Gui();
        }
        else if (arg.equals("exit")) {
            System.out.println("exit selected");
            System.exit(0);
        }
        else {
            if (arg.equals("console")) {
                System.out.println("console selected"); }
            else {
                System.out.println("defaulted to console"); }
            this.Console(arg);
        }
        heroes = saves.ReadFile();
    }

    public void Gui() {
        guiMenu.main();
    }

    private HeroModel ConsoleChoice(String input) {
        HeroModel selected = null;

        int choice = Integer.parseInt(input);
        if (choice == 1) {
            selected = this.NewHero();
        } else if (choice == 2) {
            System.exit(0);
        } else if (choice == 3) {
            this.Gui();
        } else if (choice == 4) {
            menu.DisplayHeros();
        }else {
            int i = 5;
            for (HeroModel heroModel : heroes) {
                if (i == choice) {
                    selected = heroModel;}
                i++;
            }
        }
        return selected;
    }

    public HeroModel NewHero() {
        Console cons = System.console();
        menu.DisplayHeroOptions();
        System.out.println("Please input a name:");
        String name = cons.readLine();
        System.out.println("Please input a your class:");
        String heroClass = cons.readLine();
        return new HeroModel(name, heroClass);
    }
    public void Console(String args) {
        Console cons = System.console();
        HeroModel selected = null;
        menu.DisplayMenu();
        String input = cons.readLine();
        while (selected == null) {
            selected = ConsoleChoice(input);
        }
        MovementController moving = new MovementController(selected);
        moving.start();
    }

}
