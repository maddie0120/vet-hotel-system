package hva.animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hva.habitat.Habitat;
import hva.satisfaction.AnimalSatisfaction;
import hva.vaccine.Vaccination;


public class Animal implements Serializable {
    
    private String _id;
    private String _name;
    private Species _species;
    private Habitat _habitat;
    private List<Vaccination> _vaccinationsHistory = new ArrayList<>();


    public Animal(String id, String name, Species species,
                  Habitat habitat) {
        _id = id;
        _name = name;
        _species = species;
        _habitat = habitat;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public Species getSpecies() {
        return _species;
    }

    public Habitat getHabitat() {
        return _habitat;
    }

    public List<Vaccination> getVaccinationHistory() {
        return _vaccinationsHistory;
    }

    public void setHabitat(Habitat habitat) {
        _habitat = habitat;
    }

    public double getAnimalSatisfaction() {
        return new AnimalSatisfaction().
                   calculateAnimalSatisfaction(_species, _habitat);
    }

    public String getHealthHistory() {
        return _vaccinationsHistory.stream()
            .map(Vaccination::getDamage)
            .collect(Collectors.joining(","));
    }

    /** 
     * @return A string representing the animal in the format:
     *         ANIMAL|id|name|idSpecies|health|idHabitat.
     *         If the health list is empty, "VOID" is returned for health.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ANIMAL|" + _id + "|" + _name + "|" 
            + getSpecies().getId() + "|" + 
            ((_vaccinationsHistory.isEmpty()) ? "VOID" : 
            getHealthHistory()) + "|" + getHabitat().getId();
    }

}