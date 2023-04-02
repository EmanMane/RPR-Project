package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.LoginController;
import ba.unsa.etf.rpr.controllers.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;


/**
 * Main class for working with JavaFX framework
 */

public class AppFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // create the login stage and scene
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        LoginController loginController = new LoginController();
        loginLoader.setController(loginController);
        Parent loginRoot = loginLoader.load();
        Stage loginStage = new Stage();
        loginStage.initStyle(StageStyle.UNDECORATED);
        loginStage.setScene(new Scene(loginRoot));
        loginStage.setResizable(false);

        // create the register stage and scene
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        RegisterController registerController = new RegisterController();
        registerLoader.setController(registerController);
        Parent registerRoot = registerLoader.load();
        Stage registerStage = new Stage();
        registerStage.initStyle(StageStyle.UNDECORATED);
        registerStage.setScene(new Scene(registerRoot));
        registerStage.setResizable(false);

        // set the preferred size of the icon in the taskbar
        Image icon = new Image("/zoomanager/zoomanager_icon_taskbar.png");
        loginStage.getIcons().add(icon);
        registerStage.getIcons().add(icon);

        // add event handlers to switch between stages
        loginController.registerLink.setOnAction(event -> {
            registerStage.show();
            loginStage.hide();
        });

        registerController.backButton.setOnAction(event -> {
            loginStage.show();
            registerStage.hide();
        });

        // show the login stage
        loginStage.show();
    }
}

