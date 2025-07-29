package hva.app.main;

import java.io.IOException;

import hva.HotelManager;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.forms.Form;


class DoSaveFile extends Command<HotelManager> {

    DoSaveFile(HotelManager receiver) {
        super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
    }

    @Override
    protected final void execute() {
        try {

            try {
                
                _receiver.save();

            } catch (hva.exceptions.MissingFileAssociationException e) {
                _receiver.saveAs(Form.requestString(Prompt.newSaveAs()));
            }

        } catch (IOException |
                 hva.exceptions.MissingFileAssociationException e) {
            e.printStackTrace();
        }
    }

}