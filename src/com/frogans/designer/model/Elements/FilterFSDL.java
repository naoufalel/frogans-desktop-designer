package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Naoufal EL BANTLI on 29-Mar-16.
 */
public class FilterFSDL {
    private StringProperty effect;
    private StringProperty[] effectArray = {
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


    public FilterFSDL() {
        this.effect = new SimpleStringProperty("");
        this.level = new SimpleStringProperty("");
        this.angle = new SimpleStringProperty("");
        this.tolerance = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
    }

    public FilterFSDL(StringProperty effect,
                      StringProperty level,
                      StringProperty angle,
                      StringProperty tolerance,
                      StringProperty color) {
        this.effect = effect;
        this.level = level;
        this.angle = angle;
        this.tolerance = tolerance;
        this.color = color;
    }

    public String getEffect() {
        return effect.get();
    }

    public StringProperty effectProperty() {
        return effect;
    }

    public String getLevel() {
        return level.get();
    }

    public StringProperty levelProperty() {
        return level;
    }

    public String getAngle() {
        return angle.get();
    }

    public StringProperty angleProperty() {
        return angle;
    }

    public String getTolerance() {
        return tolerance.get();
    }

    public StringProperty toleranceProperty() {
        return tolerance;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public void seteffect(String effect) {
        this.effect.set(effect);
    }

    public void setlevel(String level) {
        this.level.set(level);
    }

    public void setangle(String angle) {
        this.angle.set(angle);
    }

    public void settolerance(String tolerance) {
        this.tolerance.set(tolerance);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }

    @Override
    public String toString() {
        return "FilterFSDL{" +
                "effect=" + effect +
                ", level=" + level +
                ", angle=" + angle +
                ", tolerance=" + tolerance +
                ", color=" + color +
                '}';
    }
}
