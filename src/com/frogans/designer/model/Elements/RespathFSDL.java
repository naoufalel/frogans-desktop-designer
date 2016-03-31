package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class RespathFSDL {

    private StringProperty resid;
    private StringProperty size;
    private StringProperty crop;
    private StringProperty[] cropArray={
            new SimpleStringProperty("none"),
            new SimpleStringProperty("auto"),
            new SimpleStringProperty("custom")
    };
    private StringProperty corners;
    private StringProperty stroke;
    private StringProperty[] strokeArray ={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty thick;
    private StringProperty close;
    private StringProperty[] closeArray={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty fill;
    private StringProperty[] fillArray={
            new SimpleStringProperty("non-zero"),
            new SimpleStringProperty("even-odd")
    };
    private StringProperty spread;
    private StringProperty[] spreadArray={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty color;

    public RespathFSDL(StringProperty resid,
                       StringProperty[] spread,
                       StringProperty spreadValue,
                       StringProperty color,
                       StringProperty fillValue,
                       StringProperty[] fill,
                       StringProperty[] close,
                       StringProperty closeValue,
                       StringProperty thick,
                       StringProperty[] stroke,
                       StringProperty strokeValue,
                       StringProperty[] crop,
                       StringProperty corners,
                       StringProperty cropValue,
                       StringProperty size) {
        this.resid = resid;
        this.spread = spread;
        this.spreadValue = spreadValue;
        this.color = color;
        this.fillValue = fillValue;
        this.fill = fill;
        this.close = close;
        this.closeValue = closeValue;
        this.thick = thick;
        this.stroke = stroke;
        this.strokeValue = strokeValue;
        this.crop = crop;
        this.corners = corners;
        this.cropValue = cropValue;
        this.size = size;
    }

    @Override
    public String toString() {
        return "RespathFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", cropValue=" + cropValue +
                ", crop=" + Arrays.toString(crop) +
                ", corners=" + corners +
                ", strokeValue=" + strokeValue +
                ", stroke=" + Arrays.toString(stroke) +
                ", thick=" + thick +
                ", closeValue=" + closeValue +
                ", close=" + Arrays.toString(close) +
                ", fillValue=" + fillValue +
                ", fill=" + Arrays.toString(fill) +
                ", spreadValue=" + spreadValue +
                ", spread=" + Arrays.toString(spread) +
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

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    public String getSpreadValue() {
        return spreadValue.get();
    }

    public StringProperty spreadValueProperty() {
        return spreadValue;
    }

    public void setspreadvalue(String spreadValue) {
        this.spreadValue.set(spreadValue);
    }

    public StringProperty[] getFill() {
        return fill;
    }

    public void setfill(StringProperty[] fill) {
        this.fill = fill;
    }

    public StringProperty[] getSpread() {
        return spread;
    }

    public void setspread(StringProperty[] spread) {
        this.spread = spread;
    }

    public String getFillValue() {
        return fillValue.get();
    }

    public StringProperty fillValueProperty() {
        return fillValue;
    }

    public void setfillvalue(String fillValue) {
        this.fillValue.set(fillValue);
    }

    public String getCloseValue() {
        return closeValue.get();
    }

    public StringProperty closeValueProperty() {
        return closeValue;
    }

    public void setclosevalue(String closeValue) {
        this.closeValue.set(closeValue);
    }

    public StringProperty[] getClose() {
        return close;
    }

    public void setclose(StringProperty[] close) {
        this.close = close;
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

    public String getCorners() {
        return corners.get();
    }

    public StringProperty cornersProperty() {
        return corners;
    }

    public void setcorners(String corners) {
        this.corners.set(corners);
    }

    public StringProperty[] getCrop() {
        return crop;
    }

    public void setcrop(StringProperty[] crop) {
        this.crop = crop;
    }

    public String getCropValue() {
        return cropValue.get();
    }

    public StringProperty cropValueProperty() {
        return cropValue;
    }

    public void setcropvalue(String cropValue) {
        this.cropValue.set(cropValue);
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
}
