package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);

        addStringField("animal id", hva.app.animal.Prompt.animalKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
        _display.popup(_receiver.getMedicalActsOnAnimal(
                                 stringField("animal id")));

        } catch (hva.exceptions.UnknownAnimalKeyCoreException e) {
            throw new UnknownAnimalKeyException(e.getKey());

        }
    }

}