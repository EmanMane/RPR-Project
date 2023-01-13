package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;

import java.util.ArrayList;
import java.util.List;

/**
 * Business Logic Layer for Users
 *
 * @author Eman Alibalić
 */
public class UserManager {

    public List<User> getAll() throws AnimalException {
        return DaoFactory.userDao().getAll();
    }

    public List<User> searchUser(String text) throws AnimalException {
        return DaoFactory.userDao().searchByName(text);
    }

    public boolean validateUser(String username,String password) throws AnimalException{
        if (password == null || username==null){
            throw new AnimalException("No username or password!");
        }
        else {
            List<User> x = new ArrayList<User>();
            x = searchUser(username);
            for (User u : x) {
                if (u.getUsername().equals(username)) {
                    if (u.getPassword().equals(password)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean validateNewUser(String username) throws AnimalException{
        if (username==null){
            throw new AnimalException("No username!");
        }
        else {
            List<User> x = new ArrayList<User>();
            x = searchUser(username);
            for (User u : x) {
                if (u.getUsername().equals(username)) {
                        return false;
                }
            }
            return true;
        }
    }

    public void delete(int id) throws AnimalException{
        DaoFactory.userDao().delete(id);
    }

    public User getById(int userId) throws AnimalException{
        return DaoFactory.userDao().getById(userId);
    }

    public void update(User x) throws AnimalException{
        DaoFactory.userDao().update(x);
    }

    public User add(User x) throws AnimalException{
        return DaoFactory.userDao().add(x);
    }

}