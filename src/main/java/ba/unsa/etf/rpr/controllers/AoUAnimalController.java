package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.HabitatManager;
import ba.unsa.etf.rpr.business.AnimalManager;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.sql.Date;
import java.time.LocalDate;

/**
 * JavaFX controller for creation and alteration of Animal object
 *
 * @author Eman Alibalić
 */
public class AoUAnimalController {
    // helper components
    @FXML
    public GridPane aouAnimalPane;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;

    // managers
    private final HabitatManager habitatManager = new HabitatManager();
    private final AnimalManager animalManager = new AnimalManager();

    // model
    private AnimalModel model = new AnimalModel();

    // id of animal that is edited
    private Integer editAnimalId;

    // form fields
    public TextArea animal;
    public ComboBox<Habitat> habitatId;

    public AoUAnimalController(Integer editAnimalId){
        this.editAnimalId = editAnimalId;
    }

    public void initialize(){
        try{
            habitatId.setItems(FXCollections.observableList(habitatManager.getAll()));
            animal.textProperty().bindBidirectional(model.animal);
            habitatId.valueProperty().bindBidirectional(model.habitat);
            if (editAnimalId != null) {
                model.fromAnimal(animalManager.getById(editAnimalId));
            }
        }catch (AnimalException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    /**
     * cancel button event handler
     * @param event
     */
    public void cancelAoUForm(ActionEvent event){
        cancelButton.getScene().getWindow().hide();
    }

    /**
     * save button event handler (update and add animal)
     * @param event
     */
    public void saveAoUForm(ActionEvent event){
        try{
            Animal q = model.toAnimal();
            if (editAnimalId != null){
                q.setId(editAnimalId);
                animalManager.update(q);
            }else{
                q.setId(animalManager.findFirstFreeID());
                animalManager.add(q);
            }
            cancelButton.getScene().getWindow().hide();
        }catch (AnimalException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


    /**
     * Helper Model class that supports 2 way data binding with form for Animal management
     * @author Eman Alibalić
     *
     */
    public class AnimalModel{
        public SimpleStringProperty animal = new SimpleStringProperty("");
        public SimpleObjectProperty<Habitat> habitat = new SimpleObjectProperty<Habitat>();

        public void fromAnimal(Animal q){
            this.animal.set(q.getAnimal());
            this.habitat.set(q.getHabitat());
        }

        public Animal toAnimal(){
            Animal a = new Animal();
            a.setAnimal(this.animal.getValue());
            a.setHabitat(this.habitat.getValue());
            return a;
        }
    }
}