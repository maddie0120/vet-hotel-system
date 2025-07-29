package hva.habitat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import hva.animal.Species;


public class Habitat implements Serializable {
    
    private String _id;
    private String _name;
    private int _area;
    private int _workers = 0;
    private Map<Species, Integer> _speciesAnimalCount = new TreeMap<>();
    private Map<Species, Influence> _habitatInfluence = new TreeMap<>();
    private Map<String, Tree> _treesMap = 
                        new TreeMap<>(String.CASE_INSENSITIVE_ORDER); 


    public Habitat(String id, String name, int area) {
        _id = id;
        _name = name;
        _area = area;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public int getArea() {
        return _area;
    }

    public void setArea(int area) {
        _area = area;
    }  

    public int getWorkers(){
        return _workers;
    }

    public void setWorkers(int workers) {
        _workers = workers;
    }

    public Map<Species, Integer> getSpeciesAnimalCount() {
        return _speciesAnimalCount;
    }    

    public Map<Species, Influence> getHabitatInfluence() {
        return _habitatInfluence;
    }

    public Map<String, Tree> getTreesMap() {
        return _treesMap;
    }

    public Collection<Tree> getTrees() {
        return _treesMap.values();
    }

    public int getNumberOfAnimalsFromSpecies(Species s){
        return _speciesAnimalCount.get(s);
    }

    public void setSpeciesAnimalCount(Species idS, int number) {
        _speciesAnimalCount.put(idS, number);
    }

    public int getHabitatInfluenceForSpecies(Species s) {
        return _habitatInfluence.get(s).getValue();
    }

    public String showAllTreesInHabitat() {
        String s = "";
    
        for (Tree t : getTrees()) {
            if (t != null) {
                s += (s.isEmpty() ? "" : "\n") + t;
            }
        }
    
        return s;
    }
    
    /** 
     * @return A string representing the habitat in the format:
     *         HABITAT|id|name|area|numberOfTrees followed by
     *         a list of trees if exists
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "HABITAT|" + getId() + "|" + getName() + "|" + 
               getArea() + "|" + _treesMap.size() +
               ((_treesMap.isEmpty()) ? "" : "\n" + showAllTreesInHabitat());
    }

}