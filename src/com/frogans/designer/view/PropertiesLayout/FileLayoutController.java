package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.FileFSDL;
import com.frogans.designer.model.Elements.TextFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 */
public class FileLayoutController {


    FileFSDL fileFSDL;
    FrogansApp frogansApp;
    @FXML
    private TextField idText;
    @FXML
    private TextField nameText;
    @FXML
    private ChoiceBox<String> natureChoice;
    @FXML
    private ChoiceBox<String> cacheChoice;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fileFSDL = new FileFSDL();
        fillNatureBox();
        fillCacheBox();

    }

    private void fillNatureBox() {
        for (StringProperty stringProperty : fileFSDL.getNatureArray()) {
            natureChoice.getItems().add(stringProperty.get());
        }

    }

    private void fillCacheBox() {
        for (StringProperty stringProperty : fileFSDL.getCacheArray()) {
            cacheChoice.getItems().add(stringProperty.get());
        }
        cacheChoice.setValue(fileFSDL.getCacheArray()[1].get());
    }

    public void fillFileLayout(String fileid,
                               String nature,
                               String name,
                               String cache
    ) {
        idText.setText(fileid);
        natureChoice.setValue(nature);
        nameText.setText(name);
        cacheChoice.setValue(cache);
    }
}
