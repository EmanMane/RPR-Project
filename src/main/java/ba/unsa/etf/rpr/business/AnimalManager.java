package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.domain.AnimalHistory;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.util.Date;
import java.util.List;

/**
 * Business Logic Layer for Animals
 *
 * @author Eman Alibalić
 */
public class AnimalManager {

    public List<Animal> getAll() throws AnimalException {
        return DaoFactory.animalDao().getAll();
    }

    public List<Animal> searchAnimals(String text) throws AnimalException {
        return DaoFactory.animalDao().searchByType(text);
    }

    public void delete(int id) throws AnimalException{
        DaoFactory.animalDao().delete(id);
    }

    public Animal getById(int animalId) throws AnimalException{
        return DaoFactory.animalDao().getById(animalId);
    }

    public void update(Animal q) throws AnimalException{
        DaoFactory.animalDao().update(q);
    }

    public Animal add(Animal q) throws AnimalException{
        return DaoFactory.animalDao().add(q);
    }

    public Animal randomAnimal() throws AnimalException{
        Animal a = DaoFactory.animalDao().randomAnimal();
        // save animal into history
        AnimalHistory history = new AnimalHistory();
        history.setAnimal(a);
        DaoFactory.animalHistoryDao().add(history);

        return a;
    }

}