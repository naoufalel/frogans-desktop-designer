package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;

/** Thic class defines our SetfontFSDL element
 *
 */
public class SetfontFSDL {

    private ObservableList<FontFSDL> fonts = FXCollections.observableArrayList();
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

    public ObservableList<FontFSDL> getFonts() {
        return fonts;
    }

    public void setfonts(ObservableList<FontFSDL> fonts) {
        this.fonts = fonts;
    }

    @Override
    public String toString() {
        return "SetfontFSDL{" +
                "fonts=" + fonts +
                ", fontid=" + fontid +
                '}';
    }
}
