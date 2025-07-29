package hva.vaccine;

import hva.animal.Animal;
import hva.employee.Vet;


public class Vaccination {
    
    private Vaccine _vaccine;
    private Vet _vet;
    private Animal _animal;
    private String _damage;

    
    public Vaccination(Vaccine vaccine, Vet vet, Animal animal, 
                       String damage) {
        _vaccine = vaccine;
        _vet = vet;
        _animal = animal;
        _damage = damage;
    }

    public String getDamage() {
        return _damage;
    }

    public Vet getVet() {
        return _vet;
    }

    /**
     * @return A string representing the vaccination in the format:
     *         REGISTO-VACINA|idVaccine|idVet|idSpecies
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "REGISTO-VACINA" + "|" + _vaccine.getId() + "|" +
        _vet.getId() + "|" + _animal.getSpecies().getId();
    }
    
}
 