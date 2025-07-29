package hva.seasons;


public class Spring extends Season {

    @Override
    public int getSeasonIndex() {
        return 0;
    }
    @Override
    public int effortE() {
        return 1;
    }

    @Override
    public int effortD() {
        return 1;
    }

    @Override
    public String cycleE() {
        return "GERARFOLHAS";
    }

    @Override
    public String cycleD() {
        return "GERARFOLHAS";
    }

    @Override
    public Season nextSeason() {
        return new Summer();
    }

} 