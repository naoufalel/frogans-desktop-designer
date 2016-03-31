package com.frogans.designer.model;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class ResmergeFSDL {

    private StringProperty resid;
    private StringProperty size;

    @Override
    public String toString() {
        return "ResmergeFSDL{" +
                "resid=" + resid +
                ", size=" + size +
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

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public ResmergeFSDL(StringProperty resid,
                        StringProperty size) {
        this.resid = resid;
        this.size = size;
    }
}
