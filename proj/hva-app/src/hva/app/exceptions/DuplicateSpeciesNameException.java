package hva.app.exceptions;

import java.io.Serial;

import pt.tecnico.uilib.menus.CommandException;


public class DuplicateSpeciesNameException extends CommandException {

	@Serial
	private static final long serialVersionUID = 202410092153L;

	public DuplicateSpeciesNameException(String id) {
		super(Message.duplicateAnimalKey(id));
	}
	
}
