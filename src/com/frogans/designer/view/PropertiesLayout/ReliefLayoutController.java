package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.ReliefFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class ReliefLayoutController {
    ReliefFSDL reliefFSDL =new ReliefFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField rposXText;
    @FXML
    private TextField rposYText;
    @FXML
    private TextField colorText;
    @FXML
    private TextField blurText;
    @FXML
    private TextField opacityText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {

    }
    public void fillReliefLayout(String rpos,
                                String color,
                                String blur,
                                String opacity
    ) { rposXText.setText(Tools.splitPosition(rpos).get(0));
        rposYText.setText(Tools.splitPosition(rpos).get(1));
        colorText.setText(color);
        blurText.setText(blur);
        opacityText.setText(opacity);


    }

}
