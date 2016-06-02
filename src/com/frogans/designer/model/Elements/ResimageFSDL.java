package com.frogans.designer.model.Elements;


import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  Thic class defines our ResimageFSDL element
 *
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

    public ResimageFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.fileref = new SimpleStringProperty("");
        this.selection = new SimpleStringProperty("");
        this.bounds = new SimpleStringProperty("");
        this.aspect = new SimpleStringProperty("");
        this.adjust = new SimpleStringProperty("");
        this.origin = new SimpleStringProperty("");
    }
    public ResimageFSDL(StringProperty resid,
                        StringProperty size,
                        StringProperty fileref,
                        StringProperty selection,
                        StringProperty bounds,
                        StringProperty aspect,
                        StringProperty adjust,
                        StringProperty origin) {
        this.resid = resid;
        this.size = size;
        this.fileref = fileref;
        this.selection = selection;
        this.bounds = bounds;
        this.aspect = aspect;
        this.adjust = adjust;
        this.origin = origin;
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

    public String getFileref() {
        return fileref.get();
    }

    public StringProperty filerefProperty() {
        return fileref;
    }

    public String getSelection() {
        return selection.get();
    }

    public StringProperty selectionProperty() {
        return selection;
    }

    public String getBounds() {
        return bounds.get();
    }

    public StringProperty boundsProperty() {
        return bounds;
    }

    public String getAspect() {
        return aspect.get();
    }

    public StringProperty aspectProperty() {
        return aspect;
    }

    public String getAdjust() {
        return adjust.get();
    }

    public StringProperty adjustProperty() {
        return adjust;
    }

    public String getOrigin() {
        return origin.get();
    }

    public StringProperty originProperty() {
        return origin;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public void setfileref(String fileref) {
        this.fileref.set(fileref);
    }

    public void setselection(String selection) {
        this.selection.set(selection);
    }

    public void setbounds(String bounds) {
        this.bounds.set(bounds);
    }

    public void setaspect(String aspect) {
        this.aspect.set(aspect);
    }

    public void setadjust(String adjust) {
        this.adjust.set(adjust);
    }

    public void setorigin(String origin) {
        this.origin.set(origin);
    }

    public StringProperty[] getSelectionArray() {
        return selectionArray;
    }
    public StringProperty[] getAspectArray() {
        return aspectArray;
    }


    @Override
    public String toString() {
        return "ResimageFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", fileref=" + fileref +
                ", selection=" + selection +
                ", bounds=" + bounds +
                ", aspect=" + aspect +
                ", adjust=" + adjust +
                ", origin=" + origin +
                '}';
    }
}
