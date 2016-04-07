package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.MergeFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * Created by ABDELKABIR on 31/03/2016.
 */
public class MergeLayoutController {

    MergeFSDL mergeFSDL = new MergeFSDL();
    private FrogansApp frogansApp;

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


    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }


    @FXML
    public void initialize(){
        fillFlip();
        fillAlign();
        fillCombine();

    }

    private void fillFlip() {
        for (StringProperty stringProperty : mergeFSDL.getFlipArray()) {
            flipChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillAlign() {
        for (StringProperty stringProperty : mergeFSDL.getAlignArray()) {
            alignChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillCombine() {
        for (StringProperty stringProperty : mergeFSDL.getAlignArray()) {
            combineChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillMergeLayout(String resref,
                           String flip,
                           String filterref,
                           String reliefref,
                           String blur,
                           String opacity,
                           String angle,
                           String position,
                           String align,
                           String combine,
                           String shadowref
    ){
        resrefText.setText(resref);
        flipChoice.setValue(flip);
        reliefrefText.setText(reliefref);
        blurSlide.adjustValue(Tools.ifStringIsEmpty(blur));
        blurLabel.setText(blur);
        opacitySlide.adjustValue(Tools.ifStringIsEmpty(opacity));
        opacityLabel.setText(opacity);
        angleSlide.adjustValue(Tools.ifStringIsEmpty(angle));
        angleLabel.setText(angle);
        posXText.setText(Tools.splitPosition(position).get(0));
        posYText.setText(Tools.splitPosition(position).get(1));
        alignChoice.setValue(align);
        combineChoice.setValue(combine);
        shadowrefText.setText(shadowref);

    }
}
