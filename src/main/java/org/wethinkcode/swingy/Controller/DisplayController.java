package org.wethinkcode.swingy.Controller;

import org.wethinkcode.swingy.View.*;
import org.wethinkcode.swingy.Model.HeroModel;
import org.wethinkcode.swingy.Validation.ChoiceValid;
import org.wethinkcode.swingy.Validation.ClassValid;

import java.util.List;

public class DisplayController {
    List<HeroModel> heroes = null;
    TextfileController saves = new TextfileController();
    GeneralView view = new GeneralView();
    GUImenuView gui;
    int ver;

    @ChoiceValid
    String userInput;
    @ClassValid
    String heroClass;

    public DisplayController() {
        heroes = saves.ReadFile();
    }

    public void main(String arg) {
        arg = arg.toLowerCase();
        if (arg.equals("gui")) {
            System.out.println("gui selected");
            OutputController.setVersion(1);
            gui = new GUImenuView();
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    gui.main();
                }
            });
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
            OutputController.setVersion(2);
            heroes = saves.ReadFile();
            this.start();
        }
    }

    private HeroModel ConsoleChoice(String input) {
        HeroModel res = null;
        try {
            int choice = Integer.parseInt(input);
            return ConsoleChoiceResult(choice);
        } catch (NumberFormatException e){
            if (input == null || input.equalsIgnoreCase("exit"))
                return ConsoleChoiceResult(2);
            else if (input.equalsIgnoreCase("new"))
                return ConsoleChoiceResult(1);
            else if (input.equalsIgnoreCase("gui"))
                return ConsoleChoiceResult(3);
            else if (input.equalsIgnoreCase("list"))
                return ConsoleChoiceResult(4);
        }
        return res;
    }
    
    private HeroModel ConsoleChoiceResult(int choice) {
        HeroModel selected = null;

        if (choice == 1) {
            selected = this.NewHero();
        } else if (choice == 2) {
            System.exit(0);
        } else if (choice == 3) {
            OutputController.setVersion(1);
        } else if (choice == 4) {
            view.DisplayHeros(heroes);
        }
        if (choice > 4) {
            try {
                selected = heroes.get(choice - 4);
            } catch(IndexOutOfBoundsException e) {
                OutputController.outputInfo("Hero " + choice + " does not exist", 1);
            }
        }
        return selected;
    }

    public HeroModel NewHero() {
        view.DisplayHeroOptions();
        OutputController.outputInfo("Please input a name:", 1);
        String name = OutputController.getLine();
        OutputController.outputInfo("Please input a your class:", 1);
        heroClass = OutputController.getLine();
        HeroModel newHero = new HeroModel(name, heroClass);
        heroes.add(newHero);
        saves.AppendNewHero(newHero);
        return newHero;
    }
    public void start() {
        HeroModel selected = null;
        if (OutputController.ver != 1)  // not gui
            view.DisplayMenu();         // console menu
        while (selected == null) {
            userInput = OutputController.getLine();
            selected = ConsoleChoice(userInput);
        }
        MovementController moving = new MovementController(selected);
        moving.start();
    }
}
