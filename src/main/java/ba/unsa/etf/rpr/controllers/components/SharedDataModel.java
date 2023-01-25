package ba.unsa.etf.rpr.controllers.components;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;

/**
 * Class to control and close all stages when necessary
 */
public class SharedDataModel {
    private static List<Stage> openStages = new ArrayList<>();

    public static void addOpenStage(Stage stage) {
        openStages.add(stage);
    }

    public static void removeOpenStage(Stage stage) {
        openStages.remove(stage);
    }

    public static void closeAllStages() {
        for (Stage stage : openStages) {
            stage.close();
        }
    }
}