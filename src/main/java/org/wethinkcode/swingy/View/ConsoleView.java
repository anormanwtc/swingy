package org.wethinkcode.swingy.View;

import org.wethinkcode.swingy.Model.HeroModel;

import java.util.LinkedList;
import java.util.List;

public class ConsoleView {
    List<HeroModel> heroList;
    private int numHeros = 0;
    public ConsoleView(List<HeroModel> heroes) {
        heroList = heroes;
    }

    public void DisplayMenu() {
        System.out.println("Welcome to swingy");
        System.out.println("Please input a number to choose from");
        System.out.println("[1,new] for a new hero; [2,exit] to exit; [3,swap] to go to GUI;");
        System.out.println("[4,list] to list the existing heroes");
        // System.out.println("Each option can be selected with either the number or the name");
    }

    public void DisplayHeros() {
        System.out.println("Hero list:");
        for (int i = 0; i < heroList.size(); i++) {
            System.out.println("[" + (i + 4) + "," + heroList.get(i).toString() + "]");
        }
        System.out.println("Please choose one of the options");
    }

    public void DisplayHeroOptions() {
        System.out.println("Creating a new hero");
        System.out.println("The avaliable classes are:");
        System.out.println("Mage: 30 attack; 3 defence; 9 health");
        System.out.println("Warrior: 10 attack; 9 defence; 20 health");
        System.out.println("Rogue: 20 attack; 5 defence; 15 health");
    }
}
