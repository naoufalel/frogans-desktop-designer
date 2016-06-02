package com.frogans.designer;

import com.frogans.designer.model.FsdlParser;
import com.frogans.designer.model.ToolException;
import com.frogans.designer.view.DesignerLayoutController;
import com.frogans.designer.view.RootController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.prefs.Preferences;

/**
 * Main class that handles all the views and displays the app and starts plugins
 * <p>
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FrogansApp extends Application {

    FsdlParser fsdlParser;
    Timeline timeline;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Object> mainTags = FXCollections.observableArrayList();

    private Collection<String> messages = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    public Collection<String> getMessages() {
        return messages;
    }

    public void setMessages(Collection<String> messages) {
        this.messages = messages;
    }

    public ObservableList<Object> getMainTags() {
        return mainTags;
    }

    public void setMainTags(ObservableList<Object> mainTags) {
        this.mainTags = mainTags;
    }

    public FsdlParser getFsdlParser() {
        return fsdlParser;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Timeline getTimeline() {
        return timeline;
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
<<<<<<< HEAD
//        String filename = "C:\\Users\\naouf\\Downloads\\FrogansPlayer4Dev-noinstall-alpha0.15.1-win32\\test\\helloworld\\home.fsdl";
//        fsdlParser = new FsdlParser(new File(filename));
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Frogans Designer");
//        primaryStage.getIcons().add(new Image(FrogansApp.class.getResourceAsStream("/images/something.png")));

        initRootLayout();
        showSplitContainers();
=======
        String filename = "C:\\Users\\naouf\\Downloads\\FrogansPlayer4Dev-noinstall-alpha0.15.1-win32\\test\\helloworld\\home.fsdl";
        fsdlParser = new FsdlParser(new File(filename));
//        this.primaryStage = primaryStage;
//        primaryStage.setTitle("Frogans Designer");
//        primaryStage.getIcons().add(new Image(FrogansApp.class.getResourceAsStream("/images/something.png")));

//        initRootLayout();
//        showSplitContainers();
>>>>>>> d25af4a49e5d556d454272cc1aab378c2eb59d9f


    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
    * Showing root Layout with menu bar
    *
    * */
    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FrogansApp.class.getResource("view/Root.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootController controller = loader.getController();
            controller.setFrogansApp(this);

            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Problem in initRootLayout\n" + e);
        }


    }

    /**
     * Showing split anchors in the center of root
     */
    private void showSplitContainers() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FrogansApp.class.getResource("view/DesignerLayout.fxml"));
            AnchorPane anchorPane = loader.load();


            rootLayout.setCenter(anchorPane);

            DesignerLayoutController controller = loader.getController();
            controller.setFrogansApp(this);


            timeline = new Timeline(
                    new KeyFrame(
                            Duration.seconds(1),
                            new TreeLoadingEventHandler(controller)
                    )
            );
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setReminderFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(FrogansApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

        } else {
            prefs.remove("filePath");

        }
    }

    public void loadAFile(File file) throws ToolException {
        try {
            fsdlParser = new FsdlParser(file);
            fsdlParser.runFsdlLib();
            messages.add("Everything is OK. FSDL Lib OK, your file: " + file.getName() + " has no errors");
            mainTags = fsdlParser.finalParse();

            //setReminderFilePath(file);
            primaryStage.setTitle("Frogans Designer - " + file.getName());
            timeline.play();
        } catch (ToolException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Problem");
            alert.setHeaderText("Problem in opening a file");
            //alert.setContentText("There was a problem while opening " + file.getName() + ". Please check if the file exists");
            alert.setContentText(e.getMessage());

            alert.showAndWait();
            System.err.println("load a file.\n" + e);
        }
    }

    private class TreeLoadingEventHandler implements EventHandler<ActionEvent> {
        private DesignerLayoutController controller;

        TreeLoadingEventHandler(DesignerLayoutController controller) {
            this.controller = controller;
        }

        @Override
        public void handle(ActionEvent t) {
            if (!mainTags.isEmpty()) {
                controller.createSubTree();
                timeline.pause();
            }
        }
    }


}
