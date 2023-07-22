package java.main.lutemonfighter;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LutemonStorage {

    private static LutemonStorage storage = null;
    private ArrayList<Lutemon> allLutemons;
    private ArrayList<Lutemon> trainingLutemons;
    private ArrayList<Lutemon> fightingLutemons;

    private LutemonStorage() {
        allLutemons = new ArrayList<>();
        trainingLutemons = new ArrayList<>();
        fightingLutemons = new ArrayList<>();
    }

    public static synchronized LutemonStorage getInstance() {
        if (storage == null) {
            storage = new LutemonStorage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        allLutemons.add(lutemon);
    }

    public void addTrainingLutemon(Lutemon lutemon) {
        trainingLutemons.add(lutemon);
    }

    public void addFightingLutemon(Lutemon lutemon) {
        fightingLutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getAllLutemons() {
        return allLutemons;
    }

    public ArrayList<Lutemon> getTrainingLutemons() {
        return trainingLutemons;
    }

    public ArrayList<Lutemon> getFightingLutemons() {
        return fightingLutemons;
    }

    public void saveLutemon(Context context) {
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(allLutemons);
            lutemonWriter.writeObject(trainingLutemons);
            lutemonWriter.writeObject(fightingLutemons);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("Lutemonien tallentaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void loadLutemon(Context context) {
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            allLutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            trainingLutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            fightingLutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }

    public ArrayList<Lutemon> getListOfLutemons() {
        return allLutemons;
    }
}


