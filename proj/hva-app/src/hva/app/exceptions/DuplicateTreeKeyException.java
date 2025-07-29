package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class DuplicateTreeKeyException extends CommandException {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public DuplicateTreeKeyException(String id) {
        super(Message.duplicateTreeKey(id));
    }

}
