package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * bean for habitat
 * @author Eman Alibalić
 */
public class Habitat implements Idable{

    private int id;
    private String name;

    public Habitat(String name) {
        this.name = name;
    }

    public Habitat() {}
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitat habitat = (Habitat) o;
        return id == habitat.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }
}