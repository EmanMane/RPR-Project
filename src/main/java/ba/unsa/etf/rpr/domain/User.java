package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * bean for user
 * @author Eman Alibalić
 */
public class User implements Idable{

    private int id;
    private String username;
    private String password;
    private int admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User u = (User) o;
        return id == u.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,username,password,admin);
    }
}