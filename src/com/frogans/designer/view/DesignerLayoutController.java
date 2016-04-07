package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.*;
import com.frogans.designer.view.PropertiesLayout.FileLayoutController;
import com.frogans.designer.view.PropertiesLayout.LayerLayoutController;
import javafx.beans.property.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;


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
    private TreeTableView<Object> treeTableHierarchy;
    @FXML
    private TreeTableColumn<Object, String> elementID;
    @FXML
    private TreeTableColumn<Object, String> elementType;

    TreeItem<Object> root = new TreeItem<>("frogans-fsdl");


    @FXML
    ListView<String> listControlers;

    @FXML
    Canvas testCanvas = new Canvas();

    @FXML
    TextField tf = new TextField();

    public TreeTableView<Object> getTreeTableHierarchy() {
        return treeTableHierarchy;
    }

    public void setTreeTableHierarchy(TreeTableView<Object> treeTableHierarchy) {
        this.treeTableHierarchy = treeTableHierarchy;
    }

    private final ObjectProperty<ListCell<String>> dragSource = new SimpleObjectProperty<>();

    private ObservableList<Object> temp = FXCollections.observableArrayList();

    private ObservableList<String> controlers = FXCollections.observableArrayList(
            "Button",
            "Textfield",
            "Layer"
    );

    public DesignerLayoutController() {

    }

    @FXML
    public void initialize() {
        accordion.setExpandedPane(titledPane);
        someTest();
        elementID.setCellValueFactory((TreeTableColumn.CellDataFeatures<Object, String> p) -> {
            ReadOnlyStringWrapper a = showHierarchy(p);
            return a;
        });
        elementType.setCellValueFactory((TreeTableColumn.CellDataFeatures<Object, String> p) -> {
            ReadOnlyStringWrapper a = new ReadOnlyStringWrapper("");
            return a;
        });

        treeTableHierarchy.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int i = treeTableHierarchy.getSelectionModel().getSelectedIndex();
            TreeItem<Object> a = treeTableHierarchy.getSelectionModel().getModelItem(i);
            showPropertiesFor(a.getValue());
        });

    }

    private void showPropertiesFor(Object o) {
        if (o instanceof LayerFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/LayerLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);

                LayerLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                controller.getIdText().setText(((LayerFSDL) o).getLayerid());

                controller.getLeapoutChoice().setValue(((LayerFSDL) o).getLeapout());
            } catch (Exception e1) {
                System.err.println("mloiuyhg.\n" + e1);
            }
        } else if (o instanceof FileFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/FileLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);

                FileLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
            } catch (Exception e1) {
                System.err.println("ppppp.\n" + e1);
            }
        } else System.out.println("hola");
    }

    private ReadOnlyStringWrapper showHierarchy(TreeTableColumn.CellDataFeatures<Object, String> p) {
        ReadOnlyStringWrapper a = new ReadOnlyStringWrapper("");
        Object value = p.getValue().getValue();
        if (value instanceof LayerFSDL) {
            a.setValue(((LayerFSDL) value).getLayerid());
        } else if (value instanceof FileFSDL) {
            a.setValue(((FileFSDL) value).getFileid());
        } else if (value instanceof ResdrawFSDL) {
            a.setValue(((ResdrawFSDL) value).getResid());
        } else if (value instanceof SetreliefFSDL) {
            a.setValue(((SetreliefFSDL) value).getReliefid());
        } else if (value instanceof SetfontFSDL) {
            a.setValue(((SetfontFSDL) value).getFontid());
        } else if (value instanceof RestextFSDL) {
            a.setValue(((RestextFSDL) value).getResid());
        } else if (value instanceof ResimageFSDL) {
            a.setValue(((ResimageFSDL) value).getResid());
        } else if (value instanceof ButtonFSDL) {
            ((ButtonFSDL) value).getLayersButton().forEach(e -> {
                p.getValue().getChildren().add(new TreeItem<>(e));
            });
            a = new ReadOnlyStringWrapper(((ButtonFSDL) value).getButtonid());
        } else a = new ReadOnlyStringWrapper(value.toString());
        return a;
    }


    public TreeItem<Object> createSubTree() {
        if (!root.getChildren().isEmpty()) {
            root.getChildren().removeAll(temp);
            frogansApp.getMainTags().forEach(e -> {
                root.getChildren().add(new TreeItem<>(e));
                //e.setExpanded(false);
            });
            temp = frogansApp.getMainTags();
        } else {
            root.setExpanded(true);
            frogansApp.getMainTags().forEach(e -> {
                root.getChildren().add(new TreeItem<>(e));
            });
            temp = frogansApp.getMainTags();
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
