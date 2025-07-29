package hva;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import hva.animal.Animal;
import hva.animal.Species;
import hva.employee.Caretaker;
import hva.employee.Employee;
import hva.employee.Vet;
import hva.exceptions.DupAnimalKeyCoreException;
import hva.exceptions.DupEmployeeKeyCoreException;
import hva.exceptions.DupHabitatKeyCoreException;
import hva.exceptions.DupTreeKeyCoreException;
import hva.exceptions.DupVaccineKeyCoreException;
import hva.exceptions.ImportFileException;
import hva.exceptions.NoResponsibilityCoreException;
import hva.exceptions.UnknownAnimalKeyCoreException;
import hva.exceptions.UnknownEmployeeKeyCoreException;
import hva.exceptions.UnknownHabitatKeyCoreException;
import hva.exceptions.UnknownSpeciesKeyCoreException;
import hva.exceptions.UnknownVaccineKeyCoreException;
import hva.exceptions.UnknownVeterinarianKeyCoreException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.VeterinarianNotAuthorizedCoreException;
import hva.habitat.Deciduous;
import hva.habitat.Evergreen;
import hva.habitat.Habitat;
import hva.habitat.Influence;
import hva.habitat.Tree;
import hva.seasons.Season;
import hva.seasons.Spring;
import hva.vaccine.Vaccination;
import hva.vaccine.Vaccine;


public class Hotel implements Serializable {

    /** Class serial number. */
    @Serial
    private static final long serialVersionUID = 202407081733L;

    /** Hotel object has been changed. */
    private boolean _changed = false; 

