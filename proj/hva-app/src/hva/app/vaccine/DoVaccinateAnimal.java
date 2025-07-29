package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.app.exceptions.UnknownVaccineKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);

        addStringField("vaccine id", Prompt.vaccineKey());
        addStringField("vet id", Prompt.veterinarianKey());
        addStringField("animal id", hva.app.animal.Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {

        try {

            if (_receiver.vaccinateAnimal(stringField("vaccine id"),
                                    stringField("vet id"),
                                    stringField("animal id"))) {

                _display.popup(Message.wrongVaccine(
                                    stringField("vaccine id"),
                                    stringField("animal id")));
            }

        } catch (hva.exceptions.UnknownVaccineKeyCoreException e) {
            throw new UnknownVaccineKeyException(e.getKey());
        
        } catch (hva.exceptions.UnknownEmployeeKeyCoreException e) {
            throw new UnknownEmployeeKeyException(e.getKey());

        } catch (hva.exceptions.UnknownAnimalKeyCoreException e) {
            throw new UnknownAnimalKeyException(e.getKey());

        } catch (hva.exceptions.UnknownVeterinarianKeyCoreException e) {
            throw new UnknownVeterinarianKeyException(e.getKey());
        
        } catch (hva.exceptions.VeterinarianNotAuthorizedCoreException e) {
            throw new VeterinarianNotAuthorizedException(e.getVetId(), 
                                                         e.getSpeciesId());
        }
        
    }

}