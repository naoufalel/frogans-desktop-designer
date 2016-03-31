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


}
