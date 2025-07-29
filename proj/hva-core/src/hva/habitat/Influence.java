package hva.habitat;


public enum Influence {

    POS(20),
    NEG(-20),
    NEU(0);

    private int _value;


    private Influence(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }

    public void setValue(int value) {
        _value = value;
    }

}