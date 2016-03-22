package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

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

    TreeItem<String> root = new TreeItem<>("frogans-fsdl");

    private ObservableList<TreeItem<String>> temp = FXCollections.observableArrayList();

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
        treeHierarchy.setRoot(createSubTree());
    }

    public DesignerLayoutController() {
    }

    @FXML
    public void initialize() {
        accordion.setExpandedPane(titledPane);
    }

    public TreeItem<String> createSubTree() {
        if (!root.getChildren().isEmpty()) {
            root.getChildren().removeAll(temp);
            frogansApp.getMainTags().forEach(e -> {
                root.getChildren().add(e);
                e.setExpanded(false);
            });
            temp = frogansApp.getMainTags();
        } else {
            root.setExpanded(true);
            frogansApp.getMainTags().forEach(e -> {
                root.getChildren().add(e);
                e.setExpanded(false);
            });
            temp = frogansApp.getMainTags();
        }
        return root;
    }


}
