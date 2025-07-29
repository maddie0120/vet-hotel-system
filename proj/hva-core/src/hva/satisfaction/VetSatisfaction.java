package hva.satisfaction;

import hva.animal.Species;
import hva.employee.Vet;


public class VetSatisfaction extends Satisfaction {

    public double calculateVetSatisfaction(Vet v) {
        return 20 - calculateWork(v);
    }

    public double calculateWork(Vet v) {
        double work = 0; 

        for (Species s : v.getResponsibilities().values()) {
            work += (s.getAnimalCount() / s.getAvailableVets());
        }

        return work;
    }

}