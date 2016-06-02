package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetshadowFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class ShadowidLayoutController {
    SetshadowFSDL setshadowFSDL= new SetshadowFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField shadowidText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public void fillShadowidLayout(String shadowID)
    {
        shadowidText.setText(shadowID);
    }
}
