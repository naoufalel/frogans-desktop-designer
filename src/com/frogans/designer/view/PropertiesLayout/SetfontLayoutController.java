package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetfontFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 11-May-16.
 */
public class SetfontLayoutController {
    SetfontFSDL setfontFSDL= new SetfontFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField fontidText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public void fillSetfontLayout(String fontID)
    {
        fontidText.setText(fontID);
    }
}
