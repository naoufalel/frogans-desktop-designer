package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetreliefFSDL {

    private StringProperty reliefid;

    public SetreliefFSDL() {
        this.reliefid = new SimpleStringProperty("");
    }
    public SetreliefFSDL(StringProperty reliefid) {
        this.reliefid = reliefid;
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

    @Override
    public String toString() {
        return "SetreliefFSDL{" +
                "reliefid=" + reliefid +
                '}';
    }
}
