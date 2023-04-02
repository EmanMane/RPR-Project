package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.controllers.components.SharedDataModel;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import ba.unsa.etf.rpr.exceptions.AnimalException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import ba.unsa.etf.rpr.business.UserManager;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController implements Initializable {
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
    public Hyperlink registerLink;
    @FXML
    private BorderPane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Remove focus from all controls
        cancelButton.setFocusTraversable(false);
        loginMessageLabel.setFocusTraversable(false);
        loginButton.setFocusTraversable(false);
        usernameTextField.setFocusTraversable(false);
        passwordTextField.setFocusTraversable(false);
        registerLink.setFocusTraversable(false);

        // Remove focus from textField after clicking anywhere else
        // Add a listener to the parent node of the text field
        usernameTextField.getParent().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // When the parent node is clicked, remove focus from the text field
                usernameTextField.getParent().requestFocus();
            }
        });

        // Add a listener to the password field to set the dropshadow color
        DropShadow redShadow = new DropShadow(10, Color.RED);

        passwordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            // If the password field has between 1 and 7 characters and loses focus, set the dropshadow
            if (passwordTextField.getLength() > 0 && passwordTextField.getLength() < 8) {
                passwordTextField.setEffect(redShadow);
                passwordTextField.setStyle("-fx-focus-color: transparent;");
                loginMessageLabel.setText("Password needs to have 8\n or more characters!");
            }

            // If the password field has 8 or more characters, remove the dropshadow and set the on-focus color
            if (passwordTextField.getLength() >= 8 || passwordTextField.getLength() < 1) {
                passwordTextField.setEffect(null);
                passwordTextField.setStyle("-fx-focus-color: #0077be;");
                loginMessageLabel.setText("");
            }
        });
    }


    public void loginButtonOnAction(ActionEvent event) throws AnimalException, IOException {
        if(usernameTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
            loginMessageLabel.setText("No input!");
        }
        else if(validateLogin()){
            goToHome();
        }
    }

    public boolean validateLogin() throws AnimalException, IOException {
        if(manager.validateUser(usernameTextField.getText(),passwordTextField.getText())) {
            return true;
        }
        if(Objects.equals(loginMessageLabel.getText(), "")) loginMessageLabel.setText("Invalid login!\nPlease enter Your details again!");
        return false;
    }

    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void goToHome() throws IOException {
        try {
            ((Stage) usernameTextField.getScene().getWindow()).hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            fxmlLoader.setController(new HomeController());
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/jpeg/SanDiegoZooLogoIcon.png"));
            stage.setTitle("ZOO HOME");
            stage.setMinHeight(400);
            stage.setMinWidth(629);
            stage.setMaximized(true); //FULLSCREEN
            Parent root = fxmlLoader.load();
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.show();
            stage.setOnCloseRequest(event -> {
                SharedDataModel.closeAllStages();
            });
        } catch (Exception e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

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
    }
}
