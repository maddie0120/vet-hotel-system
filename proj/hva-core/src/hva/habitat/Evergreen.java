package hva.habitat;

import hva.seasons.Season;


public class Evergreen extends Tree {

    public Evergreen(String id, String name, double age, 
                     int cleaning, Season cycle) {
        super(id, name, age, cleaning, cycle);
    }

    public double calculateTreeCleaningDifficulty(Season s) {
        return (getCleaningDifficulty() * s.effortE() * 
                Math.log(getAge() + 1));
    }

    /**
     * @return A string representing the tree in the format:
     *         ÁRVORE|id|name|age|cleaningDifficulty|EVERGREEN|biologicalCycle
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ÁRVORE|" + getId() + "|" + getName() + "|" + getAge()
                + "|" + getCleaningDifficulty() + "|PERENE|" + 
                getCycle().cycleE();
    }

} 