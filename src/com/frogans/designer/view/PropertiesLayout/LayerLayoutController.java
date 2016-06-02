package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.LayerFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 */
public class LayerLayoutController {

    LayerFSDL layerFSDL = new LayerFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField idText;
    @FXML
    private ChoiceBox<String> leapoutChoice;
    @FXML
    private TextField resrefText;
    @FXML
    private ChoiceBox<String> flipChoice;
    @FXML
    private TextField filterrefText;
    @FXML
    private TextField reliefrefText;
    @FXML
    private Slider blurSlide;
    @FXML
    private Label blurLabel;
    @FXML
    private Slider opacitySlide;
    @FXML
    private Label opacityLabel;
    @FXML
    private Slider angleSlide;
    @FXML
    private Label angleLabel;
    @FXML
    private TextField posXText;
    @FXML
    private TextField posYText;
    @FXML
    private ChoiceBox<String> alignChoice;
    @FXML
    private ChoiceBox<String> combineChoice;
    @FXML
    private TextField shadowrefText;
    @FXML
    private ChoiceBox<String> visibleChoice;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillLeapout();
        fillFlip();
        fillAlign();
        fillCombine();
        fillVisible();
    }


    private void fillLeapout() {
        for (StringProperty stringProperty : layerFSDL.getLeapoutArray()) {
            leapoutChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillFlip() {
        for (StringProperty stringProperty : layerFSDL.getFlipArray()) {
            flipChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillAlign() {
        for (StringProperty stringProperty : layerFSDL.getAlignArray()) {
            alignChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillCombine() {
        for (StringProperty stringProperty : layerFSDL.getCombineArray()) {
            combineChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillVisible() {
        for (StringProperty stringProperty : layerFSDL.getVisibleArray()) {
            visibleChoice.getItems().add(stringProperty.get());
        }
    }


    public void fillLayerLayout(String layerID,
                                String leapOut,
                                String resref,
                                String flip,
                                String filterRef,
                                String reliefRef,
                                String blur,
                                String opacity,
                                String angle,
                                String position,
                                String align,
                                String combine,
                                String shadowRef,
                                String visible
    ) {
        idText.setText(layerID);
        leapoutChoice.setValue(leapOut);
        resrefText.setText(resref);
        flipChoice.setValue(flip);
        filterrefText.setText(filterRef);
        reliefrefText.setText(reliefRef);

        blurSlide.setValue(Tools.ifStringIsEmpty(blur));
        blurLabel.setText(blur);
        opacitySlide.setValue(Tools.ifStringIsEmpty(opacity));
        opacityLabel.setText(opacity);
        angleSlide.setValue(Tools.ifStringIsEmpty(angle));
        angleLabel.setText(angle);


        posXText.setText(Tools.splitPosition(position).get(0));
        posYText.setText(Tools.splitPosition(position).get(1));
        alignChoice.setValue(align);
        combineChoice.setValue(combine);
        shadowrefText.setText(shadowRef);
        visibleChoice.setValue(visible);

    }
}
