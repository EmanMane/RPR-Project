package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class RegisterController {

    private UserManager manager = new UserManager();
    @FXML
    private Button backButton;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private Button registerButton;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField1;
    @FXML
    private PasswordField passwordTextField2;


//    public void loginButtonOnAction(ActionEvent event) throws AnimalException, IOException {
//        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
//            loginMessageLabel.setText("No input!");
//        }
//        else {
//            validateLogin();
//        }
//    }
//
//    public void  validateLogin() throws AnimalException, IOException {
//        loginMessageLabel.setText("Processing...");
//        if(manager.validateUser(usernameTextField.getText(),passwordTextField.getText())) {
//            loginMessageLabel.setText("Success!");
//            goToHome();
//        }
//        else loginMessageLabel.setText("Invalid login.\nPlease enter Your details again.");
//    }
//
//    public void cancelButtonOnAction(ActionEvent event){
//        Stage stage = (Stage) cancelButton.getScene().getWindow();
//        stage.close();
//    }
//
//    public void goToHome() throws IOException {
//        try{
//        ((Stage)usernameTextField.getScene().getWindow()).hide();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
//        loader.setController(new HomeController());
//        Stage homeStage = new Stage();
//        homeStage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
//        homeStage.initStyle(StageStyle.UTILITY);
//        homeStage.setTitle("Edit Quote");
//        homeStage.show();
//        homeStage.setOnHiding(event -> {
//            ((Stage)usernameTextField.getScene().getWindow()).show();
//        });
//        }catch (Exception e){
//        new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
//    }
//
//    }
//


    }
