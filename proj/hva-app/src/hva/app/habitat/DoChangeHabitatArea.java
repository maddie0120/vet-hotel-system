package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);

        addStringField("id", Prompt.habitatKey());
        addIntegerField("habitat area", Prompt.habitatArea());
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _receiver.changeHabitatArea(stringField("id"), 
                                        integerField("habitat area"));

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }

}