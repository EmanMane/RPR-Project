package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.HabitatManager;
import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import ba.unsa.etf.rpr.business.UserManager;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController{

    private UserManager manager = new UserManager();
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;


    public void loginButtonOnAction(ActionEvent event) throws AnimalException, IOException {
        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
            loginMessageLabel.setText("No input!");
        }
        else {
            validateLogin();
        }
    }

    public void  validateLogin() throws AnimalException, IOException {
        loginMessageLabel.setText("Processing...");
        if(manager.validateUser(usernameTextField.getText(),passwordTextField.getText())) {
            loginMessageLabel.setText("Success!");
            goToHome();
        }
        else loginMessageLabel.setText("Invalid login. Please enter Your details again.");
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void goToHome() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        Stage homeStage = new Stage();
        homeStage.initStyle(StageStyle.UNDECORATED); //Adobe type Login (No resize)
        homeStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        homeStage.show();
    }
}
