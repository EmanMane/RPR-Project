package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.util.List;

/**
 * Dao interface for Animal domain bean
 * @author Eman Alibalić
 */
public interface AnimalDao extends Dao<Animal>{

    /**
     * Returns all animals of the same type.
     *
     * @param type search type for animals
     * @return list of animals
     */
    List<Animal> searchByType(String type) throws AnimalException;

    /**
     * Returns all animals that are in chosen habitat.
     *
     * @param habitat search string for animals
     * @return list of animals in the chosen habitat
     */
    List<Animal> searchByHabitat(Habitat habitat) throws AnimalException;

    /**
     * Returns a random animal from animals table
     *
     * @return random animal
     * @throws AnimalException
     */
    Animal randomAnimal() throws AnimalException;

    int findFirstFreeID();
}