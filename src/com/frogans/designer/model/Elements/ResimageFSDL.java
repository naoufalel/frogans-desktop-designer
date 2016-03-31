package com.frogans.designer.model;


import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class ResimageFSDL {
    private StringProperty resid;

    private StringProperty size;

    private StringProperty fileref;

    private StringProperty selection;

    private StringProperty [] selectionArray={
            new SimpleStringProperty("entire"),
            new SimpleStringProperty("extract")
    };

    private StringProperty bounds;

    private StringProperty aspect;

    private StringProperty [] aspectArray={
                new SimpleStringProperty("base"),
                new SimpleStringProperty("spread"),
                new SimpleStringProperty("zoom"),
                new SimpleStringProperty("echo"),
                new SimpleStringProperty("tile")
    };

    private StringProperty adjust;
    private StringProperty origin;

    public StringProperty getResid() {
        return resid;
    }

    public void setresid(StringProperty resid) {
        this.resid = resid;
    }

    public StringProperty getOrigin() {
        return origin;
    }

    public void setorigin(StringProperty origin) {
        this.origin = origin;
    }

    public StringProperty getAdjust() {
        return adjust;
    }

    public void setadjust(StringProperty adjust) {
        this.adjust = adjust;
    }

    public StringProperty getAspectValue() {
        return aspectValue;
    }

    public void setaspectvalue(StringProperty aspectValue) {
        this.aspectValue = aspectValue;
    }

    public StringProperty[] getAspect() {
        return aspect;
    }

    public void setaspect(StringProperty[] aspect) {
        this.aspect = aspect;
    }

    public StringProperty getBounds() {
        return bounds;
    }

    public void setbounds(StringProperty bounds) {
        this.bounds = bounds;
    }

    public StringProperty[] getSelection() {
        return selection;
    }

    public void setselection(StringProperty[] selection) {
        this.selection = selection;
    }

    public StringProperty getSelectionValue() {
        return selectionValue;
    }

    public void setselectionvalue(StringProperty selectionValue) {
        this.selectionValue = selectionValue;
    }

    public StringProperty getFileref() {
        return fileref;
    }

    public void setfileref(StringProperty fileref) {
        this.fileref = fileref;
    }

    public StringProperty getSize() {
        return size;
    }

    public void setsize(StringProperty size) {
        this.size = size;
    }

    public ResimageFSDL(StringProperty adjust,
                        StringProperty origin,
                        StringProperty[] aspect,
                        StringProperty aspectValue,
                        StringProperty bounds,
                        StringProperty selectionValue,
                        StringProperty fileref,
                        StringProperty[] selection,
                        StringProperty size,
                        StringProperty resid) {
        this.adjust = adjust;
        this.origin = origin;
        this.aspect = aspect;
        this.aspectValue = aspectValue;
        this.bounds = bounds;
        this.selectionValue = selectionValue;
        this.fileref = fileref;
        this.selection = selection;
        this.size = size;
        this.resid = resid;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ResimageFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", fileref=" + fileref +
                ", selectionValue=" + selectionValue +
                ", selection=" + java.util.Arrays.toString(selection) +
                ", bounds=" + bounds +
                ", aspectValue=" + aspectValue +
                ", aspect=" + java.util.Arrays.toString(aspect) +
                ", adjust=" + adjust +
                ", origin=" + origin +
                '}';
    }
}
