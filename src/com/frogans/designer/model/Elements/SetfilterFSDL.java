package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/** Thic class defines our SetfilterFSDL element
 *
 */
public class SetfilterFSDL {

    private ObservableList<FilterFSDL> filters = FXCollections.observableArrayList();
    private StringProperty filterid;

    public SetfilterFSDL() {
        this.filterid =new SimpleStringProperty("");
    }
    public SetfilterFSDL(StringProperty filterid) {
        this.filterid = filterid;
    }

    public String getFilterid() {
        return filterid.get();
    }

    public StringProperty filteridProperty() {
        return filterid;
    }

    public void setfilterid(String filterid) {
        this.filterid.set(filterid);
    }

    public ObservableList<FilterFSDL> getFilters() {
        return filters;
    }

    public void setfilters(ObservableList<FilterFSDL> filters) {
        this.filters = filters;
    }

    @Override
    public String toString() {
        return "SetfilterFSDL{" +
                "filters=" + filters +
                ", filterid=" + filterid +
                '}';
    }
}
