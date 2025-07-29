package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);

        addStringField("habitat id", Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _display.popup(_receiver.getAllTreesInHabitat(
                                     stringField("habitat id")));

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }

}