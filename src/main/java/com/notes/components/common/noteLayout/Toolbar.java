package com.notes.components.common.noteLayout;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import static com.notes.util.Resources.getResource;

/**
 * Component used instead of default OS top bar
 */
public class Toolbar extends HBox {

    private final Stage stage;

    public Toolbar(Stage stage, String title){
        super();
        this.stage = stage;
        this.getStyleClass().add("toolbar");
        this.setAlignment(Pos.CENTER);
        Region icon = new Region();
        icon.getStyleClass().addAll("icon","app-icon");
        Label titleField = new Label(title);
        titleField.getStyleClass().add("title-field");
        titleField.setTextAlignment(TextAlignment.CENTER);
        Region spacer1 = new Region();
        spacer1.setStyle("-fx-max-width: 5;-fx-min-width: 5;");
        Region spacer2 = new Region();
        HBox.setHgrow(spacer2, Priority.ALWAYS);
        this.getChildren().addAll(spacer1,icon,titleField,spacer2,createMinimizeButton(),createFullscreenButton(),createCloseButton());
        this.getStylesheets().add(getResource("/com/notes/styles/Toolbar/Icon.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/Toolbar/Buttons.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/Toolbar/TitleField.css"));
    }

    private Button createCloseButton(){
        Button close = new Button();
        close.getStyleClass().addAll("button","close-button");
        close.setOnMouseClicked((event -> stage.close()));
        Region icon = new Region();
        icon.getStyleClass().addAll("icon","close-icon");
        close.setGraphic(icon);
        return close;
    }
    private Button createMinimizeButton(){
        Button minimize = new Button();
        minimize.getStyleClass().addAll("button","minimize-button");
        minimize.setOnMouseClicked(event -> stage.setIconified(true));
        Region icon = new Region();
        icon.getStyleClass().addAll("icon","minimize-icon");
        minimize.setGraphic(icon);
        return minimize;
    }

    private Button createFullscreenButton(){
        Button fullscreen = new Button();
        fullscreen.getStyleClass().addAll("button","fullscreen-button");
        Region icon = new Region();
        fullscreen.setOnMouseClicked((event -> {
            stage.setMaximized(!stage.isMaximized());
            if(stage.isMaximized()){
                icon.getStyleClass().retainAll("icon");
                icon.getStyleClass().add("maximize-down-icon");
            }
            else{
                icon.getStyleClass().retainAll("icon");
                icon.getStyleClass().add("maximize-up-icon");
            }
        }));
        icon.getStyleClass().addAll("icon","maximize-up-icon");
        fullscreen.setGraphic(icon);
        return fullscreen;
    }
}
