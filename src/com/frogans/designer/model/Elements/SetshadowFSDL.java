package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Thic class defines our SetshadowFSDL element
 *
 */
public class SetshadowFSDL {

    private ObservableList<ShadowFSDL> shadows = FXCollections.observableArrayList();

    private StringProperty shadowid;

    public SetshadowFSDL() {
        this.shadowid = new SimpleStringProperty("");
    }
    public SetshadowFSDL(StringProperty shadowid) {
        this.shadowid = shadowid;
    }

    public String getShadowid() {
        return shadowid.get();
    }

    public StringProperty shadowidProperty() {
        return shadowid;
    }

    public void setshadowid(String shadowid) {
        this.shadowid.set(shadowid);
    }

    public ObservableList<ShadowFSDL> getShadows() {
        return shadows;
    }

    public void setshadows(ObservableList<ShadowFSDL> shadows) {
        this.shadows = shadows;
    }

    @Override
    public String toString() {
        return "SetshadowFSDL{" +
                "shadows=" + shadows +
                ", shadowid=" + shadowid +
                '}';
    }
}
