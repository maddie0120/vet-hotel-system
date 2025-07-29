package hva;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hva.exceptions.ImportFileException;
import hva.exceptions.MissingFileAssociationException;
import hva.exceptions.UnavailableFileException;


/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** This is the hotel manager */
    private String _filename = "";

    /** This is the current hotel. */
    private Hotel _hotel = new Hotel();



    /**
     * Saves the serialized application's state into the file 
     * associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file 
     *                               cannot be created or opened.
     * @throws MissingFileAssociationException if the current network
     *                                         does not have a file.
     * @throws IOException if there is some error while serializing 
     *                     the state of the network to disk.
     */
    public void save() throws FileNotFoundException, 
                              MissingFileAssociationException, 
                              IOException {

        if (_filename == null || _filename.isBlank()) {
            throw new MissingFileAssociationException();
        }

        if (_hotel.hasChanged()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                                      new BufferedOutputStream(
                                      new FileOutputStream(_filename)))) {
                oos.writeObject(_hotel);
                _hotel.setChanged(false);
            }
        }
        
    }


    /**
     * Saves the serialized application's state into the file 
     * associated to the current network.
     *
     * @param filename
     * @throws FileNotFoundException if for some reason the file 
     *                               cannot be created or opened.
     * @throws MissingFileAssociationException if the current network 
     *                                         does not have a file.
     * @throws IOException if there is some error while serializing 
     *                     the state of the network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException,
                    MissingFileAssociationException, IOException {

        _filename = filename;
        save();

    }


    /**
     * @param filename name of the file containing the serialized 
     *                 application's state to load.
     * @throws UnavailableFileException if the specified file does 
     *                                  not exist or there is an 
     *                                  error while processing this 
     *                                  file.
     */
    public void load(String filename) throws UnavailableFileException {

        _filename = filename;
        try (ObjectInputStream ois = new ObjectInputStream(
                                     new BufferedInputStream(
                                     new FileInputStream(filename)))) {
            _hotel = (Hotel) ois.readObject();
            _hotel.setChanged(false);
        } catch (IOException | ClassNotFoundException e) {
            throw new UnavailableFileException(_filename);
        }

    }


    /**
     * Read text input file.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     */
    public void importFile(String filename) throws ImportFileException {
        _hotel.importFile(filename);
    }
    

    /** 
     * @return filename
     */
    public String getFilename() {
        return _filename;
    }


    /**
     * @param filename
     */
    public void setFilename(String filename) {
        _filename = filename;
    }


    /**
     * @return changed?
     */
    public boolean changed() {
        return _hotel.hasChanged();
    }


    /**
     * @return hotel
     */
    public Hotel getHotel() {
        return _hotel;
    }


    /**
     * Reset the hotel.
     */
    public void reset() {
        _hotel = new Hotel();
        _filename = null;
    }


    /**
     * Advances the current season.
     */
    public int advanceSeason() {
        return _hotel.setSeason();
    }


    /** 
     * Calculates and returns the total global satisfaction of the 
     * hotel.
     */
    public double showGlobalSatisfaction() {
        return _hotel.getGlobalSatisfaction();
    }

}
