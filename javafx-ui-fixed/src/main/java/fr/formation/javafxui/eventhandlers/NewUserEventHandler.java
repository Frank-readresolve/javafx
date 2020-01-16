package fr.formation.javafxui.eventhandlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class NewUserEventHandler implements EventHandler<ActionEvent> {

    private final BorderPane pane;

    public NewUserEventHandler(BorderPane pane) {
	this.pane = pane;
    }

    @Override
    public void handle(ActionEvent event) {
	GridPane grid = new GridPane();
	Text title = new Text("Create a new user");
	title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	grid.add(title, 0, 0, 2, 1);
	createTextField(grid, "First name:", 1);
	createTextField(grid, "Last name:", 2);
	createTextField(grid, "Email:", 3);
	createSaveButton(grid, "Save", 4);
	grid.setAlignment(Pos.CENTER);
	pane.setCenter(grid);
    }

    private static void createTextField(GridPane grid, String labelText,
	    int row) {
	Label label = new Label(labelText);
	grid.add(label, 0, row);
	TextField field = new TextField();
	grid.add(field, 1, row);
    }

    private static void createSaveButton(GridPane grid, String buttonText,
	    int row) {
	Button saveButton = new Button(buttonText);
	HBox buttonBox = new HBox(10);
	buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
	buttonBox.getChildren().add(saveButton);
	Text actiontarget = new Text();
	grid.add(actiontarget, 1, row + 1);
	saveButton.setOnAction(event -> {
	    actiontarget.setFill(Color.FIREBRICK);
	    actiontarget.setText("Saving...");
	});
	grid.add(buttonBox, 1, row);
    }
}
