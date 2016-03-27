package com.frogans.designer.model.Elements;

import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naoufal EL BANTLI on 3/27/2016.
 */
public class LayerFSDL {

    // Mandatory shit
    private StringProperty layerid;

    private StringProperty leapoutValue;

    private StringProperty combineValue;


    private StringProperty[] leapout = {
            new SimpleStringProperty("all"),
            new SimpleStringProperty("lead"),
            new SimpleStringProperty("vigentte")
    };
    private StringProperty resref;

    private List<IntegerProperty> pos;

    private StringProperty[] combine = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };
    private StringProperty[] combineButton = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };


    // Optional shit
    private StringProperty flipValue;
    private StringProperty[] flip = {
            new SimpleStringProperty("none"),
            new SimpleStringProperty("xdir"),
            new SimpleStringProperty("ydir"),
            new SimpleStringProperty("xydir")};

    private StringProperty filterref;

    private StringProperty reliefref;
    private IntegerProperty blur;
    private IntegerProperty opacity;

    private IntegerProperty angle;

    private StringProperty alignValue;
    private StringProperty[] align = {
            new SimpleStringProperty("left-top"),
            new SimpleStringProperty("left-middle"),
            new SimpleStringProperty("left-bottom"),
            new SimpleStringProperty("center-top"),
            new SimpleStringProperty("center-middle"),
            new SimpleStringProperty("center-bottom"),
            new SimpleStringProperty("right-top"),
            new SimpleStringProperty("right-middle"),
            new SimpleStringProperty("right-bottom"),
    };


    private StringProperty shawdowref;


    // Mandatory and optional shit
    private StringProperty visibleValue;
    private StringProperty[] visible = {
            new SimpleStringProperty("always"),
            new SimpleStringProperty("nofocus"),
            new SimpleStringProperty("focus")
    };

    /**
     * Constructor of mandatory attributes when not child of Button
     * @param layerid
     * @param leapoutValue
     * @param combineValue
     * @param resref
     * @param pos
     */
    public LayerFSDL(StringProperty layerid, StringProperty leapoutValue, StringProperty combineValue, StringProperty resref, List<IntegerProperty> pos) {
        this.layerid = layerid;
        this.leapoutValue = leapoutValue;
        this.combineValue = combineValue;
        this.resref = resref;
        this.pos = pos;
    }





    public String getLayerid() {
        return layerid.get();
    }

    public StringProperty layeridProperty() {
        return layerid;
    }

    public void setLayerid(String layerid) {
        this.layerid.set(layerid);
    }

    public String getLeapoutValue() {
        return leapoutValue.get();
    }

    public StringProperty leapoutValueProperty() {
        return leapoutValue;
    }

    public void setLeapoutValue(String leapoutValue) {
        this.leapoutValue.set(leapoutValue);
    }

    public String getCombineValue() {
        return combineValue.get();
    }

    public StringProperty combineValueProperty() {
        return combineValue;
    }

    public void setCombineValue(String combineValue) {
        this.combineValue.set(combineValue);
    }

    public String getResref() {
        return resref.get();
    }

    public StringProperty resrefProperty() {
        return resref;
    }

    public void setResref(String resref) {
        this.resref.set(resref);
    }

    public List<IntegerProperty> getPos() {
        return pos;
    }

    public void setPos(List<IntegerProperty> pos) {
        this.pos = pos;
    }


    @Override
    public String toString() {
        return "LayerFSDL{" +
                "layerid=" + layerid +
                ", leapoutValue=" + leapoutValue +
                ", combineValue=" + combineValue +
                ", resref=" + resref +
                ", pos=" + pos +
                '}';
    }
}
