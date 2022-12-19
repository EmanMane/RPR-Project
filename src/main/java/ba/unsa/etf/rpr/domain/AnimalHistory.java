package ba.unsa.etf.rpr.domain;
import java.util.Date;
import java.util.Objects;

/**
 * Holds history of all animals that died or left the zoo
 * @author Eman Alibalić
 */
public class AnimalHistory implements Idable{

    private int id;
    private String animal;
    private Habitat habitat;
    private Date dateLeft;

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

    public Date getDateLeft() {
        return dateLeft;
    }

    public void setDateLeft(Date date) {
        this.dateLeft = date;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", habitat=" + habitat +
                ", date left=" + dateLeft +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalHistory animalHistory = (AnimalHistory) o;
        return id == animalHistory.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, animal, habitat, dateLeft);
    }
}