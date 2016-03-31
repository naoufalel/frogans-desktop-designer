package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class FilterFSDL {
    private StringProperty effect;
    private StringProperty[]effectArray={
            new SimpleStringProperty("light"),
            new SimpleStringProperty("contrast"),
            new SimpleStringProperty("saturation"),
            new SimpleStringProperty("hue"),
            new SimpleStringProperty("solarize"),
            new SimpleStringProperty("addcolor"),
            new SimpleStringProperty("mixcolor"),
            new SimpleStringProperty("negative"),
            new SimpleStringProperty("lumakey"),
            new SimpleStringProperty("chromakey"),
            new SimpleStringProperty("lumatoalpha"),
            new SimpleStringProperty("alphatoluma")
    };
    private StringProperty level;
    private StringProperty angle;
    private StringProperty tolerance;
    private StringProperty color;

    @Override
    public String toString() {
        return "FilterFSDL{" +
                "effectValue=" + effectValue +
                ", effect=" + Arrays.toString(effect) +
                ", level=" + level +
                ", angle=" + angle +
                ", tolerance=" + tolerance +
                ", color=" + color +
                '}';
    }

    public String getEffectValue() {
        return effectValue.get();
    }

    public StringProperty effectValueProperty() {
        return effectValue;
    }

    public void seteffectvalue(String effectValue) {
        this.effectValue.set(effectValue);
    }

    public StringProperty[] getEffect() {
        return effect;
    }

    public void seteffect(StringProperty[] effect) {
        this.effect = effect;
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public void setlevel(String level) {
        this.level.set(level);
    }

    public String getAngle() {
        return angle.get();
    }

    public StringProperty angleProperty() {
        return angle;
    }

    public void setangle(String angle) {
        this.angle.set(angle);
    }

    public String getTolerance() {
        return tolerance.get();
    }

    public StringProperty toleranceProperty() {
        return tolerance;
    }

    public void settolerance(String tolerance) {
        this.tolerance.set(tolerance);
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

    public FilterFSDL(StringProperty effectValue,
                      StringProperty[] effect,
                      StringProperty level,
                      StringProperty angle,
                      StringProperty tolerance,
                      StringProperty color) {
        this.effectValue = effectValue;
        this.effect = effect;
        this.level = level;
        this.angle = angle;
        this.tolerance = tolerance;
        this.color = color;
    }
}
