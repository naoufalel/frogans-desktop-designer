package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.FilterFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 *
 */
public class FilterLayoutController {

    FilterFSDL filterFSDL= new FilterFSDL();
    private FrogansApp frogansApp;
    @FXML
    private ChoiceBox<String> effectChoice;
    @FXML
    private TextField levelText;
    @FXML
    private TextField angleText;
    @FXML
    private TextField toleranceText;
    @FXML
    private TextField colorText;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillEffect();
    }

    private void fillEffect() {
        for (StringProperty stringProperty : filterFSDL.getEffectArray()) {
            effectChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillFilterLayout(String effect,
                                 String level,
                                 String angle,
                                 String tolerance,
                                 String color
    ) {
        effectChoice.setValue(effect);
        levelText.setText(level);
        angleText.setText(angle);
        toleranceText.setText(tolerance);
        colorText.setText(color);

    }
}
