package org.wethinkcode.swingy.View;

import org.wethinkcode.swingy.Model.HeroModel;

import java.util.LinkedList;
import java.util.List;

public class ConsoleView {
    List<HeroModel> heroList;
    List<String> menuOptions = new LinkedList<String>();
    public ConsoleView(List<HeroModel> heroes) {
        heroList = heroes;
        menuOptions.add("new");
        menuOptions.add("exit");
        menuOptions.add("swap");
        menuOptions.add("list");
        for (HeroModel heroModel : heroes) {
            menuOptions.add(heroModel.getName());
        }
    }

    public void DisplayMenu() {
        System.out.println("Welcome to swingy");
        System.out.println("Please input a number to choose from");
        System.out.println("[1,new] for a new hero; [2,exit] to exit; [3,swap] to go to GUI;");
        System.out.println("[4,list] to list the existing heroes");
        // System.out.println("Each option can be selected with either the number or the name");
    }

    public void DisplayHeros() {
        int i = 1;
        for (String option : menuOptions) {
            if (i > 4) {
                System.out.println("[" + i + "," + option + "]");
            }
        }
    }

    public void DisplayHeroOptions() {
        System.out.println("Creating a new hero");
        System.out.println("The avaliable classes are:");
        System.out.println("Mage: 30 attack; 3 defence; 9 health");
        System.out.println("Warrior: 10 attack; 9 defence; 20 health");
        System.out.println("Rogue: 20 attack; 5 defence; 15 health");
    }
}
