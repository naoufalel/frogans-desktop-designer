package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import javafx.collections.ObservableList;
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

    public TreeView<String> getTreeHierarchy() {
        return treeHierarchy;
    }

    public void setTreeHierarchy(TreeView<String> treeHierarchy) {
        this.treeHierarchy = treeHierarchy;
    }

    private FrogansApp frogansApp;
    private ObservableList<TreeItem<String>> mainTree;


    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
//        TreeItem<String> root = new TreeItem<>("frogans-fsdl");
//        root.setExpanded(true);
//        //create children
//        frogansApp.getMainTree().forEach(e->{
//
//            root.getChildren().add(e);
//            e.setExpanded(false);
//            if(e.getValue().equals("button")){
//                e.setExpanded(true);
//                frogansApp.getButtonTree().forEach(a->{
//                    e.getChildren().add(a);
//                    a.setExpanded(false);
//                });
//            }
//
//        });
//
//        treeHierarchy.setRoot(root);

    }

    public DesignerLayoutController() {
    }

    @FXML
    public void initialize() {
        accordion.setExpandedPane(titledPane);

    }

    private void fileOpenedFromRoot() {

    }


}
