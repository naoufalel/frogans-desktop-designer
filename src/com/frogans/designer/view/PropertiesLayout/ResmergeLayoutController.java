package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.ResmergeFSDL;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 */
public class ResmergeLayoutController {

    ResmergeFSDL resmergeFSDL = new ResmergeFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField residText;
    @FXML
    private TextField sizeWText;
    @FXML
    private TextField sizeHText;
    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {

    }
    public void fillResmergeLayout( String resid,
                                    String size
    ) {
        residText.setText(resid);
        sizeWText.setText(Tools.splitPosition(size).get(0));
        sizeHText.setText(Tools.splitPosition(size).get(1));
    }
}
