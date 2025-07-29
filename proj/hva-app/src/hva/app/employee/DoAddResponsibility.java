package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);

        addStringField("employee id", Prompt.employeeKey());
        addStringField("responsibility id", Prompt.responsibilityKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _receiver.addResponsibilityToEmployee(
                                    stringField("employee id"), 
                                    stringField("responsibility id"));
        
        } catch (hva.exceptions.UnknownEmployeeKeyCoreException e) {
            throw new UnknownEmployeeKeyException(e.getKey());

        } catch (hva.exceptions.NoResponsibilityCoreException e) {
            throw new NoResponsibilityException(e.getEmployeeId(), 
                                                e.getResponsibilityId());
        }
    }

}