package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQLs implementation of the DAO
 * @author Eman Alibalić
 */
public class HabitatDaoSQLImpl extends AbstractDao<Habitat> implements HabitatDao{

    private static  HabitatDaoSQLImpl instance = null;
    private HabitatDaoSQLImpl() {
        super("habitats");
    }

    public static HabitatDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new HabitatDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
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

    public int findFirstFreeID(){
        try {
            PreparedStatement stmt = getConnection().prepareStatement("SELECT MIN(t1.id + 1) AS nextID\n" +
                    "        FROM habitats t1\n" +
                    "        LEFT JOIN habitats t2\n" +
                    "        ON t1.id + 1 = t2.id\n" +
                    "        WHERE t2.id IS NULL;");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}