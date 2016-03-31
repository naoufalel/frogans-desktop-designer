package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class ShadowFSDL {

    private StringProperty rpos;
    private StringProperty color;
    private StringProperty blur;
    private StringProperty opacity;
    private StringProperty combine;
    private StringProperty[] combineArray={
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };

    @Override
    public String toString() {
        return "ShadowFSDL{" +
                "rpos=" + rpos +
                ", color=" + color +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", combineValue=" + combineValue +
                ", combine=" + Arrays.toString(combine) +
                '}';
    }

    public String getRpos() {
        return rpos.get();
    }

    public StringProperty rposProperty() {
        return rpos;
    }

    public void setrpos(String rpos) {
        this.rpos.set(rpos);
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

    public String getBlur() {
        return blur.get();
    }

    public StringProperty blurProperty() {
        return blur;
    }

    public void setblur(String blur) {
        this.blur.set(blur);
    }

    public String getOpacity() {
        return opacity.get();
    }

    public StringProperty opacityProperty() {
        return opacity;
    }

    public void setopacity(String opacity) {
        this.opacity.set(opacity);
    }

    public String getCombineValue() {
        return combineValue.get();
    }

    public StringProperty combineValueProperty() {
        return combineValue;
    }

    public void setcombinevalue(String combineValue) {
        this.combineValue.set(combineValue);
    }

    public StringProperty[] getCombine() {
        return combine;
    }

    public void setcombine(StringProperty[] combine) {
        this.combine = combine;
    }

    public ShadowFSDL(StringProperty rpos,
                      StringProperty color,
                      StringProperty blur,
                      StringProperty opacity,
                      StringProperty combineValue,
                      StringProperty[] combine) {
        this.rpos = rpos;
        this.color = color;
        this.blur = blur;
        this.opacity = opacity;
        this.combineValue = combineValue;
        this.combine = combine;
    }
}
