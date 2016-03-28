package com.frogans.designer.model.Elements;

import com.sun.xml.internal.ws.server.ServerRtException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naoufal EL BANTLI on 3/27/2016.
 */
public class LayerFSDL {

    // Mandatory shit
    private StringProperty layerid;

    private StringProperty leapoutValue;

    private StringProperty combineValue;

    private StringProperty combineButtonValue;


    private StringProperty[] leapout = {
            new SimpleStringProperty("all"),
            new SimpleStringProperty("lead"),
            new SimpleStringProperty("vigentte")
    };
    private StringProperty resref;

    private StringProperty pos;

    private StringProperty[] combine = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };
    private StringProperty[] combineButton = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };


    // Optional shit
    private StringProperty flipValue;
    private StringProperty[] flip = {
            new SimpleStringProperty("none"),
            new SimpleStringProperty("xdir"),
            new SimpleStringProperty("ydir"),
            new SimpleStringProperty("xydir")};

    private StringProperty filterref;

    private StringProperty reliefref;
    private StringProperty blur;
    private StringProperty opacity;

    private StringProperty angle;

    private StringProperty alignValue;
    private StringProperty[] align = {
            new SimpleStringProperty("left-top"),
            new SimpleStringProperty("left-middle"),
            new SimpleStringProperty("left-bottom"),
            new SimpleStringProperty("center-top"),
            new SimpleStringProperty("center-middle"),
            new SimpleStringProperty("center-bottom"),
            new SimpleStringProperty("right-top"),
            new SimpleStringProperty("right-middle"),
            new SimpleStringProperty("right-bottom"),
    };


    private StringProperty shadowref;


    // Mandatory and optional shit
    private StringProperty visibleValue;
    private StringProperty[] visible = {
            new SimpleStringProperty("always"),
            new SimpleStringProperty("nofocus"),
            new SimpleStringProperty("focus")
    };


    public LayerFSDL(){
        this.layerid = new SimpleStringProperty("");
        this.leapoutValue = new SimpleStringProperty("");
        this.resref = new SimpleStringProperty("");
        this.flipValue = new SimpleStringProperty("");
        this.filterref = new SimpleStringProperty("");
        this.reliefref = new SimpleStringProperty("");
        this.blur = new SimpleStringProperty("");
        this.opacity = new SimpleStringProperty("");
        this.angle = new SimpleStringProperty("");
        this.pos = new SimpleStringProperty("");
        this.alignValue = new SimpleStringProperty("");
        this.combineValue = new SimpleStringProperty("");
        this.shadowref = new SimpleStringProperty("");

    }

    /**
     * Constructor when layer is not child of button
     *
     * @param layerid
     * @param leapoutValue
     * @param resref
     * @param flipValue
     * @param filterref
     * @param reliefref
     * @param blur
     * @param opacity
     * @param angle
     * @param pos
     * @param alignValue
     * @param combineValue
     * @param shadowref
     */

    public LayerFSDL(StringProperty layerid,
                     StringProperty leapoutValue,
                     StringProperty resref,
                     StringProperty flipValue,
                     StringProperty filterref,
                     StringProperty reliefref,
                     StringProperty blur,
                     StringProperty opacity,
                     StringProperty angle,
                     StringProperty pos,
                     StringProperty alignValue,
                     StringProperty combineValue,
                     StringProperty shadowref
    ) {
        this.layerid = layerid;
        this.leapoutValue = leapoutValue;
        this.resref = resref;
        this.flipValue = flipValue;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.alignValue = alignValue;
        this.combineValue = combineValue;
        this.shadowref = shadowref;

    }

    /**
     * Constructor when layer child of button
     *
     * @param layerid
     * @param leapoutValue
     * @param resref
     * @param flipValue
     * @param filterref
     * @param reliefref
     * @param blur
     * @param opacity
     * @param angle
     * @param pos
     * @param alignValue
     * @param combineButtonValue
     * @param shadowref
     * @param visibleValue
     */
    public LayerFSDL(StringProperty layerid,
                     StringProperty leapoutValue,
                     StringProperty resref,
                     StringProperty flipValue,
                     StringProperty filterref,
                     StringProperty reliefref,
                     StringProperty blur,
                     StringProperty opacity,
                     StringProperty angle,
                     StringProperty pos,
                     StringProperty alignValue,
                     StringProperty combineButtonValue,
                     StringProperty shadowref,
                     StringProperty visibleValue
    ) {
        this.layerid = layerid;
        this.leapoutValue = leapoutValue;
        this.resref = resref;
        this.flipValue = flipValue;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.alignValue = alignValue;
        this.combineButtonValue = combineButtonValue;
        this.shadowref = shadowref;
        this.visibleValue = visibleValue;
    }

    public String getLayerid() {
        return layerid.get();
    }

    public StringProperty layeridProperty() {
        return layerid;
    }

    public void setlayerid(String layerid) {
        this.layerid.set(layerid);
    }

    public String getLeapoutValue() {
        return leapoutValue.get();
    }

    public StringProperty leapoutValueProperty() {
        return leapoutValue;
    }

    public void setleapout(String leapoutValue) {
        this.leapoutValue.set(leapoutValue);
    }

    public String getCombineValue() {
        return combineValue.get();
    }

    public StringProperty combineValueProperty() {
        return combineValue;
    }

    public void setcombine(String combineValue) {
        this.combineValue.set(combineValue);
    }

    public String getCombineButtonValue() {
        return combineButtonValue.get();
    }

    public StringProperty combineButtonValueProperty() {
        return combineButtonValue;
    }

    public void setCombineButton(String combineButtonValue) {
        this.combineButtonValue.set(combineButtonValue);
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

    public String getPos() {
        return pos.get();
    }

    public StringProperty posProperty() {
        return pos;
    }

    public void setpos(String pos) {
        this.pos.set(pos);
    }

    public String getFlipValue() {
        return flipValue.get();
    }

    public StringProperty flipValueProperty() {
        return flipValue;
    }

    public void setflip(String flipValue) {
        this.flipValue.set(flipValue);
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

    public String getAlignValue() {
        return alignValue.get();
    }

    public StringProperty alignValueProperty() {
        return alignValue;
    }

    public void setalign(String alignValue) {
        this.alignValue.set(alignValue);
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

    public String getVisibleValue() {
        return visibleValue.get();
    }

    public StringProperty visibleValueProperty() {
        return visibleValue;
    }

    public void setVisibleValue(String visibleValue) {
        this.visibleValue.set(visibleValue);
    }

    @Override
    public String toString() {
        return "LayerFSDL{" +
                "layerid=" + layerid +
                ", leapoutValue=" + leapoutValue +
                ", combineValue=" + combineValue +
                ", leapout=" + Arrays.toString(leapout) +
                ", resref=" + resref +
                ", pos=" + pos +
                ", combine=" + Arrays.toString(combine) +
                ", combineButton=" + Arrays.toString(combineButton) +
                ", flipValue=" + flipValue +
                ", flip=" + Arrays.toString(flip) +
                ", filterref=" + filterref +
                ", reliefref=" + reliefref +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", angle=" + angle +
                ", alignValue=" + alignValue +
                ", align=" + Arrays.toString(align) +
                ", shadowref=" + shadowref +
                ", visibleValue=" + visibleValue +
                '}';
    }
}
