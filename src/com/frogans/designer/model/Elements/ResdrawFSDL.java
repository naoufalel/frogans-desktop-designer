package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
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

    public ResdrawFSDL(StringProperty resid,
                       StringProperty color,
                       StringProperty round,
                       StringProperty thick,
                       StringProperty[] stroke,
                       StringProperty[] figure,
                       StringProperty strokeValue,
                       StringProperty size,
                       StringProperty figureValue)
    {
        this.resid = resid;
        this.color = color;
        this.round = round;
        this.thick = thick;
        this.stroke = stroke;
        this.figure = figure;
        this.strokeValue = strokeValue;
        this.size = size;
        this.figureValue = figureValue;
    }

    @Override
    public String toString() {
        return "ResdrawFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", figureValue=" + figureValue +
                ", figure=" + Arrays.toString(figure) +
                ", strokeValue=" + strokeValue +
                ", stroke=" + Arrays.toString(stroke) +
                ", thick=" + thick +
                ", round=" + round +
                ", color=" + color +
                '}';
    }

    public String getResid() {
        return resid.get();
    }

    public StringProperty residProperty() {
        return resid;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public String getRound() {
        return round.get();
    }

    public StringProperty roundProperty() {
        return round;
    }

    public void setround(String round) {
        this.round.set(round);
    }

    public String getThick() {
        return thick.get();
    }

    public StringProperty thickProperty() {
        return thick;
    }

    public void setthick(String thick) {
        this.thick.set(thick);
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    public StringProperty[] getStroke() {
        return stroke;
    }

    public void setstroke(StringProperty[] stroke) {
        this.stroke = stroke;
    }

    public String getStrokeValue() {
        return strokeValue.get();
    }

    public StringProperty strokeValueProperty() {
        return strokeValue;
    }

    public void setstrokevalue(String strokeValue) {
        this.strokeValue.set(strokeValue);
    }

    public String getSize() {
        return size.get();
    }

    public StringProperty sizeProperty() {
        return size;
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public StringProperty[] getFigure() {
        return figure;
    }

    public void setfigure(StringProperty[] figure) {
        this.figure = figure;
    }

    public String getFigureValue() {
        return figureValue.get();
    }

    public StringProperty figureValueProperty() {
        return figureValue;
    }

    public void setfigurevalue(String figureValue) {
        this.figureValue.set(figureValue);
    }
}
