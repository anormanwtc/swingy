package org.wethinkcode.swingy.View;

import org.wethinkcode.swingy.Controller.OutputController;
import org.wethinkcode.swingy.Model.HeroModel;

import java.util.List;

public class GeneralView {
    public GeneralView() {
    }

    public void DisplayMenu() {
        if (OutputController.ver == 1) {
            OutputController.outputInfo("Welcome to swingy", 2);
            OutputController.outputInfo("New Hero", 3);
            OutputController.outputInfo("Saves", 3);
            OutputController.outputInfo("Swap to Gui", 3);
            OutputController.outputInfo("Exit", 3);
        } else {
            OutputController.outputInfo("Welcome to swingy", 1);
            OutputController.outputInfo("Please input a number to choose from", 1);
            OutputController.outputInfo("[1,new] for a new hero; [2,exit] to exit; [3,swap] to go to GUI;", 1);
            OutputController.outputInfo("[4,list] to list the existing heroes", 1);
            OutputController.outputInfo("Each option can be selected with either the number or the name", 1);
        }
    }

    public void DisplayHeros(List<HeroModel> heroes) {
        OutputController.outputInfo("Hero list:", 2); // 2 for gui header
        for (int i = 0; i < heroes.size(); i++) {
            OutputController.outputInfo("[" + (i + 4) + "," + heroes.get(i).toString() + "]", 3); //3 for gui buttons
        }
        OutputController.outputInfo("Please choose one of the options", 0); //0 for only console
    }

    public void DisplayHeroOptions() {
        OutputController.outputInfo(
            "Creating a new hero\nThe avaliable classes are:\nMage: 30 attack; 3 defence; 9 health\nWarrior: 10 attack; 9 defence; 20 health\nRogue: 20 attack; 5 defence; 15 health"
            , 4); //4 for where map goes
    }
}
