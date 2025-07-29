package hva.exceptions;

import java.io.Serial;


public class NoResponsibilityCoreException extends Exception {

    @Serial
    private static final long serialVersionUID = 202410092051L;

    private final String _employeeId;
    private final String _responsibilityId;


    public NoResponsibilityCoreException(String employeeId, 
                                         String responsibilityId) {
        _employeeId = employeeId;
        _responsibilityId = responsibilityId;
    }

    public String getEmployeeId() {
        return _employeeId;
    }

    public String getResponsibilityId() {
        return _responsibilityId;
    }

}