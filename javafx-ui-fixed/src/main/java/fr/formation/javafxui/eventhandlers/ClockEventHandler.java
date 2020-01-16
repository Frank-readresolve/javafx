package fr.formation.javafxui.eventhandlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ClockEventHandler implements EventHandler<ActionEvent> {

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter
	    .ofPattern("HH:mm:ss");

    private final Label clock;

    public ClockEventHandler(Label clock) {
	this.clock = clock;
    }

    @Override
    public void handle(ActionEvent event) {
	LocalDateTime now = LocalDateTime.now();
	clock.setText("Clock: " + now.format(FORMATTER));
    }
}
