package hva.satisfaction;

import hva.employee.Caretaker;
import hva.habitat.Habitat;
import hva.habitat.Tree;
import hva.seasons.Season;


public class CaretakerSatisfaction extends Satisfaction {

    public double calculateCaretakerSatisfaction(Caretaker c, Season s){
        return 300 - calculateWork(c, s);
    }

    public double calculateWork(Caretaker c, Season s) {
        double work = 0; 

        for (Habitat h : c.getResponsibilities().values()) {
            work += (calculateWorkInHabitat(h, s)/h.getWorkers());
        }

        return work;
    }

    public double calculateWorkInHabitat(Habitat h, Season s) {
        int population = 0; 
        double effort = 0; 

        for (int i : h.getSpeciesAnimalCount().values()) {
            population += i;
        }

        for (Tree t : h.getTreesMap().values()){
            effort += t.calculateTreeCleaningDifficulty(s);
        }
        
        return (h.getArea() + 3 * population + effort);
    }

}