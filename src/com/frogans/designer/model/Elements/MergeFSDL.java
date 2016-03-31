package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class MergeFSDL {

    private StringProperty resref;
    private StringProperty flip;
    private StringProperty[] flipArray={
            new SimpleStringProperty("none"),
            new SimpleStringProperty("xdir"),
            new SimpleStringProperty("ydir"),
            new SimpleStringProperty("xydir")
    };
    private StringProperty filterref;
    private StringProperty reliefref;
    private StringProperty blur;
    private StringProperty opacity;
    private StringProperty angle;
    private StringProperty pos;
    private StringProperty align;
    private StringProperty[] alignArray={
            new SimpleStringProperty("left-top"),
            new SimpleStringProperty("left-middle"),
            new SimpleStringProperty("left-bottom"),
            new SimpleStringProperty("center-top"),
            new SimpleStringProperty("center-middle"),
            new SimpleStringProperty("center-bottom"),
            new SimpleStringProperty("right-top"),
            new SimpleStringProperty("right-middle"),
            new SimpleStringProperty("right-bottom")
    };
    private StringProperty combine;
    private StringProperty[] combineArray={
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };
    private StringProperty shadowref;

    @Override
    public String toString() {
        return "MergeFSDL{" +
                "resref=" + resref +
                ", flipValue=" + flipValue +
                ", flip=" + Arrays.toString(flip) +
                ", filterref=" + filterref +
                ", reliefref=" + reliefref +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", angle=" + angle +
                ", pos=" + pos +
                ", alignValue=" + alignValue +
                ", align=" + Arrays.toString(align) +
                ", combineValue=" + combineValue +
                ", combine=" + Arrays.toString(combine) +
                ", shadowref=" + shadowref +
                '}';
    }

    public String getResref() {
        return resref.get();
    }

    public StringProperty resrefProperty() {
        return resref;
    }

    public void setresref(String resref) {
        this.resref.set(resref);
    }

    public String getFlipValue() {
        return flipValue.get();
    }

    public StringProperty flipValueProperty() {
        return flipValue;
    }

    public void setflipvalue(String flipValue) {
        this.flipValue.set(flipValue);
    }

    public StringProperty[] getFlip() {
        return flip;
    }

    public void setflip(StringProperty[] flip) {
        this.flip = flip;
    }

    public String getFilterref() {
        return filterref.get();
    }

    public StringProperty filterrefProperty() {
        return filterref;
    }

    public void setfilterref(String filterref) {
        this.filterref.set(filterref);
    }

    public String getReliefref() {
        return reliefref.get();
    }

    public StringProperty reliefrefProperty() {
        return reliefref;
    }

    public void setreliefref(String reliefref) {
        this.reliefref.set(reliefref);
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

    public String getAngle() {
        return angle.get();
    }

    public StringProperty angleProperty() {
        return angle;
    }

    public void setangle(String angle) {
        this.angle.set(angle);
    }

    public String getPos() {
        return pos.get();
    }

    public StringProperty posProperty() {
        return pos;
    }

    public void setpos(String pos) {
        this.pos.set(pos);
    }

    public String getAlignValue() {
        return alignValue.get();
    }

    public StringProperty alignValueProperty() {
        return alignValue;
    }

    public void setalignvalue(String alignValue) {
        this.alignValue.set(alignValue);
    }

    public StringProperty[] getAlign() {
        return align;
    }

    public void setalign(StringProperty[] align) {
        this.align = align;
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

    public String getShadowref() {
        return shadowref.get();
    }

    public StringProperty shadowrefProperty() {
        return shadowref;
    }

    public void setshadowref(String shadowref) {
        this.shadowref.set(shadowref);
    }

    public MergeFSDL(StringProperty resref,
                     StringProperty flipValue,
                     StringProperty[] flip,
                     StringProperty filterref,
                     StringProperty reliefref,
                     StringProperty blur,
                     StringProperty opacity,
                     StringProperty angle,
                     StringProperty pos,
                     StringProperty alignValue,
                     StringProperty[] align,
                     StringProperty combineValue,
                     StringProperty[] combine,
                     StringProperty shadowref) {
        this.resref = resref;
        this.flipValue = flipValue;
        this.flip = flip;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.alignValue = alignValue;
        this.align = align;
        this.combineValue = combineValue;
        this.combine = combine;
        this.shadowref = shadowref;
    }
}
