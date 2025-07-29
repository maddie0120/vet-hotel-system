package hva.app.habitat;

import hva.Hotel;
import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);

        addStringField("habitat id", Prompt.habitatKey());
        addStringField("tree id", Prompt.treeKey());
        addStringField("tree name", Prompt.treeName());
        addIntegerField("tree age", Prompt.treeAge());
        addIntegerField("tree difficulty", Prompt.treeDifficulty());
        addOptionField("tree type", 
                       Prompt.treeType(), "PERENE", "CADUCA");
    }

    @Override
    protected void execute() throws CommandException {
        try {
            
            _receiver.addTreeToHabitat(stringField("tree id"), 
                        stringField("tree name"),
                        integerField("tree age").toString(),
                        integerField("tree difficulty").toString(),
                        optionField("tree type"), 
                        stringField("habitat id"));

            _display.popup(_receiver.getTree(stringField("tree id")));

        } catch (hva.exceptions.DupTreeKeyCoreException e) {
            throw new DuplicateTreeKeyException(e.getKey());

        } catch (hva.exceptions.UnknownHabitatKeyCoreException e) {
            throw new UnknownHabitatKeyException(e.getKey());

        } catch (hva.exceptions.UnrecognizedEntryException e) {
            e.printStackTrace();
        }
    }

}