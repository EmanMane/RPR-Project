package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.AnimalHistory;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * MySQL implementation of DAO
 * @author Eman Alibalić
 */
public class AnimalHistoryDaoSQLImpl extends AbstractDao<AnimalHistory> implements AnimalHistoryDao{

    public AnimalHistoryDaoSQLImpl() {
        super("animal_history");
    }

    @Override
    public AnimalHistory row2object(ResultSet rs) throws AnimalException {
        try{
            AnimalHistory history = new AnimalHistory();
            history.setId(rs.getInt("id"));
            history.setDateLeft(rs.getDate("created"));
            history.setAnimal(DaoFactory.animalDao().getById(rs.getInt("animal_id")));
            return history;
        }catch (SQLException e){
            throw new AnimalException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(AnimalHistory object) {
        Map<String, Object> item = new TreeMap<>();
        item.put("id", object.getId());
        item.put("animal_id", object.getAnimal().getId());
        item.put("created", object.getDateLeft());
        return item;
    }

    @Override
    public List<AnimalHistory> getByDateRange(Date start, Date end) throws AnimalException {
        return executeQuery("SELECT * FROM animal_history WHERE generated BETWEEN ? AND ?", new Object[]{start, end});
    }
}