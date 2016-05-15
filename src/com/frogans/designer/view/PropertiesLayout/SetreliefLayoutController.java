package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.SetreliefFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 11-May-16.
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
