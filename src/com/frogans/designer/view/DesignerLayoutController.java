package com.frogans.designer.view;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.TitledPane;

/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class DesignerLayoutController {

    @FXML
    private Accordion accordion;
    @FXML
    private TitledPane titledPane;




    public DesignerLayoutController(){

    }

    @FXML
    public void initialize(){
        accordion.setExpandedPane(titledPane);

    }




}
