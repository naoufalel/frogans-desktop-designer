package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.ResimageFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 02/04/2016.
 */
public class ResimageLayoutController {

    ResimageFSDL resimageFSDL =new ResimageFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField residText;
    @FXML
    private TextField sizeWText;
    @FXML
    private TextField sizeHText;
    @FXML
    private TextField filerefText;
    @FXML
    private ChoiceBox<String> selectionChoice;
    @FXML
    private TextField boundsTopText;
    @FXML
    private TextField boundsLeftText;
    @FXML
    private TextField boundsRightText;
    @FXML
    private TextField boundBottomText;
    @FXML
    private ChoiceBox<String> aspectChoice;
    @FXML
    private Slider adjustSlide;
    @FXML
    private Label adjustLabel;
    @FXML
    private TextField originXText;
    @FXML
    private TextField originYText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }
    @FXML
    public void initialize(){
        fillSelection();
        fillAspect();
    }
    private void fillSelection() {
        for (StringProperty stringProperty : resimageFSDL.getSelectionArray()) {
            selectionChoice.getItems().add(stringProperty.get());
        }
    }
    private void fillAspect() {
        for (StringProperty stringProperty : resimageFSDL.getAspectArray()) {
            selectionChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillResimageLayout(String resid,
                                String size,
                                String fileref,
                                String selection,
                                String bounds,
                                String aspect,
                                String adjust,
                                String origin
    ) {
        residText.setText(resid);
        sizeHText.setText(Tools.splitPosition(size).get(0));
        sizeWText.setText(Tools.splitPosition(size).get(1));
        filerefText.setText(fileref);
        selectionChoice.setValue(selection);
        boundsTopText.setText(Tools.splitPosition(bounds).get(0));
        boundBottomText.setText(Tools.splitPosition(bounds).get(1));
        boundsLeftText.setText(Tools.splitPosition(bounds).get(2));
        boundsRightText.setText(Tools.splitPosition(bounds).get(3));
        aspectChoice.setValue(aspect);
        adjustSlide.setValue(Tools.ifStringIsEmpty(adjust));
        adjustLabel.setText(adjust);
        originXText.setText(Tools.splitPosition(origin).get(0));
        originYText.setText(Tools.splitPosition(origin).get(1));
    }
}
