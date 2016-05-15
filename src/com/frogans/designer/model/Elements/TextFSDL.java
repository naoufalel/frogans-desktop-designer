package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class TextFSDL {

    private StringProperty fontref;
    private StringProperty talign;
    private StringProperty[] talignArray={
            new SimpleStringProperty("begin"),
            new SimpleStringProperty("end"),
            new SimpleStringProperty("center"),
            new SimpleStringProperty("justify")
    };
    private StringProperty linespace;
    private StringProperty vstyle;
    private StringProperty[] vstyleArray={
            new SimpleStringProperty("natural"),
            new SimpleStringProperty("opposite"),
            new SimpleStringProperty("upright")
    };
    private StringProperty join;
    private StringProperty[] joinArray={
            new SimpleStringProperty("none"),
            new SimpleStringProperty("space"),
            new SimpleStringProperty("nospace")
    };

    public TextFSDL() {
        this.fontref = new SimpleStringProperty("");
        this.talign = new SimpleStringProperty("");
        this.linespace = new SimpleStringProperty("");
        this.vstyle = new SimpleStringProperty("");
        this.join = new SimpleStringProperty("");
    }
    public TextFSDL(StringProperty fontref,
                    StringProperty talign,
                    StringProperty linespace,
                    StringProperty vstyle,
                    StringProperty join) {
        this.fontref = fontref;
        this.talign = talign;
        this.linespace = linespace;
        this.vstyle = vstyle;
        this.join = join;
    }

    public String getFontref() {
        return fontref.get();
    }

    public StringProperty fontrefProperty() {
        return fontref;
    }

    public String getTalign() {
        return talign.get();
    }

    public StringProperty talignProperty() {
        return talign;
    }

    public String getLinespace() {
        return linespace.get();
    }

    public StringProperty linespaceProperty() {
        return linespace;
    }

    public String getVstyle() {
        return vstyle.get();
    }

    public StringProperty vstyleProperty() {
        return vstyle;
    }

    public String getJoin() {
        return join.get();
    }

    public StringProperty joinProperty() {
        return join;
    }

    public void setfontref(String fontref) {
        this.fontref.set(fontref);
    }

    public void settalign(String talign) {
        this.talign.set(talign);
    }

    public void setlinespace(String linespace) {
        this.linespace.set(linespace);
    }

    public void setvstyle(String vstyle) {
        this.vstyle.set(vstyle);
    }

    public void setjoin(String join) {
        this.join.set(join);
    }

    public StringProperty[] getTalignArray() {
        return talignArray;
    }
    public StringProperty[] getVstyleArray() {
        return vstyleArray;
    }
    public StringProperty[] getJoinArray() {
        return joinArray;
    }

    @Override
    public String toString() {
        return "TextFSDL{" +
                "fontref=" + fontref +
                ", talign=" + talign +
                ", linespace=" + linespace +
                ", vstyle=" + vstyle +
                ", join=" + join +
                '}';
    }
}
