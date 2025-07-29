 
package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownVeterinarianKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);

        addStringField("vet id", hva.app.employee.Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
        _display.popup(_receiver.getMedicalActsByVeterinarian(
                                 stringField("vet id")));

        } catch (hva.exceptions.UnknownVeterinarianKeyCoreException e) {
            throw new UnknownVeterinarianKeyException(e.getKey());

        }
    }

}