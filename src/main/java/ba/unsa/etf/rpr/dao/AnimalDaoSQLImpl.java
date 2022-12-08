package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDaoSQLImpl implements AnimalDao {

    private Connection connection;

    public AnimalDaoSQLImpl(){
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Animal getById(int id) {
        String query = "SELECT * FROM quotes WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                Animal animal = new Animal();
                animal.setId(rs.getInt("id"));
                animal.setAnimal(rs.getString("quote"));
                animal.setCreated(rs.getDate("created"));
                rs.close();
                return animal;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public Animal add(Animal item) {
        return null;
    }


    @Override
    public Animal update(Animal item) {
        return null;
    }


    @Override
    public void delete(int id) {

    }

    @Override
    public List<Animal> getAll() {
        return null;
    }

    /**
     * @param id for searching habitat for animals
     * @return specific Habitat for specific Animal from db
     * @author Eman Alibalić
     */

    public Habitat returnHabitatForId(int id) {
        String query = "SELECT * FROM categories WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Habitat x = new Habitat();
                x.setId(rs.getInt(1));
                x.setName(rs.getString(2));
                return x;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param type search string for animals
     * @return list of animals
     * @author Eman Alibalić
     */

    @Override
    public List<Animal> searchByType(String type) {
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM quotes WHERE quote LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Animal> animalList = new ArrayList<>();
            while (rs.next()) {
                Animal x = new Animal();
                x.setId(rs.getInt(1));
                x.setAnimal(rs.getString(2));
                x.setHabitat(returnHabitatForId(rs.getInt(4)));
                x.setCreated(rs.getDate(3));
                animalList.add(x);
            }
            return animalList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param habitat search string for animals
     * @return list of animals
     * @author Eman Alibalić
     */

    @Override
    public List<Animal> searchByCategory(Habitat habitat) {
        String query = "SELECT * FROM quotes WHERE habitat = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, habitat.getId());
            ResultSet rs = stmt.executeQuery();
            ArrayList<Animal> animalList = new ArrayList<>();
            while (rs.next()) {
                Animal q = new Animal();
                q.setId(rs.getInt(1));
                q.setAnimal(rs.getString(2));
                q.setHabitat(habitat);
                q.setCreated(rs.getDate(3));
                animalList.add(q);
            }
            return animalList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}