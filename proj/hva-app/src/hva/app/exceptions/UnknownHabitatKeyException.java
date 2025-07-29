package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class UnknownHabitatKeyException extends CommandException {

    @Serial
    private static final long serialVersionUID = 202407081733L;

    public UnknownHabitatKeyException(String id) {
        super(Message.unknownHabitatKey(id));
    }
    
}
