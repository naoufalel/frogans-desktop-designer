package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetreliefFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class SetreliefLayoutController {

   SetreliefFSDL setreliefFSDL=new SetreliefFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField reliefidText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public void fillSetreliefLayout(String reliefID)
    {
        reliefidText.setText(reliefID);
    }
}
