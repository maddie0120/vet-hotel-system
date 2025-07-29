package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);

        addStringField("habitat id", Prompt.habitatKey());
        addStringField("species id", hva.app.animal.Prompt.speciesKey());
        addOptionField("influence", Prompt.habitatInfluence(), 
                                    "POS", "NEU", "NEG");
    }

    @Override
    protected void execute() throws CommandException {
        try {

            _receiver.changeHabitatInfluence(stringField("habitat id"), 
                                             stringField("species id"), 
                                             optionField("influence"));
        
        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());

        } catch (hva.exceptions.UnknownSpeciesKeyCoreException e) {
            throw new UnknownSpeciesKeyException(e.getKey());
        }
    }

}