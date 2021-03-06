package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**  Thic class defines our ReliefFSDL element
 *
 */
public class ReliefFSDL {

    private StringProperty rpos;
    private StringProperty color;
    private StringProperty blur;
    private StringProperty opacity;

    public ReliefFSDL() {
        this.rpos = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
        this.blur = new SimpleStringProperty("");
        this.opacity = new SimpleStringProperty("");
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

    @Override
    public String toString() {
        return "ReliefFSDL{" +
                "rpos=" + rpos +
                ", color=" + color +
                ", blur=" + blur +
                ", opacity=" + opacity +
                '}';
    }
}
