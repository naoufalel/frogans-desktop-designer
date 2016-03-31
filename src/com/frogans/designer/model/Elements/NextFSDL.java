package com.frogans.designer.model;

import javafx.beans.property.StringProperty;

/**
 * Created by Aladdin on 29-Mar-16.
 */
public class NextFSDL {

    private StringProperty delay;
    private StringProperty fileref;

    public NextFSDL(StringProperty delay,
                    StringProperty fileref) {
        this.delay = delay;
        this.fileref = fileref;
    }

    @Override
    public String toString() {
        return "NextFSDL{" +
                "delay=" + delay +
                ", fileref=" + fileref +
                '}';
    }

    public String getDelay() {
        return delay.get();
    }

    public StringProperty delayProperty() {
        return delay;
    }

    public void setdelay(String delay) {
        this.delay.set(delay);
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
}
