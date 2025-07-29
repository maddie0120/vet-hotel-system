package hva.app.main;

import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoOpenFile extends Command<HotelManager> {

    DoOpenFile(HotelManager receiver) {
        super(Label.OPEN_FILE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {

        if (_receiver.changed() && 
            Form.confirm(Prompt.saveBeforeExit())) {

            new DoSaveFile(_receiver).performCommand();
        }

        try {

            _receiver.load(Form.requestString(Prompt.openFile()));

        } catch (hva.exceptions.UnavailableFileException e) {
            throw new FileOpenFailedException(e);
        }

    }
    
}