package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.HomeController;
import ba.unsa.etf.rpr.controllers.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Main class for working with JavaFX framework
 */

public class AppFX extends Application {
    /**
     * start method is used to literally start the App
     * with the first scene being composed through login.fxml
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED); //Adobe type Login (No resize)
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}