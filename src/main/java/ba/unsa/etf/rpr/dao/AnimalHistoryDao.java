package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.AnimalHistory;
import java.util.Date;
import java.util.List;

/**
 * Dao interface for AnimalHistory domain bean
 *
 * @author Eman Alibalić
 */
public interface AnimalHistoryDao extends Dao<AnimalHistory> {

    /**
     * Search animal history in database based on date range
     * @param start start date
     * @param end end date
     * @return List of animals from history table
     */
    List<AnimalHistory> getByDateRange(Date start, Date end);
}
