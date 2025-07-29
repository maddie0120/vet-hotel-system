package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class DuplicateHabitatKeyException extends CommandException {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public DuplicateHabitatKeyException(String id) {
        super(Message.duplicateHabitatKey(id));
    }

}
