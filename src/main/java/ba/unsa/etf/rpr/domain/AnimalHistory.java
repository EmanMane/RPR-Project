package ba.unsa.etf.rpr.domain;
import java.util.Date;
import java.util.Objects;

/**
 * Holds history of all generated animals
 * @author Eman Alibalić
 */
public class AnimalHistory {
    private int id;
    private Animal animal;
    private Date generated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getGenerated() {
        return generated;
    }

    public void setGenerated(Date generated) {
        this.generated = generated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalHistory that = (AnimalHistory) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, generated);
    }
}