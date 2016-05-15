package com.frogans.designer.model.Elements;

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

    public RespixelsFSDL() {
        this.resid = new SimpleStringProperty("");
        this.size = new SimpleStringProperty("");
        this.columns = new SimpleStringProperty("");
        this.rows = new SimpleStringProperty("");
        this.pix = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
        this.alpha = new SimpleStringProperty("");
    }
    public RespixelsFSDL(StringProperty resid,
                         StringProperty size,
                         StringProperty columns,
                         StringProperty rows,
                         StringProperty pix,
                         StringProperty color,
                         StringProperty alpha) {
        this.resid = resid;
        this.size = size;
        this.columns = columns;
        this.rows = rows;
        this.pix = pix;
        this.color = color;
        this.alpha = alpha;
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

    public String getColumns() {
        return columns.get();
    }

    public StringProperty columnsProperty() {
        return columns;
    }

    public String getRows() {
        return rows.get();
    }

    public StringProperty rowsProperty() {
        return rows;
    }

    public String getPix() {
        return pix.get();
    }

    public StringProperty pixProperty() {
        return pix;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getAlpha() {
        return alpha.get();
    }

    public StringProperty alphaProperty() {
        return alpha;
    }

    public void setresid(String resid) {
        this.resid.set(resid);
    }

    public void setsize(String size) {
        this.size.set(size);
    }

    public void setcolumns(String columns) {
        this.columns.set(columns);
    }

    public void setrows(String rows) {
        this.rows.set(rows);
    }

    public void setpix(String pix) {
        this.pix.set(pix);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    public void setalpha(String alpha) {
        this.alpha.set(alpha);
    }

    public StringProperty[] getPixArray() {
        return pixArray;
    }
    @Override
    public String toString() {
        return "RespixelsFSDL{" +
                "resid=" + resid +
                ", size=" + size +
                ", columns=" + columns +
                ", rows=" + rows +
                ", pix=" + pix +
                ", color=" + color +
                ", alpha=" + alpha +
                '}';
    }
}
