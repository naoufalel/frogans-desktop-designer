package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class ResmergeFSDL {

    private StringProperty resid;
    private StringProperty size;

    public ResmergeFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
    }

    public ResmergeFSDL(StringProperty resid, StringProperty size) {
        this.resid = resid;
        this.size = size;
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


    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public void setsize(String size) {
        this.size.set(size);
    }
}
