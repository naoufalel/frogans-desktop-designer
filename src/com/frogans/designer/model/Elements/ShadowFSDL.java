package com.frogans.designer.model.Elements;

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

    public ShadowFSDL() {
        this.rpos = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
        this.blur = new SimpleStringProperty("");
        this.opacity = new SimpleStringProperty("");
        this.combine = new SimpleStringProperty("");
    }
    public ShadowFSDL(StringProperty rpos,
                      StringProperty color,
                      StringProperty blur,
                      StringProperty opacity,
                      StringProperty combine) {
        this.rpos = rpos;
        this.color = color;
        this.blur = blur;
        this.opacity = opacity;
        this.combine = combine;
    }


    public String getRpos() {
        return rpos.get();
    }

    public StringProperty rposProperty() {
        return rpos;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getBlur() {
        return blur.get();
    }

    public StringProperty blurProperty() {
        return blur;
    }

    public String getOpacity() {
        return opacity.get();
    }

    public StringProperty opacityProperty() {
        return opacity;
    }

    public String getCombine() {
        return combine.get();
    }

    public StringProperty combineProperty() {
        return combine;
    }

    public void setrpos(String rpos) {
        this.rpos.set(rpos);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    public void setblur(String blur) {
        this.blur.set(blur);
    }

    public void setopacity(String opacity) {
        this.opacity.set(opacity);
    }

    public void setcombine(String combine) {
        this.combine.set(combine);
    }

    public StringProperty[] getCombineArray() {
        return combineArray;
    }

    @Override
    public String toString() {
        return "ShadowFSDL{" +
                "rpos=" + rpos +
                ", color=" + color +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", combine=" + combine +
                '}';
    }
}
