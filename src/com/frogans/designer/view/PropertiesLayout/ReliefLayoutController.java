package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.ReliefFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 07-May-16.
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
    public void fillLayerLayout(String rpos,
                                String color,
                                String blur,
                                String opacity
    ) { rposXText.setText(rpos);
        rposYText.setText(rpos);
        colorText.setText(color);
        blurText.setText(blur);
        opacityText.setText(opacity);


    }

}
