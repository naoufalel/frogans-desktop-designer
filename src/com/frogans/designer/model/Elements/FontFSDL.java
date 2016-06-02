package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Arrays;

/**  Thic class defines our FontFSDL element
 *
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
    private StringProperty[] underlineArray = {
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty strikeout;
    private StringProperty[] strikeoutArray = {
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };
    private StringProperty opacity;
    private StringProperty color;

    public FontFSDL() {
        this.scripts = new SimpleStringProperty("");
        this.pfont = new SimpleStringProperty("");
        this.height = new SimpleStringProperty("");
        this.spacing = new SimpleStringProperty("");
        this.stretching = new SimpleStringProperty("");
        this.xbold = new SimpleStringProperty("");
        this.xitalic = new SimpleStringProperty("");
        this.underline = new SimpleStringProperty("");
        this.strikeout = new SimpleStringProperty("");
        this.opacity = new SimpleStringProperty("");
        this.color = new SimpleStringProperty("");
    }

    public FontFSDL(StringProperty scripts,
                    StringProperty pfont,
                    StringProperty height,
                    StringProperty spacing,
                    StringProperty stretching,
                    StringProperty xbold,
                    StringProperty xitalic,
                    StringProperty underline,
                    StringProperty strikeout,
                    StringProperty opacity,
                    StringProperty color) {
        this.scripts = scripts;
        this.pfont = pfont;
        this.height = height;
        this.spacing = spacing;
        this.stretching = stretching;
        this.xbold = xbold;
        this.xitalic = xitalic;
        this.underline = underline;
        this.strikeout = strikeout;
        this.opacity = opacity;
        this.color = color;
    }

    public String getScripts() {
        return scripts.get();
    }

    public StringProperty scriptsProperty() {
        return scripts;
    }

    public String getPfont() {
        return pfont.get();
    }

    public StringProperty pfontProperty() {
        return pfont;
    }

    public String getHeight() {
        return height.get();
    }

    public StringProperty heightProperty() {
        return height;
    }

    public String getSpacing() {
        return spacing.get();
    }

    public StringProperty spacingProperty() {
        return spacing;
    }

    public String getStretching() {
        return stretching.get();
    }

    public StringProperty stretchingProperty() {
        return stretching;
    }

    public String getXbold() {
        return xbold.get();
    }

    public StringProperty xboldProperty() {
        return xbold;
    }

    public String getXitalic() {
        return xitalic.get();
    }

    public StringProperty xitalicProperty() {
        return xitalic;
    }

    public String getUnderline() {
        return underline.get();
    }

    public StringProperty underlineProperty() {
        return underline;
    }

    public String getStrikeout() {
        return strikeout.get();
    }

    public StringProperty strikeoutProperty() {
        return strikeout;
    }

    public String getColor() {
        return color.get();
    }

    public StringProperty colorProperty() {
        return color;
    }

    public String getOpacity() {
        return opacity.get();
    }

    public StringProperty opacityProperty() {
        return opacity;
    }

    public void setscripts(String scripts) {
        this.scripts.set(scripts);
    }

    public void setpfont(String pfont) {
        this.pfont.set(pfont);
    }

    public void setheight(String height) {
        this.height.set(height);
    }

    public void setspacing(String spacing) {
        this.spacing.set(spacing);
    }

    public void setstretching(String stretching) {
        this.stretching.set(stretching);
    }

    public void setxbold(String xbold) {
        this.xbold.set(xbold);
    }

    public void setxitalic(String xitalic) {
        this.xitalic.set(xitalic);
    }

    public void setunderline(String underline) {
        this.underline.set(underline);
    }

    public void setstrikeout(String strikeout) {
        this.strikeout.set(strikeout);
    }

    public void setopacity(String opacity) {
        this.opacity.set(opacity);
    }

    public void setcolor(String color) {
        this.color.set(color);
    }


    public StringProperty[] getUnderlineArray() {
        return underlineArray;
    }
    public StringProperty[] getStrikeoutArray() {
        return strikeoutArray;
    }
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
                ", underline=" + underline +
                ", strikeout=" + strikeout +
                ", opacity=" + opacity +
                ", color=" + color +
                '}';
    }
}
