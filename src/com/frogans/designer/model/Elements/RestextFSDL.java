package com.frogans.designer.model.Elements;

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

    public RestextFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.fontref = new SimpleStringProperty("");
        this.talign = new SimpleStringProperty("");
        this.linespace = new SimpleStringProperty("");
        this.vstyle = new SimpleStringProperty("");
        this.orientation = new SimpleStringProperty("");
    }
    public RestextFSDL(StringProperty resid,
                       StringProperty size,
                       StringProperty fontref,
                       StringProperty talign,
                       StringProperty linespace,
                       StringProperty vstyle,
                       StringProperty orientation) {
        this.resid = resid;
        this.size = size;
        this.fontref = fontref;
        this.talign = talign;
        this.linespace = linespace;
        this.vstyle = vstyle;
        this.orientation = orientation;
    }

    public String getResid() {
        return resid.get();
    }

    public StringProperty residProperty() {
        return resid;
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public String getOrientation() {
        return orientation.get();
    }

    public StringProperty orientationProperty() {
        return orientation;
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

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public void setorientation(String orientation) {
        this.orientation.set(orientation);
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

    @Override
    public String toString() {
        return "RestextFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", orientation=" + orientation +
                ", fontref=" + fontref +
                ", talign=" + talign +
                ", linespace=" + linespace +
                ", vstyle=" + vstyle +
                '}';
    }
}
