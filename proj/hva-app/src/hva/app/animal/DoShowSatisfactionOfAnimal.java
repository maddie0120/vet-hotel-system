 
package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);

        addStringField("animal id", Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {

            _display.popup(Math.round(
                _receiver.showSatisfactionOfAnimal(
                    stringField("animal id"))));

        } catch (hva.exceptions.UnknownAnimalKeyCoreException e) {
            throw new UnknownAnimalKeyException(e.getKey());
        }
    }

}