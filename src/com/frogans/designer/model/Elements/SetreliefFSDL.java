package com.frogans.designer.model;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetreliefFSDL {

    private StringProperty reliefid;

    @Override
    public String toString() {
        return "SetreliefFSDL{" +
                "reliefid=" + reliefid +
                '}';
    }

    public String getReliefid() {
        return reliefid.get();
    }

    public StringProperty reliefidProperty() {
        return reliefid;
    }

    public void setreliefid(String reliefid) {
        this.reliefid.set(reliefid);
    }

    public SetreliefFSDL(StringProperty reliefid) {
        this.reliefid = reliefid;
    }
}
