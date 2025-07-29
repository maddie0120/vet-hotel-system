package hva.seasons;


public class Winter extends Season {

    @Override
    public int getSeasonIndex() {
        return 3;
    }
    
    @Override
    public int effortE() {
        return 2;
    }

    @Override
    public int effortD() {
        return 0;
    }

    @Override
    public String cycleE() {
        return "LARGARFOLHAS";
    }

    @Override
    public String cycleD() {
        return "SEMFOLHAS";
    }

    @Override
    public Season nextSeason() {
        return new Spring();
    }

}  