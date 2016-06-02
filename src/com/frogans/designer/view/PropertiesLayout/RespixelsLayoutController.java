package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.RespixelsFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 *
 */
public class RespixelsLayoutController {

    RespixelsFSDL respixelsFSDL = new RespixelsFSDL();

    private FrogansApp frogansApp;

    @FXML
    private TextField residText;
    @FXML
    private TextField sizeWText;
    @FXML
    private TextField sizeHText;
    @FXML
    private Slider columnsSlide;
    @FXML
    private Slider rowsSlide;
    @FXML
    private ChoiceBox<String> pixChoice;
    @FXML
    private TextField colorText;
    @FXML
    private TextField alphaText;
    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }


    @FXML
    public void initialize(){
        fillPix();
    }
    private void fillPix() {
        for (StringProperty stringProperty : respixelsFSDL.getPixArray()) {
            pixChoice.getItems().add(stringProperty.get());
        }
    }
    public void fillRespixelsLayout(String resid,
                                    String size,
                                    String columns,
                                    String rows,
                                    String pix,
                                    String color,
                                    String alpha
    ) {
        residText.setText(resid);
        sizeWText.setText(Tools.splitPosition(size).get(0));
        sizeHText.setText(Tools.splitPosition(size).get(1));
        columnsSlide.setValue(Tools.ifStringIsEmpty(columns));
        rowsSlide.setValue(Tools.ifStringIsEmpty(rows));
        pixChoice.setValue(pix);
        colorText.setText(color);
        alphaText.setText(alpha);

    }
}
