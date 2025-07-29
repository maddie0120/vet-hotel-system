package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);

        addStringField("id", Prompt.animalKey());
        addStringField("name", Prompt.animalName());
        addStringField("species id", Prompt.speciesKey());
        addStringField("habitat id", 
                       hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {

            _receiver.registerAnimal(stringField("id"), 
                                     stringField("name"), 
                                     stringField("species id"), 
                                     stringField("habitat id"));
            
        } catch (hva.exceptions.UnknownSpeciesKeyCoreException e) {

            _receiver.registerSpecies(stringField("species id"), 
                        Form.requestString(Prompt.speciesName()));

            try {

                _receiver.registerAnimal(stringField("id"), 
                                         stringField("name"), 
                                         stringField("species id"), 
                                         stringField("habitat id"));

            } catch (hva.exceptions.DupAnimalKeyCoreException e2) {
                throw new DuplicateAnimalKeyException(e2.getKey());
        
            } catch (hva.exceptions.UnknownHabitatKeyCoreException e2) {
                throw new UnknownHabitatKeyException(e2.getKey());
           
            } catch (hva.exceptions.UnknownSpeciesKeyCoreException e2) {
                e2.printStackTrace();
            }

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());

        } catch (hva.exceptions.DupAnimalKeyCoreException e) {
            throw new DuplicateAnimalKeyException(e.getKey());
        }
    }

}