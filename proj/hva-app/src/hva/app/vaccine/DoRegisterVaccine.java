package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
        
        addStringField("id", Prompt.vaccineKey());
        addStringField("name", Prompt.vaccineName());
        addStringField("species id", Prompt.listOfSpeciesKeys());
    }

    @Override
    protected final void execute() throws CommandException {
        try {

            _receiver.registerVaccine(new String[] {"VACINA",
                                      stringField("id"), 
                                      stringField("name"),
                                      stringField("species id")});
                                      
        } catch (hva.exceptions.DupVaccineKeyCoreException e) {
            throw new DuplicateVaccineKeyException(e.getKey());
            
        } catch (hva.exceptions.UnknownSpeciesKeyCoreException e) {
            throw new UnknownSpeciesKeyException(e.getKey());
        }
    }

}
