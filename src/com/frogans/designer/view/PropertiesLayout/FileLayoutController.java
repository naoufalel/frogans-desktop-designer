package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.FileFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 * Created by Naoufal EL BANTLI on 3/30/2016.
 */
public class FileLayoutController {

    FileFSDL fileFSDL;
    FrogansApp frogansApp;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    private ChoiceBox<String> natureChoice;
    @FXML
    private ChoiceBox<String> cacheChoice;

    @FXML
    public void initialize(){
        fileFSDL = new FileFSDL();
        fillNatureBox();
        fillCacheBox();

    }

    private void fillNatureBox(){
        for (StringProperty stringProperty : fileFSDL.getNatureArray()) {
            natureChoice.getItems().add(stringProperty.get());
        }

    }

    private void fillCacheBox(){
        for (StringProperty stringProperty : fileFSDL.getCacheArray()) {
            cacheChoice.getItems().add(stringProperty.get());
        }
        cacheChoice.setValue(fileFSDL.getCacheArray()[1].get());
    }
}
