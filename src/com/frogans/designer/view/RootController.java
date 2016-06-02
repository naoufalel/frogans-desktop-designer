package com.frogans.designer.view;

import com.frogans.designer.FrogansApp;
import com.frogans.designer.model.ToolException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;

import java.io.File;

/**
 *
 */
public class RootController {
    private FrogansApp frogansApp;


    public RootController() {

    }

    public void setFrogansApp(FrogansApp frogansApp) {
        this.frogansApp = frogansApp;
    }

    @FXML
    public void initialize() {

    }


    @FXML
    private void handleNew() {
        //TODO
    }

    @FXML
    private void handleOpen() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open FSDL File");
            FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                    "FSDL files(*.fsdl)", "*.fsdl"
            );

//            fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
//            );
            fileChooser.getExtensionFilters().add(extensionFilter);

            File file = fileChooser.showOpenDialog(frogansApp.getPrimaryStage());
            if (file != null) {
                // Make sure it has the correct extension
                if (!file.getPath().endsWith(".fsdl")) {
                    file = new File(file.getPath() + ".fsdl");
                }
                frogansApp.loadAFile(file);
            }

        } catch (ToolException e) {
            System.err.println(e);
        } catch (Exception e1) {
            System.err.println(e1);
        }

    }

    @FXML
    private void handleSave() {

    }

    @FXML
    private void handleSaveAs() {

    }

    /**
     * Shows about window
     */
    @FXML
    private void handleAbout() {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Frogans Designer");
        a.setHeaderText("About");
        a.setContentText("About this app goes here");

        a.showAndWait();
    }

    /**
     * Closes the application application
     */
    @FXML
    private void handleQuit() {
        System.exit(0);
    }

}
