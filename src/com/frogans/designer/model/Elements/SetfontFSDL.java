package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetfontFSDL {
    private StringProperty resid;

    public SetfontFSDL() {
        this.resid = new SimpleStringProperty("");
    }
    public SetfontFSDL(StringProperty resid) {
        this.resid = resid;
    }

    public String getResid() {
        return resid.get();
    }

    public StringProperty residProperty() {
        return resid;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    @Override
    public String toString() {
        return "SetfontFSDL{" +
                "resid=" + resid +
                '}';
    }
}
