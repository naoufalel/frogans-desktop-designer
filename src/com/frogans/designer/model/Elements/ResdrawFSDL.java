package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Naoufal EL BANTLI on 29-Mar-16.
 */
public class ResdrawFSDL {

    private StringProperty resid;
    private StringProperty size;
    private StringProperty figure;
    private StringProperty[] figureArray={
            new SimpleStringProperty("rect"),
            new SimpleStringProperty("roundrect"),
            new SimpleStringProperty("ellipse")
    };
    private StringProperty stroke;
    private StringProperty[] strokeArray ={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty thick;
    private StringProperty round;
    private StringProperty color;

    public ResdrawFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.figure = new SimpleStringProperty("");
        this.stroke = new SimpleStringProperty("");
        this.thick = new SimpleStringProperty("");
        this.round = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
    }
    public ResdrawFSDL(StringProperty resid,
                       StringProperty size,
                       StringProperty figure,
                       StringProperty stroke,
                       StringProperty thick,
                       StringProperty round,
                       StringProperty color) {
        this.resid = resid;
        this.size = size;
        this.figure = figure;
        this.stroke = stroke;
        this.thick = thick;
        this.round = round;
        this.color = color;
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

    public String getFigure() {
        return figure.get();
    }

    public StringProperty figureProperty() {
        return figure;
    }

    public String getStroke() {
        return stroke.get();
    }

    public StringProperty strokeProperty() {
        return stroke;
    }

    public String getThick() {
        return thick.get();
    }

    public StringProperty thickProperty() {
        return thick;
    }

    public String getRound() {
        return round.get();
    }

    public StringProperty roundProperty() {
        return round;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public void setfigure(String figure) {
        this.figure.set(figure);
    }

    public void setstroke(String stroke) {
        this.stroke.set(stroke);
    }

    public void setthick(String thick) {
        this.thick.set(thick);
    }

    public void setround(String round) {
        this.round.set(round);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    @Override
    public String toString() {
        return "ResdrawFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", figure=" + figure +
                ", stroke=" + stroke +
                ", thick=" + thick +
                ", round=" + round +
                ", color=" + color +
                '}';
    }
}
