package hva.app.main;

import hva.HotelManager;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoNewFile extends Command<HotelManager> {

    DoNewFile(HotelManager receiver) {
        super(Label.NEW_FILE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {

        if (_receiver.changed() && 
            Form.confirm(Prompt.saveBeforeExit())) {
                
            new DoSaveFile(_receiver).performCommand();
        }
        _receiver.reset();

    }
    
}