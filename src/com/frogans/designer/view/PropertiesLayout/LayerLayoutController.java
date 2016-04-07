package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.LayerFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by naouf on 3/28/2016.
 */
public class LayerLayoutController {

 private FrogansApp frogansApp;
    LayerFSDL layerFSDL = new LayerFSDL();

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }


    @FXML
    private TextField idText;

    @FXML
    private ChoiceBox<String> leapoutChoice;









    @FXML
    public void initialize(){
        fillLeapout();

    }

    public TextField getIdText() {
        return idText;
    }

    public ChoiceBox<String> getLeapoutChoice() {
        return leapoutChoice;
    }

    private void fillLeapout(){
        for (StringProperty stringProperty : layerFSDL.getLeapoutArray()) {
            leapoutChoice.getItems().add(stringProperty.get());
        }
    }
}
