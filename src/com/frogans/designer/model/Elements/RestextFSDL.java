package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class RestextFSDL {

    private StringProperty resid;
    private StringProperty size;
    private StringProperty orientation;
    private StringProperty[] orientationArray={
            new SimpleStringProperty("h-ttb-ltr"),
            new SimpleStringProperty("h-ttb-rtl"),
            new SimpleStringProperty("h-btt-ltr"),
            new SimpleStringProperty("h-btt-rtl"),
            new SimpleStringProperty("v-ltr-ttb"),
            new SimpleStringProperty("v-ltr-btt"),
            new SimpleStringProperty("v-rtl-ttb"),
            new SimpleStringProperty("v-rtl-btt")
    };
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
            new SimpleStringProperty("upright"),
    };

    public String getResid() {
        return resid.get();
    }

    public StringProperty residProperty() {
        return resid;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public StringProperty[] getVstyle() {
        return vstyle;
    }

    public void setvstyle(StringProperty[] vstyle) {
        this.vstyle = vstyle;
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

    public StringProperty[] getTalign() {
        return talign;
    }

    public void settalign(StringProperty[] talign) {
        this.talign = talign;
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

    public String getFontref() {
        return fontref.get();
    }

    public StringProperty fontrefProperty() {
        return fontref;
    }

    public void setfontref(String fontref) {
        this.fontref.set(fontref);
    }

    public String getOrientationValue() {
        return orientationValue.get();
    }

    public StringProperty orientationValueProperty() {
        return orientationValue;
    }

    public void setorientationvalue(String orientationValue) {
        this.orientationValue.set(orientationValue);
    }

    public StringProperty[] getOrientation() {
        return orientation;
    }

    public void setorientation(StringProperty[] orientation) {
        this.orientation = orientation;
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    @Override
    public String toString() {
        return "RestextFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", orientationValue=" + orientationValue +
                ", orientation=" + Arrays.toString(orientation) +
                ", fontref=" + fontref +
                ", talignValue=" + talignValue +
                ", talign=" + Arrays.toString(talign) +
                ", linespace=" + linespace +
                ", vstyleValue=" + vstyleValue +
                ", vstyle=" + Arrays.toString(vstyle) +
                '}';
    }

    public RestextFSDL(StringProperty resid,
                       StringProperty orientationValue,
                       StringProperty fontref,
                       StringProperty size,
                       StringProperty[] orientation,
                       StringProperty talignValue,
                       StringProperty[] talign,
                       StringProperty linespace,
                       StringProperty vstyleValue,
                       StringProperty[] vstyle) {
        this.resid = resid;
        this.orientationValue = orientationValue;
        this.fontref = fontref;
        this.size = size;
        this.orientation = orientation;
        this.talignValue = talignValue;
        this.talign = talign;
        this.linespace = linespace;
        this.vstyleValue = vstyleValue;
        this.vstyle = vstyle;
    }
}
