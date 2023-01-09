package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.HabitatManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Habitat;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * JavaFX controller for category management
 *
 * @author Eman Alibalić
 */
public class HabitatController {

    private HabitatManager manager = new HabitatManager();

    // components
    public ListView<Habitat> habitatsList;
    public TextField habitatName;

    @FXML
    public void initialize() {
        try {
            refreshHabitats();
            habitatsList.getSelectionModel().selectedItemProperty().addListener((obs, o, n)->{
                if (n != null){
                    habitatName.setText(n.getName());
                }
            });
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void addHabitat(ActionEvent event){
        try {
            Habitat c = new Habitat();
            c.setName(habitatName.getText());
            c = manager.add(c);
            habitatsList.getItems().add(c);
            habitatName.setText("");
            //refreshCategories();
        }catch (AnimalException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void updateHabitat(ActionEvent event){
        try {
            Habitat cat = habitatsList.getSelectionModel().getSelectedItem();
            cat.setName(habitatName.getText());
            cat = manager.update(cat);
            refreshHabitats();
        }catch (AnimalException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void deleteHabitat(ActionEvent event){
        try {
            Habitat cat = habitatsList.getSelectionModel().getSelectedItem();
            manager.delete(cat.getId());
            //refreshCategories();
            habitatsList.getItems().remove(cat); // perf optimization
        }catch (AnimalException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    private void refreshHabitats() throws AnimalException{
        try {
            habitatsList.setItems(FXCollections.observableList(manager.getAll()));
            habitatName.setText("");
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}