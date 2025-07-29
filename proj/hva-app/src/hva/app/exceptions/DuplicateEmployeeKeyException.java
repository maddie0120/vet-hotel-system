package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class DuplicateEmployeeKeyException extends CommandException {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public DuplicateEmployeeKeyException(String id) {
        super(Message.duplicateEmployeeKey(id));
    }
    
}
