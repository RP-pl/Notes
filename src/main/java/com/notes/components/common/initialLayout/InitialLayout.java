package com.notes.components.common.initialLayout;

import com.notes.components.common.handlers.InitialOpenHandler;
import com.notes.components.common.noteLayout.Toolbar;
import com.notes.components.common.handlers.LayoutNoteChanger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.notes.util.Resources.getResource;

/**
 * This layout is used when there is no note open
 */
public class InitialLayout extends VBox {

    private final Stage stage;

    public InitialLayout(Stage stage){
        super();
        this.stage = stage;
        Toolbar t = new Toolbar(stage,"Notes");
        t.maxWidthProperty().bind(this.widthProperty());
        t.minWidthProperty().bind(this.widthProperty());



        this.getChildren().addAll(t,createButtonLayout());
        this.getStyleClass().add("initial-layout");
        this.getStylesheets().add(getResource("/com/notes/styles/InitialLayout/InitialLayout.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/InitialLayout/Icons.css"));
    }


    private VBox createNewNoteButton(){
        VBox newButtonContainer = new VBox();
        newButtonContainer.setStyle("-fx-alignment: center");
        StackPane newButtonBackground = new StackPane();
        newButtonBackground.getStyleClass().add("button-background");
        Region newNoteIcon = new Region();
        newNoteIcon.getStyleClass().addAll("icon","new-note-icon");
        Button newNote = new Button();
        newNote.setOnAction(new LayoutNoteChanger(this.stage));
        newNote.setGraphic(newNoteIcon);
        newNote.getStyleClass().add("button-selector");
        newButtonBackground.getChildren().add(newNote);
        Label newNoteLabel = new Label("New note");
        newNoteLabel.getStyleClass().add("button-label");
        newButtonContainer.getChildren().addAll(newButtonBackground,newNoteLabel);
        return newButtonContainer;
    }

    VBox createOpenNoteButton(){

        VBox openButtonContainer = new VBox();
        openButtonContainer.setStyle("-fx-alignment: center");
        StackPane openButtonBackground = new StackPane();
        openButtonBackground.getStyleClass().add("button-background");
        Region openNoteIcon = new Region();
        openNoteIcon.getStyleClass().addAll("icon","open-note-icon");
        Button openNote = new Button();
        openNote.getStyleClass().add("button-selector");
        openNote.setGraphic(openNoteIcon);
        openButtonBackground.getChildren().add(openNote);
        Label openNoteLabel = new Label("Open note");
        openNoteLabel.getStyleClass().add("button-label");
        openButtonContainer.getChildren().addAll(openButtonBackground,openNoteLabel);
        openNote.setOnAction(new InitialOpenHandler(stage));
        return openButtonContainer;
    }
    HBox createButtonLayout(){
        HBox buttonLayout = new HBox();
        buttonLayout.getStyleClass().add("button-layout");
        buttonLayout.maxHeightProperty().bind(this.heightProperty().subtract(26));
        buttonLayout.minHeightProperty().bind(this.heightProperty().subtract(26));
        buttonLayout.maxWidthProperty().bind(this.widthProperty());
        buttonLayout.maxWidthProperty().bind(this.widthProperty());

        Region spacer = new Region();
        spacer.getStyleClass().add("spacer");

        buttonLayout.getChildren().addAll(createNewNoteButton(),spacer,createOpenNoteButton());
        return buttonLayout;
    }
}
