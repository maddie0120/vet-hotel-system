package hva.seasons;


public class Summer extends Season {

    @Override
    public int getSeasonIndex() {
        return 1;    
    }

    @Override
    public int effortE() {
        return 1;
    }

    @Override
    public int effortD() {
        return 2;
    }

    @Override
    public String cycleE() {
        return "COMFOLHAS";
    }

    @Override
    public String cycleD() {
        return "COMFOLHAS";
    }

    @Override
    public Season nextSeason() {
        return new Autumn();
    }

} 