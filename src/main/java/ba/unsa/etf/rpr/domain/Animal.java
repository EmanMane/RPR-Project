package ba.unsa.etf.rpr.domain;
import java.util.Date;
import java.util.Objects;

/**
 * bean for animal
 * @author Eman Alibalić
 */
public class Animal {

    private int id;
    private String animal;
    private Habitat habitat;
    private Date created;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", habitat=" + habitat +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, habitat, created);
    }
}