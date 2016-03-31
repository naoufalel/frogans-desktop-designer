package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetshadowFSDL {

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

    @Override
    public String toString() {
        return "SetshadowFSDL{" +
                "shadowid=" + shadowid +
                '}';
    }
}
