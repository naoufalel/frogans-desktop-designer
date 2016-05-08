package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.ResdrawFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * Created by Alaeddine on 02/04/2016.
 */
public class ResdrawLayoutController {
    ResdrawFSDL resdrawFSDL = new ResdrawFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField resIdText;
    @FXML
    private TextField sizeXText;
    @FXML
    private TextField sizeYText;
    @FXML
    private ChoiceBox<String> figureChoice;
    @FXML
    private ChoiceBox<String> strokeChoice;
    @FXML
    private Slider thickSlide;
    @FXML
    private TextField roundXText;
    @FXML
    private TextField roundYText;
    @FXML
    private TextField colorText;

    @FXML
    public void initialize(){
        fillStroke();
        fillFigure();
    }
    private void fillStroke() {
        for (StringProperty stringProperty : resdrawFSDL.getStrokeArray()) {
            strokeChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillFigure() {
        for (StringProperty stringProperty : resdrawFSDL.getFigureArray()) {
            figureChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillResdrawLayout(String resid,
                                  String size,
                                  String figure,
                                  String stroke,
                                  String thick,
                                  String round,
                                  String color
    ) {
        resIdText.setText(resid);
        sizeXText.setText(size);
        sizeYText.setText(size);
        figureChoice.setValue(figure);
        strokeChoice.setValue(stroke);
        thickSlide.setValue(Tools.ifStringIsEmpty(thick));
        roundXText.setText(Tools.splitPosition(round).get(0));
        roundYText.setText(Tools.splitPosition(round).get(1));
        colorText.setText(color);
    }

}
