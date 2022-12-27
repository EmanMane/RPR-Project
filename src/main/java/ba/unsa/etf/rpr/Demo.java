package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.dao.HabitatDao;
import ba.unsa.etf.rpr.dao.HabitatDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Habitat;

/**
 * Demo interface for checking classes
 * @author Eman Alibalić
 * @version 0.0.1
 */
public class Demo {
    public static void main(String[] args) {
        HabitatDao dao = new HabitatDaoSQLImpl();
        Habitat x = new Habitat(),y = new Habitat();
        x.setId(25); //id must not be duplicate
        x.setName("Zanzibarius");
        //When adding identical object into table Too many connections exception is thrown
        //x=dao.add(x);

        /*y.setId(26); //id must not be duplicate
        y.setName("Kukurus");
        //When adding identical object into table Too many connections exception is thrown
        y=dao.add(y);*/
    }
}
