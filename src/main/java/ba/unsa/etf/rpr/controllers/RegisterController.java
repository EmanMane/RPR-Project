package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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


    public void registerButtonOnAction(ActionEvent event) throws AnimalException, IOException {
        String pass1=passwordTextField1.getText(),pass2=passwordTextField2.getText(),username=usernameTextField.getText();
        if(username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            registerMessageLabel.setText("Please enter all details!");
        }
        else if(!manager.validateNewUser(username)){
            registerMessageLabel.setText("Username exists!");
        }
        else if(!pass1.equals(pass2)){
            registerMessageLabel.setText("Passwords are different!");
        }
        else{
            User x=new User();
            x.setUsername(username);
            x.setPassword(pass1);
            x.setAdmin(0);
            manager.add(x);
            Stage registrationStage= (Stage) passwordTextField1.getScene().getWindow();
            registrationStage.close();
        }
    }

    public void backButtonOnAction(ActionEvent event){
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    }
