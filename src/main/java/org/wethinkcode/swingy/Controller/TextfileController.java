package org.wethinkcode.swingy.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import com.google.gson.Gson;
// import com.google.gson.JsonSyntaxException;

import org.wethinkcode.swingy.Model.HeroModel;

public class TextfileController {
    public final String filename =  "heroes.txt";
    private void CreateFile(String name){
        try {
            File myFile = new File(name);
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
    public List<HeroModel> ReadFile() {
        try {
            File myfile = new File(filename);
            Scanner myReader = new Scanner(myfile);
            Gson reader = new Gson();
            List<HeroModel> fullData = new LinkedList<HeroModel>();
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fullData.add(reader.fromJson(data, HeroModel.class));
            }
            myReader.close();
            return fullData;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating " + filename);
            this.CreateFile(filename);}
        // } catch (JsonSyntaxException e) {
        //     System.out.println("The saves have been corrupted");
        // }
        return null;

    }
    public void WriteToHeros(List<HeroModel> heroes) {
        try {
            Gson writer = new Gson();
            FileWriter myfile = new FileWriter(filename);
            for (HeroModel hero : heroes) {
                myfile.append(writer.toJson(hero)); //does this need newlines?
            }
            myfile.close();

        } catch (IOException e) {
            System.out.println("An error occured");
        }
    }
    public void AppendNewHero(HeroModel hero) {
        try {
            Gson writer = new Gson();
            FileWriter myfile = new FileWriter(filename, true);
            myfile.append(writer.toJson(hero)); // + newline?
            myfile.close();
        } catch (IOException e) {
            System.out.println("An error occured");
        }
    }
}
