package com.frogans.designer.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class FontFSDL {

    private StringProperty scripts;
    private StringProperty pfont;
    private StringProperty height;
    private StringProperty spacing;
    private StringProperty stretching;
    private StringProperty xbold;
    private StringProperty xitalic;
    private StringProperty underline;
    private StringProperty[] underlineArray={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty strikeout;
    private StringProperty[]strikeoutArray={
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
            };
    private StringProperty opacity;
    private StringProperty color;

    @Override
    public String toString() {
        return "FontFSDL{" +
                "scripts=" + scripts +
                ", pfont=" + pfont +
                ", height=" + height +
                ", spacing=" + spacing +
                ", stretching=" + stretching +
                ", xbold=" + xbold +
                ", xitalic=" + xitalic +
                ", underlineValue=" + underlineValue +
                ", underline=" + Arrays.toString(underline) +
                ", strikeoutValue=" + strikeoutValue +
                ", strikeout=" + Arrays.toString(strikeout) +
                ", opacity=" + opacity +
                ", color=" + color +
                '}';
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

    public String getOpacity() {
        return opacity.get();
    }

    public StringProperty opacityProperty() {
        return opacity;
    }

    public void setopacity(String opacity) {
        this.opacity.set(opacity);
    }

    public StringProperty[] getStrikeout() {
        return strikeout;
    }

    public void setstrikeout(StringProperty[] strikeout) {
        this.strikeout = strikeout;
    }

    public String getStrikeoutValue() {
        return strikeoutValue.get();
    }

    public StringProperty strikeoutValueProperty() {
        return strikeoutValue;
    }

    public void setstrikeoutvalue(String strikeoutValue) {
        this.strikeoutValue.set(strikeoutValue);
    }

    public StringProperty[] getUnderline() {
        return underline;
    }

    public void setunderline(StringProperty[] underline) {
        this.underline = underline;
    }

    public String getUnderlineValue() {
        return underlineValue.get();
    }

    public StringProperty underlineValueProperty() {
        return underlineValue;
    }

    public void setunderlinevalue(String underlineValue) {
        this.underlineValue.set(underlineValue);
    }

    public String getXitalic() {
        return xitalic.get();
    }

    public StringProperty xitalicProperty() {
        return xitalic;
    }

    public void setxitalic(String xitalic) {
        this.xitalic.set(xitalic);
    }

    public String getXbold() {
        return xbold.get();
    }

    public StringProperty xboldProperty() {
        return xbold;
    }

    public void setxbold(String xbold) {
        this.xbold.set(xbold);
    }

    public String getStretching() {
        return stretching.get();
    }

    public StringProperty stretchingProperty() {
        return stretching;
    }

    public void setstretching(String stretching) {
        this.stretching.set(stretching);
    }

    public String getSpacing() {
        return spacing.get();
    }

    public StringProperty spacingProperty() {
        return spacing;
    }

    public void setspacing(String spacing) {
        this.spacing.set(spacing);
    }

    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public void setheight(String height) {
        this.height.set(height);
    }

    public String getPfont() {
        return pfont.get();
    }

    public StringProperty pfontProperty() {
        return pfont;
    }

    public void setpfont(String pfont) {
        this.pfont.set(pfont);
    }

    public String getScripts() {
        return scripts.get();
    }

    public StringProperty scriptsProperty() {
        return scripts;
    }

    public void setscripts(String scripts) {
        this.scripts.set(scripts);
    }

    public FontFSDL(StringProperty scripts,
                    StringProperty color,
                    StringProperty[] strikeout,
                    StringProperty opacity,
                    StringProperty strikeoutValue,
                    StringProperty xitalic,
                    StringProperty height,
                    StringProperty pfont,
                    StringProperty spacing,
                    StringProperty xbold,
                    StringProperty stretching,
                    StringProperty underlineValue,
                    StringProperty[] underline) {
        this.scripts = scripts;
        this.color = color;
        this.strikeout = strikeout;
        this.opacity = opacity;
        this.strikeoutValue = strikeoutValue;
        this.xitalic = xitalic;
        this.height = height;
        this.pfont = pfont;
        this.spacing = spacing;
        this.xbold = xbold;
        this.stretching = stretching;
        this.underlineValue = underlineValue;
        this.underline = underline;
    }
}
