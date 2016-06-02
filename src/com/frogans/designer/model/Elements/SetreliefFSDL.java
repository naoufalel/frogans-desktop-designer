package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Thic class defines our SetreliefSDL element
 *
 */
public class SetreliefFSDL {

    private ObservableList<ReliefFSDL> reliefs = FXCollections.observableArrayList();
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

    public ObservableList<ReliefFSDL> getReliefs() {
        return reliefs;
    }

    public void setreliefs(ObservableList<ReliefFSDL> reliefs) {
        this.reliefs = reliefs;
    }

    @Override
    public String toString() {
        return "SetreliefFSDL{" +
                "reliefs=" + reliefs +
                ", reliefid=" + reliefid +
                '}';
    }
}
