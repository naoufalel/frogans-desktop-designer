package com.frogans.designer.model.Elements;

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

    public RespathFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.crop = new SimpleStringProperty("");
        this.corners = new SimpleStringProperty("");
        this.stroke = new SimpleStringProperty("");
        this.thick = new SimpleStringProperty("");
        this.close = new SimpleStringProperty("");
        this.fill = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
        this.spread = new SimpleStringProperty("");
    }
    public RespathFSDL(StringProperty resid,
                       StringProperty size,
                       StringProperty crop,
                       StringProperty corners,
                       StringProperty stroke,
                       StringProperty thick,
                       StringProperty close,
                       StringProperty fill,
                       StringProperty color,
                       StringProperty spread) {
        this.resid = resid;
        this.size = size;
        this.crop = crop;
        this.corners = corners;
        this.stroke = stroke;
        this.thick = thick;
        this.close = close;
        this.fill = fill;
        this.color = color;
        this.spread = spread;
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

    public String getCrop() {
        return crop.get();
    }

    public StringProperty cropProperty() {
        return crop;
    }

    public String getCorners() {
        return corners.get();
    }

    public StringProperty cornersProperty() {
        return corners;
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

    public String getClose() {
        return close.get();
    }

    public StringProperty closeProperty() {
        return close;
    }

    public String getFill() {
        return fill.get();
    }

    public StringProperty fillProperty() {
        return fill;
    }

    public String getSpread() {
        return spread.get();
    }

    public StringProperty spreadProperty() {
        return spread;
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

    public void setcrop(String crop) {
        this.crop.set(crop);
    }

    public void setcorners(String corners) {
        this.corners.set(corners);
    }

    public void setstroke(String stroke) {
        this.stroke.set(stroke);
    }

    public void setthick(String thick) {
        this.thick.set(thick);
    }

    public void setclose(String close) {
        this.close.set(close);
    }

    public void setfill(String fill) {
        this.fill.set(fill);
    }

    public void setspread(String spread) {
        this.spread.set(spread);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }


    public StringProperty[] getCropArray() {
        return cropArray;
    }
    public StringProperty[] getStrokeArray() {
        return strokeArray;
    }
    public StringProperty[] getCloseArray() {
        return closeArray;
    }
    public StringProperty[] getFillArray() {
        return fillArray;
    }
    public StringProperty[] getSpreadArray() {
        return spreadArray;
    }
    @Override
    public String toString() {
        return "RespathFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", crop=" + crop +
                ", corners=" + corners +
                ", stroke=" + stroke +
                ", thick=" + thick +
                ", close=" + close +
                ", fill=" + fill +
                ", spread=" + spread +
                ", color=" + color +
                '}';
    }
}
