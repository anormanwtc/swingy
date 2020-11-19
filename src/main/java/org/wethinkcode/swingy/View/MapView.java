package org.wethinkcode.swingy.View;

import org.wethinkcode.swingy.Model.HeroModel;
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
    
    public int getMapsize() {
        return mapsize;
    }
    public int[] getHeroCoords() {
        return heroCoords;
    }
    public int getDetails(int[] coords) {
        return this.fullMap[coords[0]][coords[1]];
    }
    public void setHero(int[] coords) {
        heroCoords[0] = coords[0];
        heroCoords[1] = coords[1];
        this.fullMap[coords[0]][coords[1]] = 1;
    }
    public void setCleared(int[] coords) {
        this.fullMap[coords[0]][coords[1]] = 2;
    }
    public void setEmpty(int[] coords) {
        this.fullMap[coords[0]][coords[1]] = 0;
    }
    public void setHiddenEnemy(int[] coords) {
        this.fullMap[coords[0]][coords[1]] = -1;
    }
    public void setEnemy(int[] coords) {
        this.fullMap[coords[0]][coords[1]] = -2;
    }
}