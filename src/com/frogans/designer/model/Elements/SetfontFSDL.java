package com.frogans.designer.model;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetfontFSDL {
    private StringProperty resid;

    public SetfontFSDL(StringProperty resid) {
        this.resid = resid;
    }

    @Override
    public String toString() {
        return "SetfontFSDL{" +
                "resid=" + resid +
                '}';
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
}
