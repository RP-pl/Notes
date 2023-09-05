package com.notes.components.common.handlers;

import com.notes.components.common.DraggableScene;
import com.notes.components.common.noteLayout.NoteLayout;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class LayoutNoteChanger implements EventHandler<ActionEvent> {
    private final Stage stage;
    protected NoteLayout parent;

    public LayoutNoteChanger(Stage stage) {
        super();
        this.stage = stage;
    }
    public LayoutNoteChanger(Stage stage, NoteLayout parent){
        this.stage = stage;
        this.parent = parent;
    }

    @Override
    public void handle(ActionEvent event) {
        Platform.runLater(() -> {
            stage.hide();
            if(parent == null) {
                this.parent = new NoteLayout(stage);
            }
            DraggableScene sc = new DraggableScene(parent,750,500);
            parent.minWidthProperty().bind(sc.widthProperty());
            parent.minHeightProperty().bind(sc.heightProperty());
            stage.setOnShown((ev) -> parent.contentLayout.bindScrollbars());
            stage.setScene(sc);
            if (!stage.isMaximized()) {
                stage.setWidth(750);
                stage.setHeight(500);
            }
            else{
                stage.setMaximized(false);
                stage.setWidth(750);
                stage.setHeight(500);
            }
            stage.show();
        });
    }
}
