package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.DuplicateEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);

        addStringField("id", Prompt.employeeKey());
        addStringField("name", Prompt.employeeName());
        addOptionField("employee type", 
                       Prompt.employeeType(), "VET", "TRT");
    }

    @Override
    protected void execute() throws CommandException {
        try {
            
            _receiver.registerEmployee(new String[] {
                                       optionField("employee type"), 
                                       stringField("id"),
                                       stringField("name")});
        
        } catch (hva.exceptions.DupEmployeeKeyCoreException e) {
            throw new DuplicateEmployeeKeyException(e.getKey());

        } catch (hva.exceptions.NoResponsibilityCoreException |
                 hva.exceptions.UnrecognizedEntryException |
                 hva.exceptions.UnknownEmployeeKeyCoreException e) {
            e.printStackTrace();
        }
    }

}