package com.frogans.designer.view.PropertiesLayout;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.Utils.Tools;
import com.frogans.designer.model.Elements.TextFSDL;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by Aladdin on 11-May-16.
 */
public class TextLayoutController {

    TextFSDL textFSDL= new TextFSDL();

    private FrogansApp frogansApp;
    @FXML
    private TextField fontrefText;
    @FXML
    private ChoiceBox<String> talignChoice;
    @FXML
    private TextField linespaceText;
    @FXML
    private ChoiceBox<String> vstyleChoice;
    @FXML
    private ChoiceBox<String> joinChoice;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {
        fillTalign();
        fillVstyle();
        fillJoin();
    }
    private void fillTalign() {
        for (StringProperty stringProperty : textFSDL.getTalignArray()) {
            talignChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillVstyle() {
        for (StringProperty stringProperty : textFSDL.getVstyleArray()) {
            vstyleChoice.getItems().add(stringProperty.get());
        }
    }

    private void fillJoin() {
        for (StringProperty stringProperty : textFSDL.getJoinArray()) {
            joinChoice.getItems().add(stringProperty.get());
        }
    }

    public void fillTextLayout(  String fontref,
                                 String talign,
                                 String linespace,
                                 String vstyle,
                                 String join
    ) {
        fontrefText.setText(fontref);
        talignChoice.setValue(talign);
        linespaceText.setText(linespace);
        vstyleChoice.setValue(vstyle);
        joinChoice.setValue(join);
    }


}
