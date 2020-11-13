package org.wethinkcode.swingy.Model;

import java.io.Console;
import java.util.Random;

import javax.validation.constraints.Max;

public class EnemyModel {
    int lvl = 1;
    int[] stats = {5,5,20}; //Attack; Def; Hp
    int drops;
    int deviation;
    int exp;
    Random rand = new Random();
    public EnemyModel(int herolvl) {
        drops = rand.nextInt(5);
        deviation = rand.nextInt((herolvl * 2) - herolvl/2);
        for(int i = 1; i < deviation; i++)
            lvlUp();
        if (deviation * deviation - herolvl > 0) {
            exp = (deviation * deviation - herolvl) * 300;
        } else
            exp = 100;
    }
    public void lvlUp() {
        lvl++;
        stats[0] = stats[0] + (stats[0] /10) + 1;
        stats[1] = stats[1] + (stats[1] /10) + 1;
        stats[2] = stats[2] + (stats[2] /10) + 1;
    }
    public int getLvl() {
        return lvl;
    }
    public boolean fight(HeroModel hero) {
        Console con = System.console();
        System.out.println("Enemy encountered select [1,fight]; [2,flee]");
        int choice = 0;
        String input;
        while (choice != 1 && choice != 2) {
            input = con.readLine();
            try{
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice select [1,fight]; [2,flee]");
                choice = 0;
            }
        }
        if (choice == 2) {
            if ((rand.nextInt(10) % 2) == 0) {
                return false;
            }
            System.out.println("Failed to Flee");
        }
        int herostats[] = hero.getStats();
        int enemyhp = stats[2];
        int herohp = herostats[2];
        while (enemyhp > 0 && herohp > 0) {
            herohp -= stats[0] - herostats[1];
            enemyhp -= herostats[0] - stats[1];
        }
        if (herohp <= 0) {
            System.out.println("You died");
            System.exit(0);
        }
        hero.addExp(exp);
        return true;
    }
}
