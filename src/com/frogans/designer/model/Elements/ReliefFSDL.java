package com.frogans.designer.model;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class ReliefFSDL {

    private StringProperty rpos;
    private StringProperty color;
    private StringProperty blur;
    private StringProperty opacity;

    @Override
    public String toString() {
        return "ReliefFSDL{" +
                "rpos=" + rpos +
                ", color=" + color +
                ", blur=" + blur +
                ", opacity=" + opacity +
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

    public ReliefFSDL(StringProperty rpos,
                      StringProperty color,
                      StringProperty blur,
                      StringProperty opacity) {
        this.rpos = rpos;
        this.color = color;
        this.blur = blur;
        this.opacity = opacity;
    }
}
