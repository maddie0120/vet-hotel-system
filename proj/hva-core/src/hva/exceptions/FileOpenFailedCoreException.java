package hva.exceptions;

import java.io.Serial;


public class FileOpenFailedCoreException extends Exception {

	@Serial
	private static final long serialVersionUID = 202410092051L;

	private final String _id;

    
	public FileOpenFailedCoreException(String id) {
		_id = id;
	}

	public String getKey() {
		return _id;
	}
    
}