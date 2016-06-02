package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.ShadowFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 */
public class ShadowLayoutController {

    ShadowFSDL shadowFSDL=new ShadowFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField rposXText;
    @FXML
    private TextField rposYText;
    @FXML
    private TextField colorText;
    @FXML
    private TextField blurText;
    @FXML
    private TextField opacityText;
    @FXML
    private ChoiceBox<String> combineChoice;
    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {

        fillCombine();

    }


    private void fillCombine() {
        for (StringProperty stringProperty : shadowFSDL.getCombineArray()) {
            combineChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillShadowLayout(String rpos,
                                String color,
                                String blur,
                                String opacity,
                                String combine
    ) {
        rposXText.setText(Tools.splitPosition(rpos).get(0));
        rposYText.setText(Tools.splitPosition(rpos).get(1));
        colorText.setText(color);
        blurText.setText(blur);
        opacityText.setText(opacity);
        combineChoice.setValue(combine);
    }

}
