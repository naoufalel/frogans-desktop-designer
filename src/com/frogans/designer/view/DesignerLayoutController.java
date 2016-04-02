package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.view.PropertiesLayout.LayerLayoutController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class DesignerLayoutController {

    private FrogansApp frogansApp;

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
        treeTableHierarchy.setRoot(createSubTree());
    }

    @FXML
    private Accordion accordion;
    @FXML
    private TitledPane titledPane;

    @FXML
    private TitledPane propertiesPane;

    public TitledPane getPropertiesPane() {
        return propertiesPane;
    }

    @FXML
    private TreeTableView<String> treeTableHierarchy;
    @FXML
    private TreeTableColumn<String, String> elementID;
    @FXML
    private TreeTableColumn<String, String> elementType;

    TreeItem<String> root = new TreeItem<>("frogans-fsdl");


    @FXML
    ListView<String> listControlers;

    @FXML
    Canvas testCanvas = new Canvas();

    @FXML
    TextField tf = new TextField();

    private final ObjectProperty<ListCell<String>> dragSource = new SimpleObjectProperty<>();

    private ObservableList<TreeItem<String>> temp = FXCollections.observableArrayList();

    private ObservableList<String> controlers = FXCollections.observableArrayList(
            "Button",
            "Textfield",
            "Layer"
    );

    public TreeTableView<String> getTreeHierarchy() {
        return treeTableHierarchy;
    }

    public void setTreeHierarchy(TreeTableView<String> treeHierarchy) {
        this.treeTableHierarchy = treeHierarchy;
    }

    public DesignerLayoutController() {

    }

    @FXML
    public void initialize() {
        accordion.setExpandedPane(titledPane);
        someTest();
        elementID.setCellValueFactory((TreeTableColumn.CellDataFeatures<String,String> p)-> new ReadOnlyStringWrapper(p.getValue().getValue().toString()));
        elementType.setCellValueFactory(p-> new ReadOnlyStringWrapper(p.getValue().getValue().toString()));

    }


    public TreeItem<String> createSubTree() {
        if (!root.getChildren().isEmpty()) {
            root.getChildren().removeAll(temp);
//            frogansApp.getMainTags().forEach(e -> {
//                root.getChildren().add(e);
//                e.setExpanded(false);
//            });
//            temp = frogansApp.getMainTags();
        } else {
            root.setExpanded(true);
            frogansApp.getMainTags().entrySet().forEach(e->{
                root.getChildren().add(new TreeItem<>(e.getKey()));
            });
//            frogansApp.getMainTags().forEach(e -> {
//                root.getChildren().add(e);
//                e.setExpanded(false);
//            });
//            temp = frogansApp.getMainTags();
        }

        return root;
    }


    private void someTest() {
        listControlers.setItems(controlers);
        listControlers.setCellFactory(param -> {
            ListCell<String> cell = new ListCell<String>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item);
                }

            };
            cell.setOnDragDetected(event -> {
                if (!cell.isEmpty()) {
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
}
