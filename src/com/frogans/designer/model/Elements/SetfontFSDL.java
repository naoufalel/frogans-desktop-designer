package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetfontFSDL {
    private StringProperty fontid;

    public SetfontFSDL() {
        this.fontid = new SimpleStringProperty("");
    }
    public SetfontFSDL(StringProperty fontid) {
        this.fontid = fontid;
    }

    public String getFontid() {
        return fontid.get();
    }

    public StringProperty fontidProperty() {
        return fontid;
    }

    public void setfontid(String fontid) {
        this.fontid.set(fontid);
    }

    @Override
    public String toString() {
        return "SetfontFSDL{" +
                "fontid=" + fontid +
                '}';
    }
}
