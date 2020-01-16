package fr.formation.javafxui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxApplication extends Application {

    @Override
    public void init() throws Exception {
	System.out.println("Initializing application...");
	super.init();
	// Do something
	System.out.println("Application initialized");
    }

    @Override
    public void start(Stage stage) {
	System.out.println("Starting application...");
	stage.setTitle("JavaFX Application");
	SceneBuilder builder = new SceneBuilder();
	Scene scene = builder.build();
	stage.setScene(scene);
	stage.setMaximized(true);
	stage.show();
	System.out.println("Application started...");
    }

    @Override
    public void stop() throws Exception {
	System.out.println("Stopping application...");
	super.stop();
	// Do something
	System.out.println("Application stopped");
    }

    public static void main(String[] args) {
	System.out.println("Invoking main method...");
	launch();
	System.out.println("Exiting main method...");
    }
}
