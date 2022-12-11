package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.Habitat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HabitatDaoSQLImpl implements HabitatDao{

    private Connection connection=null;

    public HabitatDaoSQLImpl(){
        String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7583250";
        String user = "sql7583250";
        String password = "hpqdZqhxta";
        try {
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public Habitat getById(int id) {
        String query = "SELECT * FROM habitats WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){ // result set is iterator.
                Habitat habitat = new Habitat();
                habitat.setId(rs.getInt("id"));
                habitat.setName(rs.getString("name"));
                rs.close();
                return habitat;
            }else{
                System.out.println("No habitat with given id...");
                return null; // if there is no elements in the result set return null
            }
        }catch (SQLException e){
            e.printStackTrace(); // poor error handling
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
        return null;
    }

    @Override
    public Habitat add(Habitat item) {
        String insert = "INSERT INTO habitats(id,name) VALUES(?,?)";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, String.valueOf(item.getId()));
            stmt.setString(2, item.getName());
            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            if(rs.next()){ //checking whether our result set has any data or row in it. IMPORTANT!!!
                item.setId(rs.getInt(1)); //set id to return it back
                item.setName(rs.getString(2));
                rs.close();
                return item;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
        return null;
    }

    @Override
    public Habitat update(Habitat item) {
        String insert = "UPDATE habitats SET name = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try{
            stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, item.getName());
            stmt.setObject(2, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String insert = "DELETE FROM habitats WHERE id = ?";
        PreparedStatement stmt = null;
        try{
            stmt = this.connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setObject(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
    }

    @Override
    public List<Habitat> getAll() {
        String query = "SELECT * FROM habitats";
        List<Habitat> habitats = new ArrayList<>();
        PreparedStatement stmt = null;
        try{
            stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){ // result set is iterator.
                Habitat habitat = new Habitat();
                habitat.setId(rs.getInt("id"));
                habitat.setName(rs.getString("name"));
                habitats.add(habitat);
            }
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
        return habitats;
    }

}