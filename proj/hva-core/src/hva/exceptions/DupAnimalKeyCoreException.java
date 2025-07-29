package hva.exceptions;

import java.io.Serial;


public class DupAnimalKeyCoreException extends Exception {

    @Serial
    private static final long serialVersionUID = 202410092050L;

    private final String _id;

	
    public DupAnimalKeyCoreException(String id) {
        _id = id;
    }

    public String getKey() {
    	return _id;
    }
    
}