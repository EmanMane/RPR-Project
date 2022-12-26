package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.util.ResourceBundle;

public class LoginController{

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;


    public void loginButtonOnAction(ActionEvent event){
        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
            loginMessageLabel.setText("Invalid login. Please enter Your details again.");
        }
        else{
            loginMessageLabel.setText("Processing...");
        }
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
