package ba.unsa.etf.rpr.dao;
import ba.unsa.etf.rpr.domain.AnimalHistory;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalHistoryDaoSQLImpl implements AnimalHistoryDao{
    private Connection conn;

    public AnimalHistoryDaoSQLImpl(){
        try {
            this.conn= DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7582258", "sql7582258", "m6JTHrdhjw");
        } catch (SQLException e) {
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public AnimalHistory getById(int id){
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM habitats WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                AnimalHistory quoteHistory = new AnimalHistory();
                quoteHistory.setId(rs.getInt("id"));
                quoteHistory.setAnimal(new AnimalDaoSQLImpl().getById(rs.getInt("animal"))); //ovo samo kad se doda implementacija i toga ce raditi....
                rs.close();
                return quoteHistory;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return null;
    }

    private int getMaxId(){
        int id=1;
        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT MAX(id)+1 FROM animal_history");
            ResultSet rs = statement.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
                rs.close();
                return id;
            }
        } catch (SQLException e) {
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return id;
    }

    @Override
    public AnimalHistory add(AnimalHistory item){
        int id = getMaxId();
        try {
            PreparedStatement stmt = this.conn.prepareStatement("INSERT INTO animal_history VALUES (id, item.getAnimal().getId(), item.getGenerated())");
            stmt.executeUpdate();
            item.setId(id);
            return item;
        } catch (SQLException e) {
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public AnimalHistory update(AnimalHistory item){
        try{
            PreparedStatement stmt = this.conn.prepareStatement("UPDATE animal_history SET quote=?, generated=? WHERE id=?");
            stmt.setInt(1, item.getAnimal().getId());
            stmt.setDate(2, (java.sql.Date) item.getGenerated());
            stmt.setInt(3, item.getId());
            stmt.executeUpdate();
            return item;
        }catch (SQLException e){
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(int id){
        try{
            PreparedStatement stmt = this.conn.prepareStatement("DELETE FROM animal_history WHERE id = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<AnimalHistory> getAll(){
        List<AnimalHistory> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal_history");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                AnimalHistory animalHistory = new AnimalHistory();
                animalHistory.setId(rs.getInt("id"));
                animalHistory.setAnimal(new AnimalDaoSQLImpl().getById(rs.getInt("animal")));
                histories.add(animalHistory);
            }
            rs.close();
        }catch (SQLException e){
            System.out.println("Error in database");
            System.out.println(e.getMessage());
        }
        return histories;
    }

    @Override
    public List<AnimalHistory> getByDateRange(Date start, Date end){
        List<AnimalHistory> histories = new ArrayList<>();
        try{
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM animal_history WHERE generated BETWEEN start AND end");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                AnimalHistory animalHistory = new AnimalHistory();
                animalHistory.setId(rs.getInt("id"));
                animalHistory.setAnimal(new AnimalDaoSQLImpl().getById(rs.getInt("animal")));
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
