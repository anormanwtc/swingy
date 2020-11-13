package org.wethinkcode.swingy.Model;

import java.util.Random;

public class MapModel {
    final int mapsize;
    public int[][] allsquares;

    public MapModel(int lvl) {
        mapsize = lvl*5 + 10 - (lvl%2);
        allsquares = new int[mapsize][mapsize];
        Random rand = new Random();
        for(int i = 0; i < mapsize * 2; i++) {
            allsquares[rand.nextInt(mapsize)][rand.nextInt(mapsize)] = -1;
        }
        allsquares[mapsize/2][mapsize/2] = 1;
    }

    public int getMapsize() {
        return mapsize; 
    }

    public int[][] getMap() {
        return allsquares;
    }
}
