package hva.habitat;

import java.io.Serializable;

import hva.seasons.Season;


public abstract class Tree implements Serializable {

    private String _id;
    private String _name;
    private double _age;
    private int _cleaningDifficulty;
    private Season _cycle;


    public Tree(String id, String name, double age, int cleaning, 
                Season cycle) {
        _id = id;
        _name = name;
        _age = age;
        _cleaningDifficulty = cleaning;
        _cycle = cycle;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getAge() {
        return (int) _age;
    }

    public int getCleaningDifficulty() {
        return _cleaningDifficulty;
    }

    public Season getCycle() {
        return _cycle;
    }

    public void setCycle(Season cycle) {
        _cycle = cycle;
    }

    public void increaseAge() {
        _age += 0.25;
    }

    public abstract double calculateTreeCleaningDifficulty(Season s);

}