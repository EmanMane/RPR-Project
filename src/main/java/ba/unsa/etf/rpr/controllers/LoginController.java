package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.HabitatManager;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import ba.unsa.etf.rpr.business.UserManager;
import javafx.stage.StageStyle;
import javafx.stage.Window;
//import jdk.internal.loader.Loader;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController{

    private UserManager manager = new UserManager();
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private Hyperlink registerLink;


    public void loginButtonOnAction(ActionEvent event) throws AnimalException, IOException {
        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
            loginMessageLabel.setText("No input!");
        }
        else if(validateLogin()){
            goToHome();
        }
    }

    public boolean validateLogin() throws AnimalException, IOException {
        loginMessageLabel.setText("Processing...");
        if(manager.validateUser(usernameTextField.getText(),passwordTextField.getText())) {
            loginMessageLabel.setText("Success!");
            return true;
        }
        loginMessageLabel.setText("Invalid login.\nPlease enter Your details again.");
        return false;
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void goToHome() throws IOException {
        try {
            ((Stage) usernameTextField.getScene().getWindow()).close();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            loader.setController(new HomeController());
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            homeStage.initStyle(StageStyle.UTILITY);
            homeStage.setTitle("ZOO HOME");
            homeStage.setMaximized(true); //FULLSCREEN
            homeStage.show();
//            homeStage.setOnHiding(event -> {
//                ((Stage) usernameTextField.getScene().getWindow()).show();
//            });
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

//    private void goToHome(){
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
//            loader.setController(new HomeController());
//            Stage stage = new Stage();
//            stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
//            stage.setTitle("Home");
//            stage.initStyle(StageStyle.UTILITY);
//            stage.show();
//        }catch (Exception e){
//            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
//        }
//    }

    public void registerLinkOnAction() throws IOException{
        try {
            ((Stage) usernameTextField.getScene().getWindow()).hide();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
            loader.setController(new RegisterController());
            Stage regStage = new Stage();
            regStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            regStage.initStyle(StageStyle.UNDECORATED); //Adobe type Login (No resize)
            regStage.setResizable(false);
            regStage.show();
            regStage.setOnHiding(event -> {
                ((Stage) usernameTextField.getScene().getWindow()).show();
            });
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }

//        //homeStage.initStyle(StageStyle.DECORATED);
//        homeStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
//        homeStage.setResizable(true);
//        homeStage.show();
    }



    }
