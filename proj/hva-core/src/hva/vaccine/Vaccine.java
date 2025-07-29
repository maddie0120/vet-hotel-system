package hva.vaccine;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

import hva.animal.Species;


public class Vaccine implements Serializable {
    
    private String _id;
    private String _name;
    private int _numberOfUses = 0; 
    private Map<String, Species> _speciesMap = new TreeMap<>();
    
    
    public Vaccine(String id, String name) {
        _id = id;
        _name = name;
    }

    public String getId() {
        return _id;
    }

    public Map<String, Species> getSpeciesId() {
        return _speciesMap;
    }

    public int getNumberOfUses() {
        return _numberOfUses;
    } 

    public void setNumberOfUses(int numberOfUses) {
        _numberOfUses = numberOfUses;
    }

    public int calculateDamage(String speciesName) {
        int damage = 0;

        for (Species s : _speciesMap.values()) {

            if (speciesName.equals(s.getName())) {
                return 0;
            }

            String name = s.getName();
            int i = calculateCommonCharacters(name, speciesName);
            int j = compareStringSize(name, speciesName);
            if (j - i > damage) {
                damage = j - i;
            }
        }

        return damage;
    }

    public int calculateCommonCharacters(String s1, String s2) {
        char[] new_s1 = s1.toCharArray();
        char[] new_s2 = s2.toCharArray();
        int common = 0;

        for (char c : new_s1) {
            for (int i = 0; i < new_s2.length; i++) {
                if (c == new_s2[i]) {
                    new_s2[i] = 0;
                    common += 1;   
                    break;
                }
            }
        }

        return common;
    }

    public int compareStringSize(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return s1.length();
        }
        return s2.length();
    }

    /**
     * @return A string representing the vaccine in the format:
     *         VACINA|id|name|numberOfRegisters followed by
     *         a list of idSpecies if exists
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VACINA|" + _id + "|" + _name + "|" 
        + _numberOfUses + ((_speciesMap.isEmpty()) ? ("") : 
        ("|" + String.join(",", _speciesMap.keySet())));
    }

}