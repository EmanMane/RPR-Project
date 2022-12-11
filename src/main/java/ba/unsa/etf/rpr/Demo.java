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
        Habitat x = new Habitat();
        x.setId(25); x.setName("Zanzibarius");
        x=dao.add(x);
    }
}
