package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL Implementation of DAO
 * @author Eman Alibalić
 */
public class AnimalDaoSQLImpl extends AbstractDao<Animal> implements AnimalDao{

    public AnimalDaoSQLImpl() {
        super("animals");
    }

    @Override
    public Animal row2object(ResultSet rs) throws AnimalException{
        try {
            Animal q = new Animal();
            q.setId(rs.getInt("id"));
            q.setAnimal(rs.getString("animal"));
            q.setHabitat(DaoFactory.habitatDao().getById(rs.getInt("habitat_id")));
            return q;
        } catch (Exception e) {
            throw new AnimalException(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    @Override
    public Map<String, Object> object2row(Animal object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("animal", object.getAnimal());
        item.put("habitat_id", object.getHabitat().getId());

//ISPIS Provjera
        for(Map.Entry m:item.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }


        return item;
    }

    /**
     * @param text search string for animals
     * @return list of animals
     * @author ahajro2
     */

    @Override
    public List<Animal> searchByType(String text) throws AnimalException{
        return executeQuery("SELECT * FROM animals WHERE animal LIKE concat('%', ?, '%')", new Object[]{text});
    }


    /**
     * @param habitat search string for animals
     * @return list of animals
     * @author ahajro2
     */
    @Override
    public List<Animal> searchByHabitat(Habitat habitat) throws AnimalException{
        return executeQuery("SELECT * FROM animals WHERE habitat_id = ?", new Object[]{habitat.getId()});
    }

    /**
     * @return random animal from DB
     * @throws AnimalException in case of error working with db
     */
    @Override
    public Animal randomAnimal() throws AnimalException {
        return executeQueryUnique("SELECT * FROM animals ORDER BY RAND() LIMIT 1", null);
    }
}