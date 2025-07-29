package hva.exceptions;

import java.io.Serial;


public class UnknownSpeciesKeyCoreException extends Exception {

	@Serial
	private static final long serialVersionUID = 202410092052L;

	private String _id;


	public UnknownSpeciesKeyCoreException(String id) {
		super();
		_id = id;
	}

	public UnknownSpeciesKeyCoreException(String id, Exception cause) {
		super(cause);
		_id = id;
	}

	public String getKey() {
		return _id;
	}

}