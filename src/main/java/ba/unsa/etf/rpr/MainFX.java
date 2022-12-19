package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class MainFX extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/home-layout.fxml"));
        Parent root = null;
        HomeController homeController = new HomeController();
        loader.setController(homeController);
        root = loader.load();
        Scene scene = new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
        stage.setScene(scene);
        stage.show();
    }
}
