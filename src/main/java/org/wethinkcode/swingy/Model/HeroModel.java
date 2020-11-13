package org.wethinkcode.swingy.Model;

public class HeroModel {
    private int lvl = 1;
    private int exp = 0;
    private String name;
    int heroClass = -1;
    final String[] classname = {"mage", "warrior", "rogue"};
    final int[][] classBaseStats = {{30,3,9},{10,9,20},{20,5,15}};
    int[] stats = {0,0,0}; //Attack; Def; Hp
    String items[] = {"","",""};
    int itemStats[] = {0,0,0};

    public HeroModel(String inputName, String inputClass) { //new Hero
        name = inputName;
        inputClass = inputClass.toLowerCase();
        for(int i = 0; i < classname.length; i++) {
            if (classname[i].equals(inputClass)) {
                heroClass = i;
                stats = classBaseStats[i];
            }
        }
        if (heroClass == -1) {
            System.out.println("invalid Class");
            System.exit(0);
        }
    }
    public HeroModel(String readName, int readClass, int readLvl, int readExp, int[] readStats, 
        String readItems[], int readItemStats[]) { //Heros from file
        
        name = readName;
        heroClass = readClass;
        lvl = readLvl;
        exp = readExp;
        stats = readStats; //Attack; Def; Hp
        items = readItems;
        itemStats = readItemStats;
    }

    public void addExp(int addedExp) {
        exp += addedExp;
        int lvlup = lvl*1000 + (lvl*lvl - lvl + 2)*450;
        if (lvlup < exp && lvl < 10) {
            lvl++;
            stats[0] = stats[0] + (stats[0] /10) + 1;
            stats[1] = stats[1] + (stats[1] /10) + 1;
            stats[2] = stats[2] + (stats[2] /10) + 1;
            exp -= lvlup;
            System.out.println("Level up!");
        }
    }
    
    public int getExp() {
        return exp;
    }
    public int getLvl() {
        return lvl;
    }
    public String getName() {
        return name;
    }
    public int[] getStats() {
        return stats;
    }
    public String toString() {
        String heroString;
        heroString = name + " " +  classname + " lvl: " + Integer.toString(lvl);
        return heroString;
    }
}
