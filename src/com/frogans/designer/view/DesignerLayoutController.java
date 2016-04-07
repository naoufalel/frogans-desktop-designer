package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.Elements.*;
import com.frogans.designer.view.PropertiesLayout.FileLayoutController;
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
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;


/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class DesignerLayoutController {

    private final ObjectProperty<ListCell<String>> dragSource = new SimpleObjectProperty<>();
    TreeItem<Object> root = new TreeItem<>("frogans-fsdl");
    @FXML
    ListView<String> listControlers;
    @FXML
    Canvas testCanvas = new Canvas();
    @FXML
    TextField tf = new TextField();
    private FrogansApp frogansApp;
    @FXML
    private Accordion accordion;
    @FXML
    private TitledPane titledPane;
    @FXML
    private TitledPane propertiesPane;
    @FXML
    private TreeTableView<Object> treeTableHierarchy;
    @FXML
    private TreeTableColumn<Object, String> elementID;
    @FXML
    private TreeTableColumn<Object, String> elementType;
    private ObservableList<Object> temp = FXCollections.observableArrayList();
    private ObservableList<String> controlers = FXCollections.observableArrayList(
            "Button",
            "Textfield",
            "Layer"
    );

    public DesignerLayoutController() {

    }

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
        treeTableHierarchy.setRoot(createSubTree());
    }

    public TitledPane getPropertiesPane() {
        return propertiesPane;
    }

    public TreeTableView<Object> getTreeTableHierarchy() {
        return treeTableHierarchy;
    }

    public void setTreeTableHierarchy(TreeTableView<Object> treeTableHierarchy) {
        this.treeTableHierarchy = treeTableHierarchy;
    }

    @FXML
    public void initialize() {
        accordion.setExpandedPane(titledPane);
        someTest();
        elementID.setCellValueFactory((TreeTableColumn.CellDataFeatures<Object, String> p) -> {
            ReadOnlyStringWrapper a = showHierarchy(0, p);
            return a;
        });
        elementType.setCellValueFactory((TreeTableColumn.CellDataFeatures<Object, String> p) -> {
            ReadOnlyStringWrapper a = showHierarchy(1, p);
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
                LayerFSDL l = (LayerFSDL) o;
                controller.fillLayerLayout(
                        l.getLayerid(),
                        l.getLeapout(),
                        l.getResref(),
                        l.getFlip(),
                        l.getFilterref(),
                        l.getReliefref(),
                        l.getBlur(),
                        l.getOpacity(),
                        l.getAngle(),
                        l.getPos(),
                        l.getAlign(),
                        l.getCombine(),
                        l.getShadowref(),
                        l.getVisible()
                );
            } catch (Exception e1) {
                System.err.println("por favor.\n" + e1);
            }
        } else if (o instanceof FileFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/FileLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);

                FileLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                FileFSDL f = (FileFSDL) o ;
                controller.fillFileLayout(
                        f.getFileid(),
                        f.getNature(),
                        f.getName(),
                        f.getCache()
                );
            } catch (Exception e1) {
                System.err.println("tnin ltnin.\n" + e1);
            }
        } else System.out.println("hola");
    }

    private ReadOnlyStringWrapper showHierarchy(int i, TreeTableColumn.CellDataFeatures<Object, String> p) {
        ReadOnlyStringWrapper a = new ReadOnlyStringWrapper("");
        Object value = p.getValue().getValue();
        if (value instanceof LayerFSDL) {
            if (i == 0) {
                a.setValue(((LayerFSDL) value).getLayerid());
            } else {
                a.setValue("Layer");
            }

        } else if (value instanceof FileFSDL) {
            if (i == 0) {
                a.setValue(((FileFSDL) value).getFileid());
            } else {
                a.setValue("File");
            }
        } else if (value instanceof ResdrawFSDL) {
            if (i == 0) {
                a.setValue(((ResdrawFSDL) value).getResid());
            } else {
                a.setValue("Resdraw");
            }
        } else if (value instanceof SetreliefFSDL) {
            if (i == 0) {
                a.setValue(((SetreliefFSDL) value).getReliefid());
            } else {
                a.setValue("SetRelief");
            }
        } else if (value instanceof SetfontFSDL) {
            if (i == 0) {
                a.setValue(((SetfontFSDL) value).getFontid());
            } else {
                a.setValue("SetFont");
            }
        } else if (value instanceof RestextFSDL) {
            if (i == 0) {
                a.setValue(((RestextFSDL) value).getResid());
            } else {
                a.setValue("ResText");
            }
        } else if (value instanceof ResimageFSDL) {
            if (i == 0) {
                a.setValue(((ResimageFSDL) value).getResid());
            } else {
                a.setValue("Resimage");
            }
        } else if (value instanceof ButtonFSDL) {
            if (i == 0) {
                ((ButtonFSDL) value).getLayersButton().forEach(e -> {
                    TreeItem<Object> layerFSDLTreeItem = new TreeItem<>(e);
                    p.getValue().getChildren().add(layerFSDLTreeItem);
                });
                a.set(((ButtonFSDL) value).getButtonid());
            } else {
                a.setValue("Button");
            }
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
