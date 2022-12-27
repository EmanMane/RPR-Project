package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.util.List;

/**
 * Dao interface for User domain bean
 * @author Eman Alibalić
 */
public interface UserDao extends Dao<User>{

    /**
     * Returns all users based on input search.
     *
     * @param sample search type for users
     * @return list of users
     */
    List<User> searchByName(String sample) throws AnimalException;

    /**
     * Returns all users that are admins.
     *
     * @param admin if 0, returns all users, if 1 returns admins
     * @return list of users that are/not admins
     */
    List<User> searchByAdmin(int admin) throws AnimalException;

}