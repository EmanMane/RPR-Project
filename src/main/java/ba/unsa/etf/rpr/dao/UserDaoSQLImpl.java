package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * MySQL Implementation of DAO
 * @author Eman Alibalić
 */
public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static  UserDaoSQLImpl instance = null;
    private UserDaoSQLImpl() {
        super("users");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public User row2object(ResultSet rs) throws AnimalException{
        try {
            User x = new User();
            x.setId(rs.getInt("id"));
            x.setUsername(rs.getString("username"));
            x.setPassword(rs.getString("password"));
            x.setAdmin(rs.getInt("admin"));
            return x;
        }catch (SQLException e){
            throw new AnimalException(e.getMessage(), e);
        }
    }

    /**
     * @param object - object to be mapped
     * @return map representation of object
     */
    public Map<String, Object> object2row(User object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("username", object.getUsername());
        item.put("password", object.getPassword());
        item.put("admin", object.getAdmin());
        return item;
    }

    /**
     * @param sample search string for animals
     * @return list of animals
     * @author Eman Alibalić
     */

    @Override
    public List<User> searchByName(String sample)throws AnimalException{
        return executeQuery("SELECT * FROM users WHERE username LIKE concat('%', ?, '%')", new Object[]{sample});
    }


    /**
     * @param admin search string for animals
     * @return list of animals
     * @author Eman Alibalić
     */
    @Override
    public List<User> searchByAdmin(int admin) throws AnimalException{
        return executeQuery("SELECT * FROM users WHERE admin = ?", new Object[]{admin});
    }
}