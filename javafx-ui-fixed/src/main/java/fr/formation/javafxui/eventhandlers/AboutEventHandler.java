package fr.formation.javafxui.eventhandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AboutEventHandler implements EventHandler<ActionEvent> {

    private static final String FX_VERSION = System
	    .getProperty("javafx.version");

    private static final String JAVA_VERSION = System
	    .getProperty("java.version");

    @Override
    public void handle(ActionEvent event) {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setHeaderText(null);
	alert.setTitle("About this application...");
	alert.setContentText("JavaFX version: " + FX_VERSION
		+ ", running on Java " + JAVA_VERSION);
	alert.showAndWait();
    }
}
