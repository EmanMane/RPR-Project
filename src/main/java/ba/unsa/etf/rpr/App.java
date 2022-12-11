package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.HabitatDao;
import ba.unsa.etf.rpr.dao.HabitatDaoSQLImpl;
import ba.unsa.etf.rpr.dao.AnimalDao;
import ba.unsa.etf.rpr.dao.AnimalDaoSQLImpl;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * App interface demo
 * @author Eman Alibalić
 * @version 0.0.1
 */
public class App {
    public static void main(String[] args) {
//    {
//        CategoryDao dao = new CategoryDaoSQLImpl();
//
//
//        List<Category> categories = dao.getAll();
//        System.out.println(categories);
//
//        Category c2 = new Category();
//        c2.setId(2);
//        c2.setName("Courage");
//        dao.delete(2);
//        categories = dao.getAll();
//        System.out.println(categories);
//    }

        AnimalDao dao = new AnimalDaoSQLImpl() ;

        Habitat habitat = new Habitat();
        habitat.setId(2);
        habitat.setName("Zivotinje");
        ArrayList<Animal> animalsByHabitats = new ArrayList<Animal>(dao.searchByHabitat(habitat));
        System.out.println("Treba ispisati 2 zivotinje u ovom habitatu: ");
        animalsByHabitats.forEach(q -> System.out.println(q.getAnimal()));


        System.out.println("\n Jedan quote sa inside word \"gora\": ");
        ArrayList<Animal> animals = new ArrayList<Animal>(dao.searchByType("Lion"));
        for (Animal q : animals) {
            System.out.println(q.getAnimal());
        }
    }
}