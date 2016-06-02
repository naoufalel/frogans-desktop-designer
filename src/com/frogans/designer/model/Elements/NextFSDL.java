package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**  Thic class defines our NextFSDL element
 *
 */
public class NextFSDL {

    private StringProperty delay;
    private StringProperty fileref;

    public NextFSDL() {
        this.delay = new SimpleStringProperty("");
        this.fileref = new SimpleStringProperty("");
    }
    public NextFSDL(StringProperty delay,
                    StringProperty fileref) {
        this.delay = delay;
        this.fileref = fileref;
    }

    public String getDelay() {
        return delay.get();
    }

    public StringProperty delayProperty() {
        return delay;
    }

    public String getFileref() {
        return fileref.get();
    }

    public StringProperty filerefProperty() {
        return fileref;
    }

    public void setfileref(String fileref) {
        this.fileref.set(fileref);
    }

    public void setdelay(String delay) {
        this.delay.set(delay);
    }

    @Override
    public String toString() {
        return "NextFSDL{" +
                "delay=" + delay +
                ", fileref=" + fileref +
                '}';
    }
}
