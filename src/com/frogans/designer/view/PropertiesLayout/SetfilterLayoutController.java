package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetfilterFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class SetfilterLayoutController {
    SetfilterFSDL setfilterFSDL = new SetfilterFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField filteridText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public void fillSetfilterLayout(String filterID)
    {
        filteridText.setText(filterID);
    }
}
