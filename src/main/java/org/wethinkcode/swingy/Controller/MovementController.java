package org.wethinkcode.swingy.Controller;

import java.io.Console;

import org.wethinkcode.swingy.Model.HeroModel;
import org.wethinkcode.swingy.View.MapView;
import java.util.List;

public class MovementController {
    HeroModel hero;

    public MovementController(HeroModel selected) {
        hero = selected;
    }
    public void start() {
        MapView fullmap = new MapView(hero);
        System.out.println("Generated a map of size " + fullmap.getMapsize());
        fullmap.DisplayMap();
        boolean dead = false;
        int dir = 0;
        Console cons = System.console();
        while(!dead) {
            try {
                System.out.println("Please input the number coresponding to the direction you want");
                System.out.println("[1,north][2,south][3,east][4,west][5,exit]");
                dir = Integer.parseInt(cons.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Only numbers for [1,north][2,south][3,east][4,west][5,exit] are accepted");
            }
            if (dir == 5) {
                hero.save();
                return;
            }
            System.out.println(fullmap.MoveHero(dir));
            fullmap.DisplayMap();
        }
    }
}
