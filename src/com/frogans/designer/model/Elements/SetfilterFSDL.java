package com.frogans.designer.model.Elements;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class SetfilterFSDL {
    private StringProperty filterid;

    @Override
    public String toString() {
        return "SetfilterFSDL{" +
                "filterid=" + filterid +
                '}';
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

    public SetfilterFSDL(StringProperty filterid) {
        this.filterid = filterid;
    }
}
