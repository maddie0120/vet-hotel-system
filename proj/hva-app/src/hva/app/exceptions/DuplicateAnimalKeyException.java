package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class DuplicateAnimalKeyException extends CommandException {

	@Serial
	private static final long serialVersionUID = 202407081733L;

	public DuplicateAnimalKeyException(String id) {
		super(Message.duplicateAnimalKey(id));
	}
	
}
