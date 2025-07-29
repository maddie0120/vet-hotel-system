package hva.app.search;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);

        addStringField("habitat id", hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _display.popup(_receiver.getAllAnimalsInHabitat(
                                     stringField("habitat id")));

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());

        }

    }

}