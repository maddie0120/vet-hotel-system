package hva.exceptions;

import java.io.Serial;


public class DupVaccineKeyCoreException extends Exception {

	@Serial
	private static final long serialVersionUID = 202410092051L;

	private final String _id;

    
	public DupVaccineKeyCoreException(String id) {
		_id = id;
	}

	public String getKey() {
		return _id;
	}
    
}