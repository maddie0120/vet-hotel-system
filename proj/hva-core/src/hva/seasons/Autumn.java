package hva.seasons;


public class Autumn extends Season {

    @Override
    public int getSeasonIndex() {
        return 2;
    }

    @Override
    public int effortE() {
        return 1;
    }

    @Override
    public int effortD() {
        return 5;
    }

    @Override
    public String cycleE() {
        return "COMFOLHAS";
    }

    @Override
    public String cycleD() {
        return "LARGARFOLHAS";
    }

    @Override
    public Season nextSeason() {
        return new Winter();
    }

} 