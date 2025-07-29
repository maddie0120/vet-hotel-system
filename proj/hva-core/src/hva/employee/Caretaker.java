package hva.employee;

import java.util.Map;
import java.util.TreeMap;

import hva.habitat.Habitat;
import hva.satisfaction.CaretakerSatisfaction;
import hva.seasons.Season;


public class Caretaker extends Employee {

    private Map<String, Habitat> _responsibilities = new TreeMap<>();


    public Caretaker(String id, String name) {
        super(id, name);
    }

    public Map<String, Habitat> getResponsibilities(){
        return _responsibilities;
    }

    @Override
    public double getEmployeeSatisfaction(Season s) {
        return new CaretakerSatisfaction().
                   calculateCaretakerSatisfaction(this, s);
    }    

    public void addResponsibilityToCaretaker(String id, Habitat h) {
        int num = h.getWorkers();
        h.setWorkers(num + 1);
        _responsibilities.put(id, h);
    }

    public void removeResponsibilityFromCaretaker(Habitat h) {
        int num = h.getWorkers();
        h.setWorkers(num - 1);
        _responsibilities.remove(h.getId());
    }

    /** 
     * @return A string representing the caretaker in the format:
     *         TRT|id|name|idResponsibilities (optional)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "TRT|" + getId() + "|" + getName() + 
            ((_responsibilities.isEmpty()) ? ("") : 
            ("|" + String.join(",", _responsibilities.keySet())));
    }

}