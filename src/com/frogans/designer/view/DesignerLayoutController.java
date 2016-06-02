package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.DragAndResizeAndMove;
import com.frogans.designer.model.Elements.*;
import com.frogans.designer.view.PropertiesLayout.*;
import javafx.animation.FadeTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;


/**
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class DesignerLayoutController {

    private final ObjectProperty<ListCell<String>> dragSource = new SimpleObjectProperty<>();
    TreeItem<Object> root = new TreeItem<>("frogans-fsdl");
    @FXML
    ListView<String> listControlers;
    @FXML
    ListView<String> listShapes;
    @FXML
    Pane testPane = new Pane();
    @FXML
    TextField tf = new TextField();

    GraphicsContext gc;
    double width;
    double height;
    @FXML
    AnchorPane anchorPaneForMessagesAbove;

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
    @FXML
    private Slider testSlider;
    @FXML
    private Label showingValidParseMessages;

    @FXML
    ImageView leadImageView;

    private ObservableList<Object> temp = FXCollections.observableArrayList();
    private ObservableList<String> controlers = FXCollections.observableArrayList(
            "Button",
            "ResText",
            "Layer",
            "Resimage"
    );

    private ObservableList<String> shapes = FXCollections.observableArrayList(
            "Rectangle",
            "Circle"
    );

    private FadeTransition fadeTransition = new FadeTransition(Duration.millis(6000));

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

//        gc = testCanvas.getGraphicsContext2D();
        //gc.fillRect(80, 50, 20, 40);

//        testSlider.setMax(500);
//        testSlider.setMin(20);
//        testSlider.setMinorTickCount(10);
//        showingValidParseMessages.setText("20");
//        sliderListening();
//        updateCanvas();

        treeTableHierarchy.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int i = treeTableHierarchy.getSelectionModel().getSelectedIndex();
            TreeItem<Object> a = treeTableHierarchy.getSelectionModel().getModelItem(i);
            showPropertiesFor(a.getValue());
        });

    }


//    private void sliderListening() {
//        testSlider.valueProperty().addListener(((observable, oldValue, newValue) -> {
//            testCanvas.setWidth(newValue.intValue());
//            updateCanvas();
//            showingValidParseMessages.setText(Integer.toString(newValue.intValue()));
//        }));
//    }
//
//    private void updateCanvas() {
//        width = testCanvas.getWidth();
//        height = testCanvas.getHeight();
//        gc.clearRect(0, 0, width, height);
//        gc.setStroke(Color.BLACK);
//        gc.strokeRect(1, 1, width - 2, height - 2);
//    }

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
                FileFSDL f = (FileFSDL) o;
                controller.fillFileLayout(
                        f.getFileid(),
                        f.getNature(),
                        f.getName(),
                        f.getCache()
                );
            } catch (Exception e1) {
                System.err.println("tnin ltnin.\n" + e1);
            }
        } else if (o instanceof MergeFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/MergeLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);

                MergeLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                MergeFSDL l = (MergeFSDL) o;
                controller.fillMergeLayout(
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
                        l.getShadowref()
                );
            } catch (Exception e1) {
                System.err.println("tnin ltnin.\n" + e1);
            }
        } else if (o instanceof ButtonFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ButtonLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ButtonLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ButtonFSDL l = (ButtonFSDL) o;
                controller.fillButtonLayout(
                        l.getButtonid(),
                        l.getFileref(),
                        l.getGo_toValue(),
                        l.getAddress(),
                        l.getUrl(),
                        l.getEmail()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof FilterFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/FilterLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                FilterLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                FilterFSDL l = (FilterFSDL) o;
                controller.fillFilterLayout(
                        l.getEffect(),
                        l.getLevel(),
                        l.getAngle(),
                        l.getTolerance(),
                        l.getColor()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof FontFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/FontLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                FontLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                FontFSDL l = (FontFSDL) o;
                controller.fillFontLayout(
                        l.getScripts(),
                        l.getPfont(),
                        l.getHeight(),
                        l.getSpacing(),
                        l.getStretching(),
                        l.getXbold(),
                        l.getXitalic(),
                        l.getUnderline(),
                        l.getStrikeout(),
                        l.getOpacity(),
                        l.getColor()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof ResdrawFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ResdrawLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ResdrawLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ResdrawFSDL l = (ResdrawFSDL) o;
                controller.fillResdrawLayout(
                        l.getResid(),
                        l.getSize(),
                        l.getFigure(),
                        l.getStroke(),
                        l.getThick(),
                        l.getRound(),
                        l.getColor()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof SetreliefFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/SetreliefLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                SetreliefLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                SetreliefFSDL l = (SetreliefFSDL) o;
                controller.fillSetreliefLayout(
                        l.getReliefid()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof ResimageFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ResimageLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ResimageLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ResimageFSDL l = (ResimageFSDL) o;
                controller.fillResimageLayout(
                        l.getResid(),
                        l.getSize(),
                        l.getFileref(),
                        l.getSelection(),
                        l.getBounds(),
                        l.getAspect(),
                        l.getAdjust(),
                        l.getOrigin()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (o instanceof RestextFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/RestextLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                RestextLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                RestextFSDL l = (RestextFSDL) o;
                controller.fillRestextLayout(
                        l.getResid(),
                        l.getSize(),
                        l.getFontref(),
                        l.getTalign(),
                        l.getLinespace(),
                        l.getVstyle(),
                        l.getOrientation()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof RespathFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/RespathLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                RespathLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                RespathFSDL l = (RespathFSDL) o;
                controller.fillRespathLayout(
                        l.getResid(),
                        l.getSize(),
                        l.getCrop(),
                        l.getCorners(),
                        l.getStroke(),
                        l.getThick(),
                        l.getClose(),
                        l.getFill(),
                        l.getColor(),
                        l.getSpread()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof ResmergeFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ResmergeLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ResmergeLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ResmergeFSDL l = (ResmergeFSDL) o;
                controller.fillResmergeLayout(
                        l.getResid(),
                        l.getSize()
                );

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof SetfilterFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/SetfilerLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                SetfilterLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                SetfilterFSDL l = (SetfilterFSDL) o;
                controller.fillSetfilterLayout(
                        l.getFilterid()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof ReliefFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ReliefLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ReliefLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ReliefFSDL l = (ReliefFSDL) o;
                controller.fillReliefLayout(
                        l.getRpos(),
                        l.getColor(),
                        l.getBlur(),
                        l.getOpacity()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof NextFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/NextLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                NextLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                NextFSDL l = (NextFSDL) o;
                controller.fillNextLayout(
                        l.getDelay(),
                        l.getFileref()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof RespixelsFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/RespixelsLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                RespixelsLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                RespixelsFSDL l = (RespixelsFSDL) o;
                controller.fillRespixelsLayout(
                        l.getResid(),
                        l.getSize(),
                        l.getColumns(),
                        l.getRows(),
                        l.getPix(),
                        l.getColor(),
                        l.getAlpha()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof SetfontFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/SetfontLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                SetfontLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                SetfontFSDL l = (SetfontFSDL) o;
                controller.fillSetfontLayout(
                        l.getFontid()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof TextFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/TextLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                TextLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                TextFSDL l = (TextFSDL) o;
                controller.fillTextLayout(
                        l.getFontref(),
                        l.getTalign(),
                        l.getLinespace(),
                        l.getVstyle(),
                        l.getJoin()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof ShadowFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ShadowLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ShadowLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                ShadowFSDL l = (ShadowFSDL) o;
                controller.fillShadowLayout(
                        l.getRpos(),
                        l.getColor(),
                        l.getBlur(),
                        l.getOpacity(),
                        l.getCombine()
                );
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (o instanceof SetshadowFSDL) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(FrogansApp.class.getResource("view/PropertiesLayout/ShadowidLayout.fxml"));
                AnchorPane anchorPane = loader.load();

                this.getPropertiesPane().setContent(anchorPane);
                ShadowidLayoutController controller = loader.getController();
                controller.setFrogansApp(frogansApp);
                SetshadowFSDL l = (SetshadowFSDL) o;
                controller.fillShadowidLayout(
                        l.getShadowid()
                );
            } catch (IOException e) {
                e.printStackTrace();
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
        } else if (value instanceof ResmergeFSDL) {
            if (i == 0) {
                a.setValue(((ResmergeFSDL) value).getResid());
            } else {
                a.setValue("Resmerge");
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
        } else if (value instanceof SetshadowFSDL) {
            if (i == 0) {
                a.setValue(((SetshadowFSDL) value).getShadowid());
            } else {
                a.setValue("Setshadow");
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
            showMessagesInBottomLabel();
        } else {
            root.setExpanded(true);
            frogansApp.getMainTags().forEach(e -> {
                root.getChildren().add(new TreeItem<>(e));
            });
            temp = frogansApp.getMainTags();
            showMessagesInBottomLabel();
        }

        return root;
    }

    public void drawLead(){
        try {
            Image image = SwingFXUtils.toFXImage(this.frogansApp.getFsdlParser().showRenderedLead(), null);
            leadImageView.setImage(image);
            //leadImageView.setFitHeight(500);
            leadImageView.setFitWidth(50);
        } catch (Exception e) {
            System.err.println("yep.\n"+e);
        }
    }

    private void showMessagesInBottomLabel() {
        this.frogansApp.getMessages().stream().forEach(e -> {
            showingValidParseMessages.setText(e);
        });
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


        listShapes.setItems(shapes);

        listShapes.setCellFactory(param -> {
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
                //this.frogansApp.getPrimaryStage().getScene().setCursor(Cursor.CLOSED_HAND);
                Dragboard db = event.getDragboard();
                if (db.hasString()) {
                    event.acceptTransferModes(TransferMode.ANY);
                }
            });
//            cell.setOnDragDone(event -> System.out.println(event.getX()));
            cell.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasString() && dragSource.get() != null) {
                    // in this example you could just do
                    // listView.getItems().add(db.getString());
                    // but more generally:

                    String dragSourceCell = dragSource.getName();

//                    //tf.setText(dragSourceCell);

                    event.setDropCompleted(true);
                    dragSource.set(null);
                } else {
                    event.setDropCompleted(false);
                }
            });


            return cell;
        });

        testPane.addEventHandler(
                DragEvent.DRAG_OVER,
                event -> {
                    if (event.getDragboard().hasString()) {
                        event.acceptTransferModes(TransferMode.COPY);
                    }
                    event.consume();
                });


        testPane.addEventHandler(
                DragEvent.DRAG_DROPPED,
                event -> {
                    Dragboard dragboard = event.getDragboard();
                    if (event.getTransferMode() == TransferMode.COPY &&
                            dragboard.hasString()) {
//                        tf.setText(dragboard.getString());
                        if (dragboard.getString().equals("Rectangle")) {
                            Rectangle rect = new Rectangle();
                            rect.setHeight(100);
                            rect.setWidth(100);
                            rect.setFill(Color.BLACK);
                            rect.addEventHandler(MouseEvent.MOUSE_ENTERED, event1 -> {
                                System.out.println(rect.getWidth());
                            });
                            DragAndResizeAndMove.makeResizable(rect, null);
                            testPane.getChildren().add(rect);
                        } else {
                            System.out.println("TFOOOOOOOOOOOO");
                        }

//                        gc.fillRect(event.getX(),event.getY(),50,50);
//                        Button button = new Button(dragboard.toString());

                        event.setDropCompleted(true);
                    }
                    event.consume();
                }
        );
    }
}
