package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.NextFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class NextLayoutController {

    NextFSDL nextFSDL=new NextFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField delayText;
    @FXML
    private TextField fileRefText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
    }

    public void fillNextLayout(String delay,
                                String fileref

    ) {
        delayText.setText(delay);
        fileRefText.setText(fileref);
    }
}
