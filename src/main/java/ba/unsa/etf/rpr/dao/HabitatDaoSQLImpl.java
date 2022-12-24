package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Eman Alibalić
 */
public class HabitatDaoSQLImpl extends AbstractDao<Habitat> implements HabitatDao{

    public HabitatDaoSQLImpl() {
        super("habitats");
    }

    @Override
    public Habitat row2object(ResultSet rs) throws AnimalException {
        try {
            Habitat cat = new Habitat();
            cat.setId(rs.getInt("id"));
            cat.setName(rs.getString("name"));
            return cat;
        } catch (SQLException e) {
            throw new AnimalException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Habitat object) {
        Map<String, Object> row = new TreeMap<>();
        row.put("id", object.getId());
        row.put("name", object.getName());
        return row;
    }
}