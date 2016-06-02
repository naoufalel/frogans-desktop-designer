package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.FontFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 */
public class FontLayoutController {

    FontFSDL fontFSDL =new FontFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField scriptsText;
    @FXML
    private TextField pfontText;
    @FXML
    private TextField heightText;
    @FXML
    private TextField spacingText;
    @FXML
    private TextField stretchingText;
    @FXML
    private TextField xboldText;
    @FXML
    private TextField xitalicText;
    @FXML
    private ChoiceBox<String> underlineChoice;
    @FXML
    private ChoiceBox<String> strikeoutChoice;
    @FXML
    private TextField opacityText;
    @FXML
    private TextField colorText;
    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillUnderline();
        fillStrikeout();
    }
    private void fillUnderline() {
        for (StringProperty stringProperty : fontFSDL.getUnderlineArray()) {
            underlineChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillStrikeout() {
        for (StringProperty stringProperty : fontFSDL.getStrikeoutArray()) {
            strikeoutChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillFontLayout(String scripts,
                                String pfont,
                                String height,
                                String spacing,
                                String stretching,
                                String xbold,
                                String xitalic,
                                String underline,
                                String strikeout,
                                String opacity,
                                String color
    ) {
        scriptsText.setText(scripts);
        pfontText.setText(pfont);
        heightText.setText(height);
        spacingText.setText(spacing);
        stretchingText.setText(stretching);
        xboldText.setText(xbold);
        xitalicText.setText(xitalic);
        underlineChoice.setValue(underline);
        strikeoutChoice.setValue(strikeout);
        opacityText.setText(opacity);
        colorText.setText(color);

    }

}
