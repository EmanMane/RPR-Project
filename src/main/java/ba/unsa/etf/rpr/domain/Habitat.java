package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * List of possible categories for habitat
 * @author Eman Alibalić
 */
public class Habitat {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitat category = (Habitat) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}