package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class RegisterController implements Initializable {

    private UserManager manager = new UserManager();
    @FXML
    public Button backButton;
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

    DropShadow redShadow = new DropShadow(10, Color.RED);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Remove focus from all controls
        backButton.setFocusTraversable(false);
        registerMessageLabel.setFocusTraversable(false);
        registerButton.setFocusTraversable(false);
        usernameTextField.setFocusTraversable(false);
        passwordTextField1.setFocusTraversable(false);
        passwordTextField2.setFocusTraversable(false);

        // Remove focus from textField after clicking anywhere else
        // Add a listener to the parent node of the text field
        usernameTextField.getParent().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // When the parent node is clicked, remove focus from the text field
                usernameTextField.getParent().requestFocus();
            }
        });


        passwordTextField1.textProperty().addListener((observable, oldValue, newValue) -> {
            // If the password field has between 1 and 7 characters and loses focus, set the dropshadow
            if (passwordTextField1.getLength() > 0 && passwordTextField1.getLength() < 8) {
                passwordTextField1.setEffect(redShadow);
                passwordTextField1.setStyle("-fx-focus-color: transparent;");
                registerMessageLabel.setText("Password needs to have 8\n or more characters!");
            }

            // If the password field has 8 or more characters, remove the dropshadow and set the on-focus color
            if (passwordTextField1.getLength() >= 8 || passwordTextField1.getLength() < 1) {
                passwordTextField1.setEffect(null);
                passwordTextField1.setStyle("-fx-focus-color: #0077be;");
                registerMessageLabel.setText("");
            }
        });

        passwordTextField2.textProperty().addListener((observable, oldValue, newValue) -> {
            // If the password field has between 1 and 7 characters and loses focus, set the dropshadow
            if (passwordTextField2.getLength() > 0 && passwordTextField2.getLength() < 8) {
                passwordTextField2.setEffect(redShadow);
                passwordTextField2.setStyle("-fx-focus-color: transparent;");
                registerMessageLabel.setText("Password needs to have 8\n or more characters!");
            }

            // If the password field has 8 or more characters, remove the dropshadow and set the on-focus color
            if ((passwordTextField2.getLength() >= 8 || passwordTextField2.getLength() < 1)) {
                passwordTextField2.setEffect(null);
                passwordTextField2.setStyle("-fx-focus-color: #0077be;");
                registerMessageLabel.setText("");
            }
        });
    }


    public void registerButtonOnAction(ActionEvent event) throws AnimalException, IOException {
        String pass1=passwordTextField1.getText(),pass2=passwordTextField2.getText(),username=usernameTextField.getText();
        if(username.isEmpty() || pass1.isEmpty() || pass2.isEmpty()){
            registerMessageLabel.setText("Please enter all details!");
        }
        else if(!manager.validateNewUser(username)){
            registerMessageLabel.setText("Username exists!");
        }
        else if(!pass1.equals(pass2)){
            passwordTextField2.setEffect(redShadow);
            passwordTextField2.setStyle("-fx-focus-color: transparent;");
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
