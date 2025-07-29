package hva.satisfaction;

import hva.animal.Species;
import hva.habitat.Habitat;


public class AnimalSatisfaction extends Satisfaction {

    public double calculateAnimalSatisfaction(Species s, Habitat h) {
        int iguais = h.getNumberOfAnimalsFromSpecies(s);
        int population = 0;
        
        for (int count : h.getSpeciesAnimalCount().values()) {
            population += count;
        }

        return (20 + 3 * (iguais - 1) - 2 * (population - iguais) + 
               h.getArea() / population + 
               h.getHabitatInfluenceForSpecies(s));
    }

}