package hva.habitat;

import hva.seasons.Season;


public class Deciduous extends Tree {
    
    public Deciduous(String id, String name, double age, 
                     int cleaning, Season cycle) {
        super(id, name, age, cleaning, cycle);
    }

    public double calculateTreeCleaningDifficulty(Season s) {
        return (getCleaningDifficulty() * s.effortD() * 
                Math.log(getAge() + 1));
    }

    /**
     * @return A string representing the tree in the format:
     *         ÁRVORE|id|name|age|cleaningDifficulty|CADUCA|biologicalCycle
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + getId() + "|" + getName() + "|" + getAge()
                + "|" + getCleaningDifficulty() + "|CADUCA|" + 
                getCycle().cycleD();
    }

}