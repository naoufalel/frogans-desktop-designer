package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetfontFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

/**
 *
 */
public class SetfontLayoutController {
    SetfontFSDL setfontFSDL= new SetfontFSDL();
    private FrogansApp frogansApp;
    @FXML
    private ChoiceBox<String> fontidText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public void fillSetfontLayout(String fontID)
    {
        fontidText.setValue(fontID);
    }
}
