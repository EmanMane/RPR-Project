package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AnimalManager;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {

    public Label quoteLabel;

    private AnimalManager manager = new AnimalManager();

    @FXML
    public void initialize() {
        try {
            Animal q = manager.randomAnimal();
            quoteLabel.setText(q.getAnimal());
        } catch (AnimalException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void closeApp(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }
    public void openAbout(ActionEvent actionEvent){
        openDialog("About", "/fxml/about.fxml", null);
    }

    public void openEditHabitats(ActionEvent event){
        openDialog("Manage Habitats", "/fxml/habitat.fxml", new HabitatController());
    }

    public void openEditAnimals(ActionEvent event){
        openDialog("Manage Animals", "/fxml/animal.fxml", new AnimalController());
    }

    private void openDialog(String title, String file, Object controller){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            loader.setController(controller);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle(title);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}