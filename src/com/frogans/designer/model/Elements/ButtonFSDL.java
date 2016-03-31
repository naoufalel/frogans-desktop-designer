package com.frogans.designer.model.Elements;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

/**
 * Created by ABDELKABIR on 29/03/2016.
 */
public class ButtonFSDL {
    //mandatory shit
    private  StringProperty buttonid;

    private StringProperty go_toValue;
    private StringProperty[] go_to = {
        new SimpleStringProperty("slide"),
        new SimpleStringProperty("frogans-site"),
        new SimpleStringProperty("website"), // for future use.
        new SimpleStringProperty("email-message") //for future use.

    };


    // applicable if goto shit
    private StringProperty fileref; //goto =  slide

    private StringProperty address; //goto = frogans-site;

    private StringProperty url; //goto = website;

    private StringProperty email; //goto = email-message;


    //You should call contructor of layers when button (means has visible)
    private ObservableList<LayerFSDL> layersButton = FXCollections.observableArrayList();

    /**
     *Initial Constructor of Button
     */
    public ButtonFSDL(){
        this.buttonid = new SimpleStringProperty("");
        this.go_toValue = new SimpleStringProperty("");
        this.fileref = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.url = new SimpleStringProperty("");
        this.email = new SimpleStringProperty("");
    }

    /**
     * Constructor of Button to call when parsing or modifying the xml through the interface
     * @param buttonid
     * @param fileref
     * @param go_toValue
     * @param address
     * @param url
     * @param email
     */
    public ButtonFSDL(StringProperty buttonid,
                      StringProperty fileref,
                      StringProperty go_toValue,
                      StringProperty address,
                      StringProperty url,
                      StringProperty email
    ) {
        this.buttonid = buttonid;
        this.fileref = fileref;
        this.go_toValue = go_toValue;
        this.address = address;
        this.url = url;
        this.email = email;
    }

    public String getButtonid() {
        return buttonid.get();
    }

    public StringProperty buttonidProperty() {
        return buttonid;
    }

    public void setbuttonid(String buttonid) {
        this.buttonid.set(buttonid);
    }

    public String getGo_toValue() {
        return go_toValue.get();
    }

    public StringProperty go_toValueProperty() {
        return go_toValue;
    }

    public void setgo_to(String go_toValue) {
        this.go_toValue.set(go_toValue);
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

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setaddress(String address) {
        this.address.set(address);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void seturl(String url) {
        this.url.set(url);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setemail(String email) {
        this.email.set(email);
    }

    public ObservableList<LayerFSDL> getLayersButton() {
        return layersButton;
    }

    public void setLayersButton(ObservableList<LayerFSDL> layersButton) {
        this.layersButton = layersButton;
    }

    @Override
    public String toString() {
        return "ButtonFSDL{" +
                "buttonid=" + buttonid +
                ", go_toValue=" + go_toValue +
                ", fileref=" + fileref +
                ", address=" + address +
                ", url=" + url +
                ", email=" + email +
                ", layersButton=" + layersButton +
                '}';
    }
}
