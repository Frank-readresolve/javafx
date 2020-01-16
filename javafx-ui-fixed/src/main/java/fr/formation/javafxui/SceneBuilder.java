package fr.formation.javafxui;

import fr.formation.javafxui.eventhandlers.AboutEventHandler;
import fr.formation.javafxui.eventhandlers.ClockEventHandler;
import fr.formation.javafxui.eventhandlers.NewUserEventHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class SceneBuilder {

    private final BorderPane pane = new BorderPane();

    private final static double WIDTH = 800;

    private final static double HEIGHT = 800;

    public SceneBuilder() {
	// Empty
    }

    public Scene build() {
	MenuBar menuBar = buildMenuBar();
	HBox statusBar = buildStatusBar();
	pane.setTop(menuBar);
	pane.setBottom(statusBar);
	return new Scene(pane, WIDTH, HEIGHT);
    }

    private MenuBar buildMenuBar() {
	MenuBar menuBar = new MenuBar();
	Menu fileMenu = buildFileMenu();
	Menu helpMenu = buildHelpMenu();
	menuBar.getMenus().addAll(fileMenu, helpMenu);
	return menuBar;
    }

    private Menu buildFileMenu() {
	Menu menu = new Menu("File");
	MenuItem exit = new MenuItem("Exit");
	exit.setOnAction(e -> Platform.exit());
	MenuItem newUser = new MenuItem("New user...");
	newUser.setOnAction(new NewUserEventHandler(pane));
	menu.getItems().addAll(newUser, exit);
	return menu;
    }

    private static Menu buildHelpMenu() {
	Menu menu = new Menu("Help");
	MenuItem about = new MenuItem("About...");
	about.setOnAction(new AboutEventHandler());
	menu.getItems().addAll(about);
	return menu;
    }

    private static HBox buildStatusBar() {
	HBox statusbar = new HBox();
	Label label = buildClock();
	statusbar.getChildren().addAll(label);
	return statusbar;
    }

    private static Label buildClock() {
	Label clock = new Label();
	Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1),
		new ClockEventHandler(clock)));
	timeline.setCycleCount(Animation.INDEFINITE);
	timeline.play();
	return clock;
    }
}
