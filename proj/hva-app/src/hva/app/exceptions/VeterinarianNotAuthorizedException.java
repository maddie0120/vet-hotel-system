package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class VeterinarianNotAuthorizedException extends CommandException {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public VeterinarianNotAuthorizedException(String idVet, String idSpecies) {
        super(Message.notAuthorized(idVet, idSpecies));
    }

}
