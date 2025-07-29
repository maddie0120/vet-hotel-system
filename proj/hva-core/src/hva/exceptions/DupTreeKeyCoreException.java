package hva.exceptions;

import java.io.Serial;


public class DupTreeKeyCoreException extends Exception {

	@Serial
	private static final long serialVersionUID = 202410092051L;

	private final String _id;

    
	public DupTreeKeyCoreException(String id) {
		_id = id;
	}

	public String getKey() {
		return _id;
	}
    
}