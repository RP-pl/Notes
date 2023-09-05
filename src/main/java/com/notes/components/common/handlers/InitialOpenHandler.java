package com.notes.components.common.handlers;

import com.notes.components.common.noteLayout.NoteLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class InitialOpenHandler implements EventHandler<ActionEvent> {


    private final Stage stage;

    public InitialOpenHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {

        NoteLayout parent = new NoteLayout(stage);
        LayoutNoteChanger layoutNoteChanger = new LayoutNoteChanger(stage,parent);
        layoutNoteChanger.handle(event);
        OpenHandler handler = new OpenHandler(parent.contentLayout,stage);
        handler.handle(event);
    }
}
