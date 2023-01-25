package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.AnimalManager;
import ba.unsa.etf.rpr.domain.Animal;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class HomeController {

    @FXML
    public BorderPane BP;

    private AnimalManager manager = new AnimalManager();

    public void closeApp(ActionEvent actionEvent){
        Platform.exit();
        System.exit(0);
    }

    public void signOutApp(ActionEvent actionEvent){
        try {
            ((Stage) BP.getScene().getWindow()).hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
            LoginController loginController = new LoginController();
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/jpeg/SanDiegoZooLogo.png"));
            fxmlLoader.setController(loginController);
            Parent root = fxmlLoader.load();
            stage.initStyle(StageStyle.UNDECORATED); //Adobe type Login (No resize)
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    public void openAbout(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/about.fxml"));
            loader.setController(null);
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setTitle("About");
            stage.setResizable(false);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
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
            stage.setMinHeight(600);
            stage.setMinWidth(610);
        }catch (Exception e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }
}