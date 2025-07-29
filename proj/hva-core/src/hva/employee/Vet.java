package hva.employee;

import java.util.Map;
import java.util.TreeMap;

import hva.animal.Species;
import hva.satisfaction.VetSatisfaction;
import hva.seasons.Season;


public class Vet extends Employee {
    
    private Map<String, Species> _responsibilities = new TreeMap<>();


    public Vet(String id, String name) {
        super(id, name);
    }

    public Map<String, Species> getResponsibilities() {
        return _responsibilities;
    }

    @Override
    public double getEmployeeSatisfaction(Season s) {
        return new VetSatisfaction().calculateVetSatisfaction(this);
    }

    public void addResponsibilityToVet(String id, Species s) {
        int num = s.getAvailableVets();
        s.setAvailableVets(num + 1);
        _responsibilities.put(id, s);
    }

    public void removeResponsibilityFromVet(Species s) {
        int num = s.getAvailableVets();
        s.setAvailableVets(num - 1);
        _responsibilities.remove(s.getId());
    }

    /**
     * @return A string representing the vet in the format:
     *         VET|id|name|idResponsibilities (optional)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "VET|" + getId() + "|" + getName() + 
                ((_responsibilities.isEmpty()) ? ("") : 
                ("|" + String.join(",", _responsibilities.keySet())));
    }

}