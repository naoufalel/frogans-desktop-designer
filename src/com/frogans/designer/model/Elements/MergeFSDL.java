package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Naoufal EL BANTLI on 29-Mar-16.
 */
public class MergeFSDL {

    private StringProperty resref;
    private StringProperty flip;
    private StringProperty[] flipArray = {
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
    private StringProperty[] alignArray = {
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
    private StringProperty[] combineArray = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };
    private StringProperty shadowref;


    public MergeFSDL() {
        this.resref = new SimpleStringProperty("");
        this.flip = new SimpleStringProperty("");
        this.filterref = new SimpleStringProperty("");
        this.reliefref = new SimpleStringProperty("");
        this.blur = new SimpleStringProperty("");
        this.opacity = new SimpleStringProperty("");
        this.angle = new SimpleStringProperty("");
        this.pos = new SimpleStringProperty("");
        this.align = new SimpleStringProperty("");
        this.combine = new SimpleStringProperty("");
        this.shadowref = new SimpleStringProperty("");
    }

    public MergeFSDL(StringProperty resref,
                     StringProperty flip,
                     StringProperty filterref,
                     StringProperty reliefref,
                     StringProperty blur,
                     StringProperty opacity,
                     StringProperty angle,
                     StringProperty pos,
                     StringProperty align,
                     StringProperty combine,
                     StringProperty shadowref) {
        this.resref = resref;
        this.flip = flip;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.align = align;
        this.combine = combine;
        this.shadowref = shadowref;
    }

    public String getResref() {
        return resref.get();
    }

    public StringProperty resrefProperty() {
        return resref;
    }

    public String getFlip() {
        return flip.get();
    }

    public StringProperty[] getFlipArray() {
        return flipArray;
    }

    public StringProperty[] getAlignArray() {
        return alignArray;
    }

    public StringProperty[] getCombineArray() {
        return combineArray;
    }

    public StringProperty flipProperty() {
        return flip;
    }

    public String getFilterref() {
        return filterref.get();
    }

    public StringProperty filterrefProperty() {
        return filterref;
    }

    public String getReliefref() {
        return reliefref.get();
    }

    public StringProperty reliefrefProperty() {
        return reliefref;
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

    public String getAngle() {
        return angle.get();
    }

    public StringProperty angleProperty() {
        return angle;
    }

    public String getPos() {
        return pos.get();
    }

    public StringProperty posProperty() {
        return pos;
    }

    public String getAlign() {
        return align.get();
    }

    public StringProperty alignProperty() {
        return align;
    }

    public String getCombine() {
        return combine.get();
    }

    public StringProperty combineProperty() {
        return combine;
    }

    public String getShadowref() {
        return shadowref.get();
    }



    public StringProperty shadowrefProperty() {
        return shadowref;
    }

    public void setresref(String resref) {
        this.resref.set(resref);
    }

    public void setflip(String flip) {
        this.flip.set(flip);
    }

    public void setfilterref(String filterref) {
        this.filterref.set(filterref);
    }

    public void setreliefref(String reliefref) {
        this.reliefref.set(reliefref);
    }

    public void setblur(String blur) {
        this.blur.set(blur);
    }

    public void setopacity(String opacity) {
        this.opacity.set(opacity);
    }

    public void setangle(String angle) {
        this.angle.set(angle);
    }

    public void setpos(String pos) {
        this.pos.set(pos);
    }

    public void setalign(String align) {
        this.align.set(align);
    }

    public void setcombine(String combine) {
        this.combine.set(combine);
    }

    public void setshadowref(String shadowref) {
        this.shadowref.set(shadowref);
    }



    @Override
    public String toString() {
        return "MergeFSDL{" +
                "resref=" + resref +
                ", flip=" + flip +
                ", filterref=" + filterref +
                ", reliefref=" + reliefref +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", angle=" + angle +
                ", pos=" + pos +
                ", align=" + align +
                ", combine=" + combine +
                ", shadowref=" + shadowref +
                '}';
    }
}