    /**
     * Stores all animals, sorted by their id.
     */
    private Map<String, Animal> _allAnimals = 
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * Stores all employees, sorted by their id.
     */
    private Map<String, Employee> _allEmployees = 
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);           

    /**
     * Stores all habitats, sorted by their id.
     */
    private Map<String, Habitat> _allHabitats = 
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * Stores all species, sorted by their id.
     */
    private Map<String, Species> _allSpecies = 
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * Stores all trees.
     */
    private Map<String, Tree> _allTrees = new TreeMap<>(); 

    /**
     * Stores all vaccinations e chronological order.
     */
    private List<Vaccination> _allVaccinations = new ArrayList<>();

    /**
     * Stores all vaccines, sorted by their id.
     */
    private Map<String, Vaccine> _allVaccines = 
            new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    /**
     * Stores the current season.
     * By default the starting season is Spring.
     */
    private Season _currentSeason = new Spring();



    /**
     * @param changed 
     */
    public void setChanged(boolean changed) {
        _changed = changed;
    }

    /**
     * Set changed.
     */
    public void changed() {
        setChanged(true);
    }

    /**
     * @return _changed
     */
    public boolean hasChanged() { 
        return _changed;
    }

    
    /**
     * Get all animals in the Hotel, sorted by their id.
     *
     * @return all animals as an unmodifiable collection.
     */
    public Collection<Animal> getAllAnimals() {
        return Collections.unmodifiableCollection(_allAnimals.values());
    }

    /**
     * Get all employees in the Hotel, sorted by their id.
     *
     * @return all employees as an unmodifiable collection.
     */
    public Collection<Employee> getAllEmployees() {
        return Collections.unmodifiableCollection(_allEmployees.values());
    }

    /**
     * Get all habitats in the Hotel, sorted by their id.
     *
     * @return all habitats as an unmodifiable collection.
     */
    public Collection<Habitat> getAllHabitats() {
        return Collections.unmodifiableCollection(_allHabitats.values());
    }

    /**
     * Get all vaccinations, sorted in chronological order.
     * 
     * @return all vaccinations as a List.
     */
    public List<Vaccination> getAllVaccinations() {
        return _allVaccinations;
    }

    /**
     * Get all vaccines in the Hotel, sorted by their id.
     *
     * @return all vaccines as an unmodifiable collection.
     */
    public Collection<Vaccine> getAllVaccines() {
        return Collections.unmodifiableCollection(_allVaccines.values());
    }


    /**
     * @param idA the id of the animal to retrieve.
     * 
     * @return the Animal corresponding to the provided id, 
     *         or null if no animal with the given id exists.
     */
    public Animal getAnimal(String idA){
        return _allAnimals.get(idA);
    }

    /**
     * @param idE the id of the employee to retrieve.
     * 
     * @return the Employee corresponding to the provided id, 
     *         or null if no employee with the given id exists.
     */
    public Employee getEmployee(String idE){
        return _allEmployees.get(idE);
    }

    /**
     * @param idH the id of the habitat to retrieve.
     * 
     * @return the Habitat corresponding to the provided id, 
     *         or null if no habitat with the given id exists.
     */
    public Habitat getHabitat(String idH){
        return _allHabitats.get(idH);
    }    

    /**
     * @param idS the id of the Species to retrieve.
     * 
     * @return the Species corresponding to the provided id, 
     *         or null if no species with the given id exists.
     */
    public Species getSpecies(String idS){
        return _allSpecies.get(idS);
    }
    
    /**
     * @param idT the id of the tree to retrieve.
     * 
     * @return the Tree corresponding to the provided id, 
     *         or null if no tree with the given id exists.
     */
    public Tree getTree(String idT){
        return _allTrees.get(idT);
    }

    /**
     * @param idV the id of the vaccine to retrieve.
     * 
     * @return the Vaccine corresponding to the provided id, 
     *         or null if no vaccine with the given id exists.
     */
    public Vaccine getVaccine(String idV){
        return _allVaccines.get(idV);
    }


    /**
     * Get all trees in the specified habitat, sorted by their id.
     */
    public Collection<Tree> getAllTreesInHabitat(String id) 
        throws UnknownHabitatKeyCoreException {

        if (getHabitat(id) == null) {
            throw new UnknownHabitatKeyCoreException(id);
        }

        return getHabitat(id).getTrees();
    }


    /**
     * Get all animals in the specified habitat, sorted by their id.
     */
    public Collection<Animal> getAllAnimalsInHabitat(String idH) 
        throws UnknownHabitatKeyCoreException {

        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }

        Collection<Animal> animals = getAllAnimals();
        Collection<Animal> animalsInHabitatList = new ArrayList<>();

        for (Animal a : animals) {
            if (a.getHabitat().getId().equalsIgnoreCase(idH)) {
                animalsInHabitatList.add(a);
            }
        }

        return Collections.unmodifiableCollection(animalsInHabitatList);
    }


    /**
     * Get all vaccinations performed by the specified veterinarian, 
     * in chronological order.
     */
    public Collection<Vaccination> getMedicalActsByVeterinarian(String idV)
        throws UnknownVeterinarianKeyCoreException {

        if (getEmployee(idV) == null) {
            throw new UnknownVeterinarianKeyCoreException(idV);
        }

        Collection<Vaccination> vaccinations = getAllVaccinations();
        Collection<Vaccination> actsByVeterinarianList = new ArrayList<>();


        for(Vaccination v : vaccinations) {
            if(v.getVet().getId().equalsIgnoreCase(idV)) {
                actsByVeterinarianList.add(v);
            }
        }

        return Collections.unmodifiableCollection(actsByVeterinarianList);
    }


    /**
     * Get all vaccinations administered to the specified animal, in 
     * chronological order.
     */
    public List<Vaccination> getMedicalActsOnAnimal (String idA)
        throws UnknownAnimalKeyCoreException{

        if (getAnimal(idA) == null) {
            throw new UnknownAnimalKeyCoreException(idA);
        }

        return getAnimal(idA).getVaccinationHistory();
    }


    /**
     * Retrieves a collection of vaccinations that were incorrectly 
     * administered, sorted in chronological order.
     */
    public Collection<Vaccination> getWrongVaccinations() {

        Collection<Vaccination> vaccinations = getAllVaccinations();
        Collection<Vaccination> wrongVaccinationsList = new ArrayList<>();


        for(Vaccination v : vaccinations) {
            if(!(v.getDamage().equals("NORMAL"))) {
                wrongVaccinationsList.add(v);
            }
        }

        return Collections.unmodifiableCollection(wrongVaccinationsList);
    }
    

    /**
     * Determines the global satisfaction.
     */
    public double getGlobalSatisfaction() {

        double animalSat = 0;
        double employeeSat = 0;

        if (!_allEmployees.isEmpty()) {
            for (Employee e : _allEmployees.values()) {
                employeeSat += e.getEmployeeSatisfaction(_currentSeason);
            }
        }

        if (!_allAnimals.isEmpty()) {
            for (Animal a : _allAnimals.values()) {
                animalSat += a.getAnimalSatisfaction();
            }    
        }
        
        return animalSat + employeeSat;
    }

    
    /**
     * Advances to the next season and updates the cycle of all trees 
     * accordingly.
     */
    public int setSeason() {
        _currentSeason = _currentSeason.nextSeason();

        List<Tree> treeList = new ArrayList<>(_allTrees.values()); 
        updateTreeCycle();

        for (Tree t : treeList) {
            t.increaseAge();
        }

        changed();

        return _currentSeason.getSeasonIndex();
    }
    

    /**
     * Read text input file and create domain entities.
     *
     * @param filename  name of the text input file
     * @throws ImportFileException
     */
    void importFile(String filename) throws ImportFileException {

        try (BufferedReader reader = new BufferedReader(
                                     new FileReader(filename))) {
            String line; 

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("\\|");

                try {
                    registerEntry(fields);
                } catch (UnrecognizedEntryException | 
                         DupAnimalKeyCoreException | 
                         DupEmployeeKeyCoreException | 
                         DupHabitatKeyCoreException | 
                         DupTreeKeyCoreException | 
                         DupVaccineKeyCoreException | 
                         UnknownSpeciesKeyCoreException | 
                         UnknownHabitatKeyCoreException |
                         NoResponsibilityCoreException |
                         UnknownEmployeeKeyCoreException e) {
                    e.printStackTrace();
                }

            }

        } catch (IOException e) {
            throw new ImportFileException(filename, e);
        }

    }


    /**
     * Parse and register an entry (line) from a plain text file.
     *
     * @param fields The fields of the entry to register, that were 
     *               split by the separator.
     * @throws UnrecognizedEntryException  if the entry type is 
     *                                     unknown and not supported 
     *                                     by the program.
     * @throws DupAnimalKeyCoreException   if an animal with the 
     *                                     given key already exists.
     * @throws DupEmployeeKeyCoreException if an employee with the 
     *                                     given key already exists.
     * @throws DupHabitatKeyCoreException  if a habitat with the 
     *                                     given key already exists.
     * @throws DupTreeKeyCoreException     if a tree with the 
     *                                     given key already exists.
     * @throws DupVaccineKeyCoreException  if a vaccine with the 
     *                                     given key already exists.
     * @throws UnknownSpeciesKeyCoreException  if the provided key 
     *                                         doesn't match any 
     *                                         known species.
     * @throws UnknownHabitatKeyCoreException  if the provided key 
     *                                         doesn't match any 
     *                                         known habitat.
     * @throws NoResponsibilityCoreException   if the provided key 
     *                                         doesn't match any 
     *                                         known responsability.
     * @throws UnknownEmployeeKeyCoreException if the provided key 
     *                                         doesn't match any 
     *                                         known employee.
     */
    public void registerEntry(String[] fields) 
        throws UnrecognizedEntryException, DupAnimalKeyCoreException,
        DupEmployeeKeyCoreException, DupHabitatKeyCoreException, 
        DupTreeKeyCoreException, DupVaccineKeyCoreException, 
        UnknownSpeciesKeyCoreException, UnknownHabitatKeyCoreException, 
        NoResponsibilityCoreException, UnknownEmployeeKeyCoreException {

        switch (fields[0]) {
            case "ÁRVORE" -> registerTree(fields[1], fields[2], 
                                            fields[3], fields[4], 
                                            fields[5]);
            case "ANIMAL" -> registerAnimal(fields[1], fields[2], 
                                            fields[3], fields[4]);
            case "ESPÉCIE" -> registerSpecies(fields[1], fields[2]);                                            
            case "HABITAT" -> registerHabitat(fields);                                            
            case "VACINA" -> registerVaccine(fields);
            case "TRATADOR", "VETERINÁRIO" -> registerEmployee(fields);             
            default -> throw new UnrecognizedEntryException(fields[0]);
        }   

    }


    /**
     * Register a new tree in the hotel, which will be created from 
     * the given parameters.
     *
     * @param id        The id of the tree.
     * @param name      The name of the tree.
     * @param age       The age of the tree.
     * @param cleaning  The cleaning difficulty of the tree.
     * @param type      The type of the tree.
     */
    public void registerTree(String id, String name, String age, 
                             String cleaning, String type) 
        throws UnrecognizedEntryException, DupTreeKeyCoreException {

        if (getTree(id) != null) {
            throw new DupTreeKeyCoreException(id);
        }

        Tree t = switch(type) {
            case "PERENE" -> new Evergreen(id, name, 
                                           Double.parseDouble(age), 
                                           Integer.parseInt(cleaning), 
                                           _currentSeason);
            case "CADUCA" -> new Deciduous(id, name, 
                                           Integer.parseInt(age), 
                                           Integer.parseInt(cleaning),
                                           _currentSeason);
            default -> throw new UnrecognizedEntryException(type);
        };

        _allTrees.put(id, t);
        changed();
        
    }


    /**
     * Register a new animal in the hotel, which will be created from
     * the given parameters.
     *
     * @param id      The id of the animal.
     * @param name    The name of the animal.
     * @param idS     The id of the species to which the animal 
     *                belongs.
     * @param idH     The id of the habitat to which the animal 
     *                belongs.
     */
    public void registerAnimal(String id, String name, String idS, 
                               String idH) 
        throws DupAnimalKeyCoreException, 
        UnknownHabitatKeyCoreException, UnknownSpeciesKeyCoreException {

        if (getAnimal(id) != null) {
            throw new DupAnimalKeyCoreException(id);
        }        
        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }
        if (getSpecies(idS) == null) {
            throw new UnknownSpeciesKeyCoreException(idS);
        }

        Species s = getSpecies(idS);
        Habitat h = getHabitat(idH);

        Animal a = new Animal(id, name, s, h);
        _allAnimals.put(id, a);

        s.increaseAnimalCount();
        int num = h.getNumberOfAnimalsFromSpecies(s);
        h.setSpeciesAnimalCount(s, num + 1);

        changed();
    }


    /**
     * Register a new species in the hotel, which will be created 
     * from the given parameters.
     *
     * @param id      The id of the species.
     * @param name    The name of the species.
     */
    public void registerSpecies(String id, String name) { 

        Species s = new Species(id, name);
        _allSpecies.put(id, s);

        for (Habitat h : _allHabitats.values()) {
            h.getSpeciesAnimalCount().put(s, 0);
            h.getHabitatInfluence().put(s, Influence.NEU);
        }

        changed();
    }


    /**
     * Register a new habitat in the hotel, which will be created 
     * from the given parameters.
     *
     * @param fields The fields of the entry to import, that were 
     *               split by the separator.
     */
    public void registerHabitat(String[] fields) 
        throws DupHabitatKeyCoreException {

        if (getHabitat(fields[1]) != null) {
            throw new DupHabitatKeyCoreException(fields[1]);
        }

        Habitat h = new Habitat(fields[1], fields[2], 
                                Integer.parseInt(fields[3]));
        _allHabitats.put(fields[1], h);

        if (fields.length == 5) {
            String[] idT = fields[4].split(",");

            for (String i : idT) {
                Tree t = _allTrees.get(i);
                h.getTreesMap().put(i, t);
            }
        }

        for (Species s : _allSpecies.values()) {
            h.getSpeciesAnimalCount().put(s, 0);
            h.getHabitatInfluence().put(s, Influence.NEU);
        }

        changed();
    }


    /**
     * Adds a tree to the specified habitat, registering the tree 
     * with the provided attributes.
     */
    public void addTreeToHabitat(String id, String name, String age, 
                                 String cleaning, String type, 
                                 String idH)
        throws UnrecognizedEntryException, DupTreeKeyCoreException,
               UnknownHabitatKeyCoreException {

        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }

        registerTree(id, name, age, cleaning, type);
        
        Habitat h = getHabitat(idH);
        h.getTreesMap().put(id, getTree(id));

        changed();
    }


    /**
     * Register a new vaccine in the hotel, which will be created 
     * from the given parameters.
     *
     * @param fields The fields of the entry to import, that were 
     *               split by the separator.
     */
    public void registerVaccine(String[] fields) 
        throws DupVaccineKeyCoreException, 
               UnknownSpeciesKeyCoreException {
            
        if (getVaccine(fields[1]) != null) {
            throw new DupVaccineKeyCoreException(fields[1]);
        }

        if (fields.length == 4) {
            addSpeciesToVaccine(fields[1], fields[2], fields[3]);
        }
        else {
            Vaccine v = new Vaccine(fields[1], fields[2]);
            _allVaccines.put(fields[1], v);
        }

        changed();
    }


    /**
     * Registers a vaccine and associates it with all specified 
     * species that can receive it.
     */
    public void addSpeciesToVaccine(String idV, String name, 
                                    String idSpecies)
        throws UnknownSpeciesKeyCoreException {

        String[] idS = idSpecies.split(",");

        if (verifySpecies(idS)) {
            Vaccine v = new Vaccine(idV, name);
            _allVaccines.put(idV, v);

            for (String id : idS) {
                Species species = getSpecies(id);
                v.getSpeciesId().put(id, species);
            }
        }
    }


    /**
     * Verifies that all specified species ids correspond to known 
     * species registered in the hotel.
     *
     * @param idSpecies an array of species ids to be checked.
     * @return true if all provided species ids are recognized in 
     *         the system.
     * 
     * @throws UnknownSpeciesKeyCoreException  if the provided key 
     *                                         doesn't match any 
     *                                         known species.
     */
    public boolean verifySpecies(String[] idSpecies) 
        throws UnknownSpeciesKeyCoreException {

        for (String id : idSpecies) {
            if (getSpecies(id) == null) {
                throw new UnknownSpeciesKeyCoreException(id);
            }
        }    

        return true;    
    }


    /**
     * Register a new employee in the hotel, which will be created 
     * from the given parameters.
     *
     * @param fields The fields of the entry to register, that were 
     *               split by the separator.
     */
    public void registerEmployee(String[] fields) 
        throws UnrecognizedEntryException, DupEmployeeKeyCoreException, 
        NoResponsibilityCoreException, UnknownEmployeeKeyCoreException {

        if (getEmployee(fields[1]) != null) {
            throw new DupEmployeeKeyCoreException(fields[1]);
        }

        Employee e = switch(fields[0]) {
            case "VETERINÁRIO", "VET" -> new Vet(fields[1], fields[2]);
            case "TRATADOR", "TRT" -> new Caretaker(fields[1], fields[2]);
            default -> throw new UnrecognizedEntryException(fields[0]);
        };

        _allEmployees.put(fields[1], e);

        if (fields.length == 4) {
            String[] idR = fields[3].split(",");
            for (String id : idR) {
                addResponsibilityToEmployee(fields[1], id);
            }
        }

        changed();
    }

    
    /**
     * Assigns a specified responsibility to an employee.
     */
    public void addResponsibilityToEmployee(String idE, String idR) 
        throws NoResponsibilityCoreException, 
               UnknownEmployeeKeyCoreException{
        
        if (getEmployee(idE) == null) {
            throw new UnknownEmployeeKeyCoreException(idE);
        }

        Employee e = getEmployee(idE);

        if (e instanceof Vet) {
            Vet v = (Vet) e;
            Species s = getSpecies(idR);

            if (s == null) {
                throw new NoResponsibilityCoreException(idE, idR);
            }
            else {
                v.addResponsibilityToVet(idR, s);
            }
        }

        else if (e instanceof Caretaker) {
            Caretaker c = (Caretaker) e;
            Habitat h = getHabitat(idR);

            if (h == null) {
                throw new NoResponsibilityCoreException(idE, idR);
            }
            else {
                c.addResponsibilityToCaretaker(idR, h);
            }
        }

        changed();
    }


    /**
     * Removes a specified responsibility from an employees.
     */
    public void removeResponsibilityFromEmployee(String idE, String idR) 
        throws NoResponsibilityCoreException, UnknownEmployeeKeyCoreException {
        
        if (getEmployee(idE) == null) {
            throw new UnknownEmployeeKeyCoreException(idE);
        }

        Employee e = getEmployee(idE);

        if (e instanceof Vet v) {
            if (getSpecies(idR) == null) {
                throw new NoResponsibilityCoreException(idE, idR);
            }
            else {
                v.removeResponsibilityFromVet(getSpecies(idR));
            }
        }

        else if (e instanceof Caretaker c) {
            if (getHabitat(idR) == null) {
                throw new NoResponsibilityCoreException(idE, idR);
            }
            else {
                c.removeResponsibilityFromCaretaker(getHabitat(idR));
            }
        }

        changed();
    }


    /**
     * As the season changes, the trees' biological cycles adjust 
     * accordingly.
     */
    public void updateTreeCycle() {
        List<Tree> newTreeList = new ArrayList<>(_allTrees.values()); 

        for(Tree t: newTreeList) {
            t.setCycle(_currentSeason);
        }
    }


    /**
     * Calculates the cleaning difficulty for a specific tree.
     */
    public double calculateCleaningDifficulty(Tree t) {
        return t.calculateTreeCleaningDifficulty(_currentSeason);
    }


    /**
     * Transfers an animal to a new habitat.
     */
    public void transferToHabitat(String idA, String idH) 
        throws UnknownHabitatKeyCoreException, 
               UnknownAnimalKeyCoreException {
        
        if (getAnimal(idA) == null) {
            throw new UnknownAnimalKeyCoreException(idA);
        }

        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }

        Animal animal = getAnimal(idA);
        Habitat newH = getHabitat(idH);

        Species s = animal.getSpecies();
        Habitat oldH = animal.getHabitat();  

        int num = oldH.getNumberOfAnimalsFromSpecies(s);
        int num2 = newH.getNumberOfAnimalsFromSpecies(s);

        oldH.setSpeciesAnimalCount(s, num - 1);
        animal.setHabitat(newH);
        newH.setSpeciesAnimalCount(s, num2 + 1);

        changed();
    }


    /*
     * Updates the area of a specified habitat.
     */
    public void changeHabitatArea(String idH, int area) 
        throws UnknownHabitatKeyCoreException {

        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }
        getHabitat(idH).setArea(area);

        changed();
    }


    /**
     * Updates the influence of a specified habitat over a certain 
     * species.
     */
    public void changeHabitatInfluence(String idH, String idS, 
                                       String newInf) 
        throws UnknownHabitatKeyCoreException, 
               UnknownSpeciesKeyCoreException {

        Influence influence = Influence.valueOf(newInf);

        if (getHabitat(idH) == null) {
            throw new UnknownHabitatKeyCoreException(idH);
        }
        else if (getSpecies(idS) == null) {
            throw new UnknownSpeciesKeyCoreException(idS);
        }

        Species s = getSpecies(idS);
        getHabitat(idH).getHabitatInfluence().put(s, influence);
        
        changed();
    }


    /*
     * Obtains the satisfaction level of a specified employee.
     */
    public double showSatisfactionOfEmployee(String id) 
        throws UnknownEmployeeKeyCoreException {

        if (getEmployee(id) == null) {
            throw new UnknownEmployeeKeyCoreException(id);
        }

        return getEmployee(id).getEmployeeSatisfaction(_currentSeason);
    }


    /**
     * Obtains the satisfaction level of a specified animal.
     */
    public double showSatisfactionOfAnimal(String id)
        throws UnknownAnimalKeyCoreException {

        if (getAnimal(id) == null) {
            throw new UnknownAnimalKeyCoreException(id);
        }

        return getAnimal(id).getAnimalSatisfaction();
    }


    /**
     * Vaccinates a specified animal with the given vaccine by an 
     * authorized veterinarian.
     *
     * @param idVaccine  the id of the vaccine to be administered.
     * @param idVet      the id of the veterinarian performing the 
     *                   vaccination.
     * @param idA        the id of the animal to be vaccinated.
     */
    public boolean vaccinateAnimal(String idVaccine, String idVet, 
                                   String idA) 
        throws UnknownAnimalKeyCoreException, 
               UnknownEmployeeKeyCoreException,
               UnknownVaccineKeyCoreException, 
               UnknownVeterinarianKeyCoreException, 
               VeterinarianNotAuthorizedCoreException {

        if (getVaccine(idVaccine) == null) {
            throw new UnknownVaccineKeyCoreException(idVaccine);
        }
        if (getEmployee(idVet) == null) {
            throw new UnknownEmployeeKeyCoreException(idVet);
        }
        if (getAnimal(idA) == null) {
            throw new UnknownAnimalKeyCoreException(idA);
        }
        if (getEmployee(idVet) instanceof Caretaker) {
            throw new UnknownVeterinarianKeyCoreException(idVet);
        }
        else {
            Vet vet = (Vet) getEmployee(idVet);

            if (!vet.getResponsibilities().containsKey(
                            getAnimal(idA).getSpecies().getId())) {
                throw new VeterinarianNotAuthorizedCoreException(idVet, idA);
            }
 
            Vaccine v = getVaccine(idVaccine);
            Species s = getAnimal(idA).getSpecies();
            boolean wrongVaccine = true;            
            int damage = v.calculateDamage(s.getName());
            String damageString = "";

            if (damage == 0) {

                if (v.getSpeciesId().get(s.getId()) == null) {
                    damageString = "CONFUSÃO";
                }
                else {
                    damageString = "NORMAL";
                    wrongVaccine = false;
                }

            }
            else if (damage <= 4 && damage >= 1) {
                damageString = "ACIDENTE";
            }
            else if (damage >= 5) {
                damageString = "ERRO";
            }

            Vaccination vac = new Vaccination(v, vet, getAnimal(idA),
                                              damageString);

            getAnimal(idA).getVaccinationHistory().add(vac);
            getAllVaccinations().add(vac);
            int num = v.getNumberOfUses();
            v.setNumberOfUses(num + 1);

            changed();

            return wrongVaccine;
        }
    }

}