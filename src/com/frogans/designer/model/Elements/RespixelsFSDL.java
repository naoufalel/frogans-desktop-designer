package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class RespixelsFSDL {

    private StringProperty resid;
    private StringProperty size;
    private StringProperty columns;
    private StringProperty rows;
    private StringProperty pix;
    private StringProperty[] pixArray={
            new SimpleStringProperty("rgba"),
            new SimpleStringProperty("rgb"),
            new SimpleStringProperty("a"),
            new SimpleStringProperty("y"),
            new SimpleStringProperty("ya")
    };
    private StringProperty color;
    private StringProperty alpha;

    public RespixelsFSDL(StringProperty color,
                         StringProperty alpha,
                         StringProperty[] pix,
                         StringProperty pixValue,
                         StringProperty rows,
                         StringProperty columns,
                         StringProperty size,
                         StringProperty resid) {
        this.color = color;
        this.alpha = alpha;
        this.pix = pix;
        this.pixValue = pixValue;
        this.rows = rows;
        this.columns = columns;
        this.size = size;
        this.resid = resid;
    }

    @Override
    public String toString() {
        return "RespixelsFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", columns=" + columns +
                ", rows=" + rows +
                ", pixValue=" + pixValue +
                ", pix=" + Arrays.toString(pix) +
                ", color=" + color +
                ", alpha=" + alpha +
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

    public String getAlpha() {
        return alpha.get();
    }

    public StringProperty alphaProperty() {
        return alpha;
    }

    public void setalpha(String alpha) {
        this.alpha.set(alpha);
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

    public StringProperty[] getPix() {
        return pix;
    }

    public void setpix(StringProperty[] pix) {
        this.pix = pix;
    }

    public String getPixValue() {
        return pixValue.get();
    }

    public StringProperty pixValueProperty() {
        return pixValue;
    }

    public void setpixvalue(String pixValue) {
        this.pixValue.set(pixValue);
    }

    public String getRows() {
        return rows.get();
    }

    public StringProperty rowsProperty() {
        return rows;
    }

    public void setrows(String rows) {
        this.rows.set(rows);
    }

    public String getColumns() {
        return columns.get();
    }

    public StringProperty columnsProperty() {
        return columns;
    }

    public void setcolumns(String columns) {
        this.columns.set(columns);
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
