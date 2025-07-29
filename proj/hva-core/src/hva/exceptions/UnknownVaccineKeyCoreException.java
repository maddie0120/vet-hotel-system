package hva.exceptions;

import java.io.Serial;


public class UnknownVaccineKeyCoreException extends Exception {

	@Serial
	private static final long serialVersionUID = 202410092052L;

	private String _id;


	public UnknownVaccineKeyCoreException(String id) {
		super();
		_id = id;
	}

	public UnknownVaccineKeyCoreException(String id, Exception cause) {
		super(cause);
		_id = id;
	}

	public String getKey() {
		return _id;
	}

}