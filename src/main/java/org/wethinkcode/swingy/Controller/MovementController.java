package org.wethinkcode.swingy.Controller;

import java.io.Console;

import org.wethinkcode.swingy.Model.HeroModel;
import org.wethinkcode.swingy.Model.EnemyModel;
import org.wethinkcode.swingy.View.MapView;
import org.wethinkcode.swingy.Validation.DirectionValid;


public class MovementController {
    HeroModel hero;
    MapView fullmap;
    
    @DirectionValid
    String inp;

    public MovementController(HeroModel selected) {
        hero = selected;
    }
    public void start() {
        fullmap = new MapView(hero);
        fullmap.DisplayMap();
        boolean dead = false;
        int dir = 0;
        Console cons = System.console();
        while(!dead) {
            try {
                OutputController.outputInfo("Please input the number coresponding to the direction you want\n[1,north][2,south][3,east][4,west][5,exit]", 1);
                inp = cons.readLine();
                dir = Integer.parseInt(inp);
            } catch (NumberFormatException e) {
                System.out.println(MoveHero(dir));
            }
            if (dir == 5) {
                hero.save();
                return;
            }
            System.out.println(MoveHero(dir));
            fullmap.DisplayMap();
        }
    }

    public String MoveHero(int dir) {
        int fleePath[] = new int[2];
        int heroCoords[];
        int mapsize = fullmap.getMapsize();
        heroCoords = fullmap.getHeroCoords();
        fleePath[0] = heroCoords[0];
        fleePath[1] = heroCoords[1];
        fullmap.setCleared(heroCoords);
        if (dir == 1) {
            heroCoords[0]--; //north
        } else if (dir == 2) {
            heroCoords[0]++; //south
        }else if (dir == 3) {
            heroCoords[1]++; //east
        }else if (dir == 4) {
            heroCoords[1]--; //west
        }
        if ((heroCoords[0] < 0 | heroCoords[0] >= mapsize) | (heroCoords[1] < 0 | heroCoords[1] >= mapsize)) {
            fullmap.RegenerateMap();
            return "You escaped this floor";
        }
        int node = fullmap.getDetails(heroCoords);
        if (node == -1 || node == -2) {
            EnemyModel enemy = new EnemyModel(hero.getLvl());
            if (enemy.fight(hero)) {
                fullmap.setHero(heroCoords);
                return "Fought and Won!"; }
            else  {
                fullmap.setEnemy(heroCoords);
                heroCoords[0] = fleePath[0];
                heroCoords[1] = fleePath[1];
                fullmap.setHero(heroCoords);
                return "Fled successfully"; }
        }
        fullmap.setHero(heroCoords);
        return "Moved successfully";
    }

    public String MoveHero(String dir) {
        if (dir.equals("north")) {
            return MoveHero(1);
        } else if (dir.equals("south")) {
            return MoveHero(2);
        }else if (dir.equals("east")) {
            return MoveHero(3);
        }else if (dir.equals("west")) {
            return MoveHero(4);
        }
        return MoveHero(5); //5 does nothing
    }
}