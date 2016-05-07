package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.ButtonFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ButtonLayoutController {

    ButtonFSDL buttonFSDL = new ButtonFSDL();
    private FrogansApp frogansApp;
    @FXML
    private TextField idButton;
    @FXML
    private ChoiceBox<String> typeChoice;
    @FXML
    private TextField filerefText;
    @FXML
    private TextField addressText;
    @FXML
    private TextField urlText;
    @FXML
    private TextField emailText;


    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillType();
    }

    private void fillType() {
        for (StringProperty stringProperty : buttonFSDL.getGo_toArray()) {
            typeChoice.getItems().add(stringProperty.get());
        }
    }
    public void fillButtonLayout(String buttonid,
                                 String fileref,
                                 String go_to,
                                 String address,
                                 String url,
                                 String email
    ) {
        idButton.setText(buttonid);
        typeChoice.setValue(go_to);
        filerefText.setText(fileref);
        addressText.setText(address);
        urlText.setText(url);
        emailText.setText(email);

    }
}
