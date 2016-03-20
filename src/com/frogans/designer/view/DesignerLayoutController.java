package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class DesignerLayoutController {

    @FXML
    private Accordion accordion;
    @FXML
    private TitledPane titledPane;
    @FXML
    TreeView<String> treeHierarchy;


    private FrogansApp frogansApp;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    public DesignerLayoutController(){


    }

    @FXML
    public void initialize(){
        TreeItem<String> root = new TreeItem<>("frogans-fsdl");
        root.setExpanded(true);
        //create child
        TreeItem<String> itemChild = new TreeItem<>("resdraw");
        root.getChildren().add(itemChild);
        itemChild.setExpanded(false);
        itemChild = new TreeItem<>("layer");

        //root is the parent of itemChild
        root.getChildren().add(itemChild);
        treeHierarchy.setRoot(root);

    }




}
