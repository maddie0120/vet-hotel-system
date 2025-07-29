package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class UnknownSpeciesKeyException extends CommandException {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public UnknownSpeciesKeyException(String key) {
        super(Message.unknownSpeciesKey(key));
    }

}
