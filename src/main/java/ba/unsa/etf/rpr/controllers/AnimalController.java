package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AnimalManager;
import ba.unsa.etf.rpr.controllers.components.DoubleButtonCellFactory;
import ba.unsa.etf.rpr.controllers.components.SharedDataModel;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Date;
import java.util.Optional;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Controller for managing Animals Entity
 * @author Eman Alibalić
 */
public class AnimalController {
    // managers
    private final AnimalManager animalManager = new AnimalManager();

    // helper components
    @FXML
    public BorderPane animalScreen;

    // components
    public TableView animalsTable;
    public TextField search;

    public TableColumn<Animal, String> idColumn;
    public TableColumn<Animal, String> animalColumn;
    public TableColumn<Animal, Date> habitatColumn;
    public TableColumn<Animal, Integer> actionColumn;

    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<Animal, String>("id"));
        animalColumn.setCellValueFactory(new PropertyValueFactory<Animal, String>("animal"));
        habitatColumn.setCellValueFactory(new PropertyValueFactory<Animal, Date>("habitat"));
        actionColumn.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("id"));

        actionColumn.setCellFactory(new DoubleButtonCellFactory(editEvent -> {
            int animalId = Integer.parseInt(((Button)editEvent.getSource()).getUserData().toString());
            editAnimalScene(animalId);
        }, (deleteEvent -> {
            int animalId = Integer.parseInt(((Button)deleteEvent.getSource()).getUserData().toString());
            deleteAnimal(animalId);
        })));

        refreshAnimals();
    }

    /**
     * search animal event handler
     * @param event
     */
    public void searchAnimals(ActionEvent event){
        try {
            animalsTable.setItems(FXCollections.observableList(animalManager.searchAnimals(search.getText())));
            animalsTable.refresh();
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    /**
     * Event handler for deletion of animal. It has "confirm" box before deletion
     * @param animalId
     */
    public void deleteAnimal(Integer animalId){
        try {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete");
            Optional<ButtonType> result = confirmation.showAndWait();
            if (!result.get().getButtonData().isCancelButton()){
                animalManager.delete(animalId);
                refreshAnimals();
            }
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    /**
     * Open form for editing or creating animal
     *
     * @param animalId - only for edit if we know which animal is being edited.
     */
    public void editAnimalScene(Integer animalId){
        try{
            ((Stage)animalsTable.getScene().getWindow()).hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/aoeanimal.fxml"));
            loader.setController(new AoUAnimalController(animalId));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.initStyle(StageStyle.UTILITY);
            stage.setTitle("Edit Animal");
            stage.setResizable(false);
            stage.show();
            SharedDataModel.addOpenStage(stage);
            stage.setOnHiding(event -> {
                ((Stage)animalScreen.getScene().getWindow()).show();
                refreshAnimals();
            });
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }


    /**
     * Event handler for creation of animal
     * @param event
     */
    public void addAnimal(ActionEvent event){
        editAnimalScene(null);
    }

    /**
     * fetch animals from DB
     */
    private void refreshAnimals(){
        try {
            animalsTable.setItems(FXCollections.observableList(animalManager.getAll()));
            animalsTable.refresh();
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}
