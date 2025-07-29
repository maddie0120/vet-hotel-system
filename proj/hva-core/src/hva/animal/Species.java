package hva.animal;

import java.io.Serializable;


public class Species implements Serializable, Comparable<Species> {

    private String _id;
    private String _name;
    private int _availableVets;
    private int _animalCount;

    
    public Species(String id, String name) {
        _id = id;
        _name = name;
        _animalCount = 0;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getAvailableVets() {
        return _availableVets;
    }

    public int getAnimalCount() {
        return _animalCount;
    }

    public void setAvailableVets(int num) {
        _availableVets = num;
    }
    
    public void increaseAnimalCount() {
        _animalCount++;
    }
    
    @Override
    public int compareTo(Species other) {
        return _id.compareTo(other.getId());
    }

}