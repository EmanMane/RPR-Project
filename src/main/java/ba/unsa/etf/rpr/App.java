package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.HabitatManager;
import ba.unsa.etf.rpr.business.AnimalManager;
import ba.unsa.etf.rpr.dao.*;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;


import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;
import java.sql.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 *
 * CLI (Command Line Interface) implementation in following class
 * Even though this type of presentation layer (called CLI) is becoming past tense for GUI apps
 * it's good to see how you can manipulate data through command line and database also
 * @author Eman Alibalić
 */
public class App {
    /**
     * Defining final variables to describe all code having options
     */
    private static final Option addAnimal = new Option("a","add-animal",false, "Adding new animal to zoo database");
    private static final Option addHabitat = new Option("h","add-habitat",false, "Adding new habitat to zoo database");
    private static final Option getAnimals = new Option("getA", "get-animals",false, "Printing all animals from zoo database");
    private static final Option getHabitats = new Option("getH", "get-habitats",false, "Printing all habitats zoo database");
    private static final Option habitatDefinition = new Option(null, "habitat",false, "Defining habitat for next added animal");




    /**
     *
     * @param options
     *
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar RPR-Project.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addAnimal);
        options.addOption(addHabitat);
        options.addOption(getAnimals);
        options.addOption(getHabitats);
        options.addOption(habitatDefinition);
        return options;
    }

    public static Habitat searchThroughHabitats(List<Habitat> listOfHabitats, String habitatName) {

        Habitat habitat = null;
        habitat = listOfHabitats.stream().filter(cat -> cat.getName().toLowerCase().equals(habitatName.toLowerCase())).findAny().get();
        return habitat;

    }


    /**
     *
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Options options = addOptions();

        CommandLineParser commandLineParser = new DefaultParser();

        CommandLine cl = commandLineParser.parse(options, args);

//        while(true) {
        if((cl.hasOption(addAnimal.getOpt()) || cl.hasOption(addAnimal.getLongOpt())) && cl.hasOption((habitatDefinition.getLongOpt()))){
            AnimalManager animalManager = new AnimalManager();
            HabitatManager habitatManager = new HabitatManager();
            Habitat habitat = null;
            try {
                habitat = searchThroughHabitats(habitatManager.getAll(), cl.getArgList().get(1));
            }catch(Exception e) {
                System.out.println("There is no habitat in the list! Try again.");
                System.exit(1);
            }

//                if(!habitat.getName().equals(cl.getArgList().get(1))){
//                    System.out.println("There is no habitat with passed name! Try again.");
//                    System.exit(-1);
//                }
            Animal animal = new Animal();
            animal.setHabitat(habitat);
            animal.setAnimal(cl.getArgList().get(0));
            animalManager.add(animal);
            System.out.println("You successfully added animal to database!");
//                break;
        } else if(cl.hasOption(getAnimals.getOpt()) || cl.hasOption(getAnimals.getLongOpt())){
            AnimalManager animalManager = new AnimalManager();
            animalManager.getAll().forEach(q -> System.out.println(q.getAnimal()));
//                break;
        } else if(cl.hasOption(addHabitat.getOpt()) || cl.hasOption(addHabitat.getLongOpt())){
            try {
                HabitatManager habitatManager = new HabitatManager();
                Habitat cat = new Habitat();
                cat.setName(cl.getArgList().get(0));
                habitatManager.add(cat);
                System.out.println("Habitat has been added successfully");
//                    break;
            }catch(Exception e) {
                System.out.println("There is already habitat with same name in database! Try again");
                System.exit(1);
//                   break;
            }

        } else if(cl.hasOption(getHabitats.getOpt()) || cl.hasOption(getHabitats.getLongOpt())){
            HabitatManager habitatManager = new HabitatManager();
            habitatManager.getAll().forEach(c -> System.out.println(c.getName()));
//                break;
        } else {
            printFormattedOptions(options);
            System.exit(-1);
//                break;
        }
//        }
    }
}