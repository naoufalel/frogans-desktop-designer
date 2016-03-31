package com.frogans.designer.model;

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

    @Override
    public String toString() {
        return "TextFSDL{" +
                "fontref=" + fontref +
                ", talignValue=" + talignValue +
                ", talign=" + Arrays.toString(talign) +
                ", linespace=" + linespace +
                ", vstyleValue=" + vstyleValue +
                ", vstyle=" + Arrays.toString(vstyle) +
                ", joinValue=" + joinValue +
                ", join=" + Arrays.toString(join) +
                '}';
    }

    public String getFontref() {
        return fontref.get();
    }

    public StringProperty fontrefProperty() {
        return fontref;
    }

    public void setfontref(String fontref) {
        this.fontref.set(fontref);
    }

    public String getTalignValue() {
        return talignValue.get();
    }

    public StringProperty talignValueProperty() {
        return talignValue;
    }

    public void settalignvalue(String talignValue) {
        this.talignValue.set(talignValue);
    }

    public StringProperty[] getTalign() {
        return talign;
    }

    public void settalign(StringProperty[] talign) {
        this.talign = talign;
    }

    public String getLinespace() {
        return linespace.get();
    }

    public StringProperty linespaceProperty() {
        return linespace;
    }

    public void setlinespace(String linespace) {
        this.linespace.set(linespace);
    }

    public String getVstyleValue() {
        return vstyleValue.get();
    }

    public StringProperty vstyleValueProperty() {
        return vstyleValue;
    }

    public void setvstylevalue(String vstyleValue) {
        this.vstyleValue.set(vstyleValue);
    }

    public StringProperty[] getVstyle() {
        return vstyle;
    }

    public void setvstyle(StringProperty[] vstyle) {
        this.vstyle = vstyle;
    }

    public String getJoinValue() {
        return joinValue.get();
    }

    public StringProperty joinValueProperty() {
        return joinValue;
    }

    public void setjoinvalue(String joinValue) {
        this.joinValue.set(joinValue);
    }

    public StringProperty[] getJoin() {
        return join;
    }

    public void setjoin(StringProperty[] join) {
        this.join = join;
    }

    public TextFSDL(StringProperty vstyleValue,
                    StringProperty fontref,
                    StringProperty talignValue,
                    StringProperty[] talign,
                    StringProperty linespace,
                    StringProperty[] vstyle,
                    StringProperty joinValue,
                    StringProperty[] join) {
        this.vstyleValue = vstyleValue;
        this.fontref = fontref;
        this.talignValue = talignValue;
        this.talign = talign;
        this.linespace = linespace;
        this.vstyle = vstyle;
        this.joinValue = joinValue;
        this.join = join;
    }
}
