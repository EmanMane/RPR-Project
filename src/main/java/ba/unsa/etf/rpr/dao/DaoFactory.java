package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Eman Alibalić
 */
public class DaoFactory {

    private static final HabitatDao habitatDao = HabitatDaoSQLImpl.getInstance();
    private static final AnimalDao animalDao = AnimalDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();
    private DaoFactory(){
    }

    public static HabitatDao habitatDao(){
        return habitatDao;
    }

    public static AnimalDao animalDao(){
        return animalDao;
    }

    public static UserDao userDao(){
        return userDao;
    }

}