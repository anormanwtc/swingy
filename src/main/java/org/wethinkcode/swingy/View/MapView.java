package org.wethinkcode.swingy.View;

import org.wethinkcode.swingy.Model.HeroModel;
import org.wethinkcode.swingy.Model.EnemyModel;
import org.wethinkcode.swingy.Model.MapModel;

public class MapView{
    MapModel map;
    HeroModel hero;
    int mapsize;
    int heroCoords[] = new int[2];
    int fullMap[][];

    public MapView(HeroModel selected) {
        hero = selected;
        map = new MapModel(hero.getLvl());
        fullMap = map.allsquares;
        mapsize = map.getMapsize();
        heroCoords[0] = mapsize/2;
        heroCoords[1] = mapsize/2;
    }

    public void RegenerateMap() {
        hero.addExp(1000);
        map = new MapModel(hero.getLvl());
        fullMap = map.allsquares;
        mapsize = map.getMapsize();
        heroCoords[0] = mapsize/2;
        heroCoords[1] = mapsize/2;
    }
    public void DisplayMap() {
        for(int i = 0; i < mapsize; i++) {
            for(int k = 0; k < mapsize; k++) {
                if (fullMap[i][k] == 0 || fullMap[i][k] == -1) {
                    System.out.print("?"); }
                else if (fullMap[i][k] == 2) {
                    System.out.print("O"); }
                else if (fullMap[i][k] == 1) {
                    System.out.print("H"); }
                else if (fullMap[i][k] == -2) {
                    System.out.print("X"); }
            }
            System.out.println("");
        }
    }
    
    public String MoveHero(int dir) {
        int fleePath[] = new int[2];
        fleePath[0] = heroCoords[0];
        fleePath[1] = heroCoords[1];
        fullMap[heroCoords[0]][heroCoords[1]] = 2;
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
            this.RegenerateMap();
            return "You escaped this floor";
        }
        if (fullMap[heroCoords[0]][heroCoords[1]] == -1 || fullMap[heroCoords[0]][heroCoords[1]] == -2) {
            EnemyModel enemy = new EnemyModel(hero.getLvl());
            if (enemy.fight(hero)) {
                fullMap[heroCoords[0]][heroCoords[1]] = 1;
                return "Fought and Won!"; }
            else  {
                fullMap[heroCoords[0]][heroCoords[1]] = -2;
                heroCoords[0] = fleePath[0];
                heroCoords[1] = fleePath[1];
                fullMap[heroCoords[0]][heroCoords[1]] = 1;
                return "Fled successfully"; }
        }
        fullMap[heroCoords[0]][heroCoords[1]] = 1;
        return "Moved successfully";
    }
    public int getMapsize() {
        return mapsize;
    }
}