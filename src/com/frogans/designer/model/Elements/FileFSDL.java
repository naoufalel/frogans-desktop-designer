package com.frogans.designer.model.Elements;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by ABDELKABIR on 29/03/2016.
 */
public class FileFSDL {
    // Mandatory shit
    private StringProperty fileid;

    private StringProperty nature;
    private StringProperty[] natureArray = {
            new SimpleStringProperty("static"),
            new SimpleStringProperty("dynamic"),
            new SimpleStringProperty("embedded")
    };

    private StringProperty name;

    private StringProperty cache;
    private StringProperty[] cacheArray = {
            new SimpleStringProperty("on"),
            new SimpleStringProperty("off")
    };

    public FileFSDL() {
        this.fileid = new SimpleStringProperty("");
        this.nature = new SimpleStringProperty("");
        this.name = new SimpleStringProperty("");
        this.cache = new SimpleStringProperty("");
    }

    public FileFSDL(StringProperty fileid, StringProperty nature, StringProperty name, StringProperty cache) {
        this.fileid = fileid;
        this.nature = nature;
        this.name = name;
        this.cache = cache;

    }


    public String getFileid() {
        return fileid.get();
    }

    public StringProperty fileidProperty() {
        return fileid;
    }

    public String getNature() {
        return nature.get();
    }

    public StringProperty natureProperty() {
        return nature;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getCache() {
        return cache.get();
    }

    public StringProperty cacheProperty() {
        return cache;
    }


    public void setfileid(String fileid) {
        this.fileid.set(fileid);
    }

    public void setnature(String nature) {
        this.nature.set(nature);
    }

    public void setname(String name) {
        if(this.nature.get().equals("embedded"))
            name="";
        this.name.set(name);
    }

    public void setcache(String cache) {
        if(cache.equals(""))
            cache = "off";
        this.cache.set(cache);
    }


    public StringProperty[] getNatureArray() {
        return natureArray;
    }

    public StringProperty[] getCacheArray() {
        return cacheArray;
    }

    @Override
    public String toString() {
        return "FileFSDL{" +
                "fileid=" + fileid +
                ", nature=" + nature +
                ", name=" + name +
                ", cache=" + cache +
                '}';
    }
}
