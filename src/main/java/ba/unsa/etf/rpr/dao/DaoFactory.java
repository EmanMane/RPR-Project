package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final HabitatDao habitatDao = new HabitatDaoSQLImpl();
    private static final AnimalDao animalDao = new AnimalDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();


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
