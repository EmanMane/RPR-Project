package ba.unsa.etf.rpr.controllers.components;

import java.util.ArrayList;
import java.util.List;
import javafx.stage.Stage;


public class SharedDataModel {
    private List<Stage> openStages = new ArrayList<>();

    public void addOpenStage(Stage stage) {
        openStages.add(stage);
    }

    public void removeOpenStage(Stage stage) {
        openStages.remove(stage);
    }

    public void closeAllStages() {
        for (Stage stage : openStages) {
            stage.close();
        }
    }
}