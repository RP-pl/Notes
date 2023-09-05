package com.notes.components.common.handlers;

import com.notes.components.common.DraggableScene;
import com.notes.components.common.initialLayout.InitialLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class LayoutInitialChanger implements EventHandler<ActionEvent> {
    private final Stage stage;

    public LayoutInitialChanger(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        InitialLayout parent = new InitialLayout(stage);
        DraggableScene sc = new DraggableScene(parent,500,350);
        parent.minWidthProperty().bind(sc.widthProperty());
        parent.maxWidthProperty().bind(sc.widthProperty());
        parent.minHeightProperty().bind(sc.heightProperty());
        this.stage.setScene(sc);
        this.stage.setMaximized(false);
        this.stage.setWidth(500);
        this.stage.setHeight(350);

    }
}
