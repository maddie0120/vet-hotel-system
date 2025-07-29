package hva.app.employee;

import hva.Hotel;
import hva.app.exceptions.DuplicateEmployeeKeyException;
import hva.app.exceptions.UnknownEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);

        addStringField("employee id", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _display.popup(Math.round(
                _receiver.showSatisfactionOfEmployee(
                    stringField("employee id"))));

        } catch (hva.exceptions.UnknownEmployeeKeyCoreException e) {
            throw new UnknownEmployeeKeyException(e.getKey());
        }
    }

}