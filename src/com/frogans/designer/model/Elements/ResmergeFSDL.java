package com.frogans.designer.model.Elements;

import com.sun.scenario.effect.Merge;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Thic class defines our ResmergeFSDL element
 *
 */
public class ResmergeFSDL {

    private ObservableList<MergeFSDL> merges = FXCollections.observableArrayList();

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

    public ObservableList<MergeFSDL> getMerges() {
        return merges;
    }

    public void setmerges(ObservableList<MergeFSDL> merges) {
        this.merges = merges;
    }
}
