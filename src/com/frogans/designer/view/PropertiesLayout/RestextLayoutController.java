package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.RestextFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 11-May-16.
 */
public class RestextLayoutController {
    RestextFSDL restextFSDL = new RestextFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField residText;
    @FXML
    private TextField sizeWText;
    @FXML
    private TextField sizeHText;
    @FXML
    private ChoiceBox<String> orientationChoice;
    @FXML
    private TextField fontrefText;
    @FXML
    private ChoiceBox<String> talignChoice;
    @FXML
    private TextField linespaceText;
    @FXML
    private ChoiceBox<String> vstyleChoice;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillOrientation();
        fillTalign();
        fillVstyle();

    }


    private void fillOrientation() {
        for (StringProperty stringProperty : restextFSDL.getOrientationArray()) {
            orientationChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillTalign() {
        for (StringProperty stringProperty : restextFSDL.getTalignArray()) {
            talignChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillVstyle() {
        for (StringProperty stringProperty : restextFSDL.getVstyleArray()) {
            vstyleChoice.getItems().add(stringProperty.get());
        }
    }
    public void fillRestextLayout(String resid,
                                  String size,
                                  String fontref,
                                  String talign,
                                  String linespace,
                                  String vstyle,
                                  String orientation)
    {
        residText.setText(resid);
        sizeWText.setText(Tools.splitPosition(size).get(0));
        sizeHText.setText(Tools.splitPosition(size).get(1));
        fontrefText.setText(fontref);
        talignChoice.setValue(talign);
        linespaceText.setText(linespace);
        vstyleChoice.setValue(vstyle);
        orientationChoice.setValue(orientation);
    }

}
