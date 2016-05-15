package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.RespathFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 08-May-16.
 */
public class RespathLayoutController {

    RespathFSDL respathFSDL = new RespathFSDL();

    private FrogansApp frogansApp;
    @FXML
    private TextField residText;
    @FXML
    private TextField sizeWText;
    @FXML
    private TextField sizeHText;
    @FXML
    private ChoiceBox<String> cropChoice;
    @FXML
    private TextField cornerXTLText;
    @FXML
    private TextField cornerXBRText;
    @FXML
    private TextField cornerYTLText;
    @FXML
    private TextField cornerYBRText;
    @FXML
    private ChoiceBox<String> strokeChoice;
    @FXML
    private TextField thickText;
    @FXML
    private ChoiceBox<String> closeChoice;
    @FXML
    private ChoiceBox<String> fillChoice;
    @FXML
    private ChoiceBox<String> spreadChoice;
    @FXML
    private TextField adjustText;
    @FXML
    private TextField colorText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillCrop();
        fillStroke();
        fillClose();
        fillFill();
        fillSpread();
    }

    private void fillFill() {
        for (StringProperty stringProperty : respathFSDL.getFillArray()) {
            fillChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillCrop() {
        for (StringProperty stringProperty : respathFSDL.getCropArray()) {
            cropChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillStroke() {
        for (StringProperty stringProperty : respathFSDL.getStrokeArray()) {
            strokeChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillClose() {
        for (StringProperty stringProperty : respathFSDL.getCloseArray()) {
            closeChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillSpread() {
        for (StringProperty stringProperty : respathFSDL.getSpreadArray()) {
            spreadChoice.getItems().add(stringProperty.get());
        }
    }


    public void fillRespathLayout(String resid,
                                String size,
                                String crop,
                                String corners,
                                String stroke,
                                String thick,
                                String close,
                                String fill,
                                String color,
                                String spread
    ) {
        residText.setText(resid);
        sizeHText.setText(Tools.splitPosition(size).get(1));
        sizeWText.setText(Tools.splitPosition(size).get(0));
        cropChoice.setValue(crop);
        cornerXTLText.setText(Tools.splitPosition(corners).get(0));
        cornerYTLText.setText(Tools.splitPosition(corners).get(1));
        cornerXBRText.setText(Tools.splitPosition(corners).get(2));
        cornerYBRText.setText(Tools.splitPosition(corners).get(3));
        strokeChoice.setValue(stroke);
        thickText.setText(thick);
        closeChoice.setValue(close);
        fillChoice.setValue(fill);
        colorText.setText(color);
        spreadChoice.setValue(spread);

    }
}
