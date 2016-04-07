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

    private StringProperty leapout;

    private StringProperty combine;

    private StringProperty combineButton;



    private StringProperty[] leapoutArray = {
            new SimpleStringProperty("all"),
            new SimpleStringProperty("lead"),
            new SimpleStringProperty("vignette")
    };
    private StringProperty resref;

    private StringProperty pos;

    private StringProperty[] combineArray = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };
    private StringProperty[] combineButtonArray = {
            new SimpleStringProperty("add"),
            new SimpleStringProperty("clip"),
            new SimpleStringProperty("cutout"),
            new SimpleStringProperty("inter")
    };


    // Optional shit
    private StringProperty flip;
    private StringProperty[] flipArray = {
            new SimpleStringProperty("none"),
            new SimpleStringProperty("xdir"),
            new SimpleStringProperty("ydir"),
            new SimpleStringProperty("xydir")};

    private StringProperty filterref;

    private StringProperty reliefref;
    private StringProperty blur;
    private StringProperty opacity;

    private StringProperty angle;

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
            new SimpleStringProperty("right-bottom"),
    };


    private StringProperty shadowref;


    // Mandatory and optional shit
    private StringProperty visible;
    private StringProperty[] visibleArray = {
            new SimpleStringProperty("always"),
            new SimpleStringProperty("nofocus"),
            new SimpleStringProperty("focus")
    };


    public LayerFSDL(){
        this.layerid = new SimpleStringProperty("");
        this.leapout = new SimpleStringProperty("");
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
        this.combineButton = new SimpleStringProperty("");
        this.visible = new SimpleStringProperty("");
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
        this.leapout = leapoutValue;
        this.resref = resref;
        this.flip = flipValue;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.align = alignValue;
        this.combine = combineValue;
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
        this.leapout = leapoutValue;
        this.resref = resref;
        this.flip = flipValue;
        this.filterref = filterref;
        this.reliefref = reliefref;
        this.blur = blur;
        this.opacity = opacity;
        this.angle = angle;
        this.pos = pos;
        this.align = alignValue;
        this.combineButton = combineButtonValue;
        this.shadowref = shadowref;
        this.visible = visibleValue;
    }

    public String getLayerid() {
        return layerid.get();
    }

    public StringProperty layeridProperty() {
        return layerid;
    }

    public String getLeapout() {
        return leapout.get();
    }

    public StringProperty leapoutProperty() {
        return leapout;
    }

    public String getCombine() {
        return combine.get();
    }

    public StringProperty combineProperty() {
        return combine;
    }

    public String getCombineButton() {
        return combineButton.get();
    }

    public StringProperty combineButtonProperty() {
        return combineButton;
    }

    public String getResref() {
        return resref.get();
    }

    public StringProperty resrefProperty() {
        return resref;
    }

    public String getPos() {
        return pos.get();
    }

    public StringProperty posProperty() {
        return pos;
    }

    public String getFlip() {
        return flip.get();
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

    public String getAlign() {
        return align.get();
    }

    public StringProperty alignProperty() {
        return align;
    }

    public String getShadowref() {
        return shadowref.get();
    }

    public StringProperty shadowrefProperty() {
        return shadowref;
    }

    public String getVisible() {
        return visible.get();
    }

    public StringProperty visibleProperty() {
        return visible;
    }


    public void setlayerid(String layerid) {
        this.layerid.set(layerid);
    }

    public void setleapout(String leapout) {
        this.leapout.set(leapout);
    }

    public void setcombine(String combine) {
        this.combine.set(combine);
    }

    public void setcombineButton(String combineButton) {
        this.combineButton.set(combineButton);
    }

    public void setresref(String resref) {
        this.resref.set(resref);
    }

    public void setpos(String pos) {
        this.pos.set(pos);
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

    public void setalign(String align) {
        this.align.set(align);
    }

    public void setshadowref(String shadowref) {
        this.shadowref.set(shadowref);
    }

    public void setvisible(String visible) {
        this.visible.set(visible);
    }

    @Override
    public String toString() {
        return "LayerFSDL{" +
                "layerid=" + layerid +
                ", leapout=" + leapout +
                ", combine=" + combine +
                ", combineButton=" + combineButton +
                ", resref=" + resref +
                ", pos=" + pos +
                ", flip=" + flip +
                ", filterref=" + filterref +
                ", reliefref=" + reliefref +
                ", blur=" + blur +
                ", opacity=" + opacity +
                ", angle=" + angle +
                ", align=" + align +
                ", shadowref=" + shadowref +
                ", visible=" + visible +
                '}';
    }


    public StringProperty[] getLeapoutArray() {
        return leapoutArray;
    }

    public void setLeapoutArray(StringProperty[] leapoutArray) {
        this.leapoutArray = leapoutArray;
    }

    public StringProperty[] getCombineArray() {
        return combineArray;
    }

    public void setCombineArray(StringProperty[] combineArray) {
        this.combineArray = combineArray;
    }

    public StringProperty[] getCombineButtonArray() {
        return combineButtonArray;
    }

    public void setCombineButtonArray(StringProperty[] combineButtonArray) {
        this.combineButtonArray = combineButtonArray;
    }

    public StringProperty[] getFlipArray() {
        return flipArray;
    }

    public void setFlipArray(StringProperty[] flipArray) {
        this.flipArray = flipArray;
    }

    public StringProperty[] getAlignArray() {
        return alignArray;
    }

    public void setAlignArray(StringProperty[] alignArray) {
        this.alignArray = alignArray;
    }

    public StringProperty[] getVisibleArray() {
        return visibleArray;
    }

    public void setVisibleArray(StringProperty[] visibleArray) {
        this.visibleArray = visibleArray;
    }
}
