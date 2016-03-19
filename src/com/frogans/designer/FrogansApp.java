package com.frogans.designer;

import com.frogans.designer.model.FsdlParser;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class that handles all the views and displays the app and starts plugins
 *
 * Created by Naoufal EL BANTLI on 3/19/2016.
 */
public class FrogansApp extends Application {

    private Stage primaryStage;
    private BorderPane borderPane;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
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
//        FsdlParser fsdlParser = new FsdlParser("C:\\Users\\naouf\\Downloads\\Frogans\\FrogansPlayer4Dev-noinstall-alpha0.7.1-win32\\test\\helloworld\\home.fsdl");
//        //fsdlParser.parseFileElement();
//        fsdlParser.parseFileXPath();

        this.primaryStage=primaryStage;


    }
}
