package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.domain.AnimalHistory;
import ba.unsa.etf.rpr.domain.Habitat;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalHistoryDaoSQLImpl implements AnimalHistoryDao{
    private Connection connection;

    public AnimalHistoryDaoSQLImpl(){
        String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7583250";
        String user = "sql7583250";
        String password = "hpqdZqhxta";
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public AnimalHistory getById(int id){
        String query = "SELECT * FROM animal_history WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) { // result set is iterator.
                AnimalHistory animalHistory = new AnimalHistory();
                animalHistory.setId(rs.getInt("id"));
                animalHistory.setAnimal(rs.getString("animal"));
                //animalHistory.setDate(rs.getDate("date_left"));
                rs.close();
                return animalHistory;
            } else {
                return null; // if there is no elements in the result set return null
            }
        } catch (SQLException e) {
            e.printStackTrace(); // poor error handling
        }
        return null;
    }


    @Override
    public AnimalHistory add(AnimalHistory item){
        return null;
    }

    @Override
    public AnimalHistory update(AnimalHistory item) {
        return null;
    }


    //@Override
    //public Animal update(Animal item){
    //    return null;
    //}


    @Override
    public void delete(int id){

    }

    @Override
    public List<AnimalHistory> getAll() {
        return null;
    }

    //@Override
    //public List<Animal> getAll(){
    //    return null;
    //}

    /**
     * @param id for searching habitat for animals
     * @return specific Habitat for specific Animal from db
     * @author Eman Alibalić
     */

    public Habitat returnHabitatForId(int id){
        String query = "SELECT * FROM habitats WHERE id = ?";
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

    //@Override
    public List<Animal> searchByType(String type){
        //mora sa concat jer inace nece raditi jer radi sa key chars
        String query = "SELECT * FROM animals WHERE animal LIKE concat('%', ?, '%')";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Animal> animalList = new ArrayList<>();
            while (rs.next()) {
                Animal x = new Animal();
                x.setId(rs.getInt(1));
                x.setAnimal(rs.getString(2));
                x.setHabitat(returnHabitatForId(rs.getInt(3)));
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

    //@Override
    public List<Animal> searchByHabitat(Habitat habitat){
        String query = "SELECT * FROM animal_history WHERE habitat_id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, habitat.getId());
            ResultSet rs = stmt.executeQuery();//lista rezultata lafo
            ArrayList<Animal> animalList = new ArrayList<>();
            while (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt(1));
                a.setAnimal(rs.getString(2));
                a.setHabitat(habitat);
                animalList.add(a);
            }
            return animalList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<AnimalHistory> getByDateRange(Date start, Date end){
        List<AnimalHistory> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM animal_history WHERE date_left BETWEEN start AND end");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                AnimalHistory animalHistory = new AnimalHistory();
                animalHistory.setId(rs.getInt("id"));
                //animalHistory.setAnimal(new AnimalDaoSQLImpl().getById(rs.getInt("animal")));
                histories.add(animalHistory);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return histories;
    }
}
