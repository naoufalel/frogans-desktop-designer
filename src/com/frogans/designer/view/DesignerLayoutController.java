package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
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
    @FXML
    ListView<String> listControlers;
    @FXML
    Canvas testCanvas = new Canvas();
    @FXML
    TextField tf = new TextField();

    TreeItem<String> root = new TreeItem<>("frogans-fsdl");

    private ObservableList<TreeItem<String>> temp = FXCollections.observableArrayList();
    private ObservableList<String> controlers = FXCollections.observableArrayList(
            "Button",
            "Textfield",
            "Layer"
    );

    private final ObjectProperty<ListCell<String>> dragSource = new SimpleObjectProperty<>();

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
        listControlers.setItems(controlers);
        listControlers.setCellFactory(param -> {
            ListCell<String> cell = new ListCell<String>(){
                @Override
                public void updateItem(String item , boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }

            };
            cell.setOnDragDetected(event -> {
                if(!cell.isEmpty()){
                    Dragboard db = cell.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent cc = new ClipboardContent();
                    cc.putString(cell.getItem());
                    db.setContent(cc);
                    dragSource.set(cell);
                }
            });
            cell.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasString()) {
                    event.acceptTransferModes(TransferMode.ANY);
                }
            });
            cell.setOnDragDone(event -> System.out.println(event.getX()));
//            cell.setOnDragDropped(event -> {
//                Dragboard db = event.getDragboard();
//                if (db.hasString() && dragSource.get() != null) {
//                    // in this example you could just do
//                    // listView.getItems().add(db.getString());
//                    // but more generally:
//
////                    String dragSourceCell = dragSource.getName();
////                    //tf.setText(dragSourceCell);
//                    event.setDropCompleted(true);
//                    dragSource.set(null);
//                } else {
//                    event.setDropCompleted(false);
//                }
//            });


            return cell;
        });
        testCanvas.addEventHandler(
                DragEvent.DRAG_OVER,
                event -> {
                    if (event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY);
                    }
                    event.consume();
                });

        testCanvas.addEventHandler(
                DragEvent.DRAG_DROPPED,
                event -> {
                    Dragboard dragboard = event.getDragboard();
                    if (event.getTransferMode() == TransferMode.COPY &&
                            dragboard.hasString()) {
//                        tf.setText(dragboard.getString());
                        Button button = new Button(dragboard.toString());

                        event.setDropCompleted(true);
                    }
                    event.consume();
                }
        );

        tf.addEventHandler(
                DragEvent.DRAG_OVER,
                event -> {
                    if (event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY);
                    }
                    event.consume();
                });
        tf.addEventHandler(
                DragEvent.DRAG_DROPPED,
                event -> {
                    Dragboard dragboard = event.getDragboard();
                    if (event.getTransferMode() == TransferMode.COPY &&
                            dragboard.hasString()) {
                        tf.setText(dragboard.getString());
                        event.setDropCompleted(true);
                    }
                    event.consume();
                });

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
