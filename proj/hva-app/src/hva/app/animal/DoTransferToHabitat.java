package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);

        addStringField("animal id", Prompt.animalKey());
        addStringField("habitat id", 
                       hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {

            _receiver.transferToHabitat(stringField("animal id"), 
                                        stringField("habitat id"));

        } catch (hva.exceptions.UnknownAnimalKeyCoreException e) {
            throw new UnknownAnimalKeyException(e.getKey());

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }

}