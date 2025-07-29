package hva.exceptions;

import java.io.Serial;


public class VeterinarianNotAuthorizedCoreException extends Exception {

    @Serial
    private static final long serialVersionUID = 202410092053L;

    private final String _idVet;
    private final String _idSpecies;

    
    public VeterinarianNotAuthorizedCoreException(String idVet, 
                                                  String idSpecies) {
        _idVet = idVet;
        _idSpecies = idSpecies;
    }

    public String getVetId() {
        return _idVet;
    }

    public String getSpeciesId() {
        return _idSpecies;
    }

}