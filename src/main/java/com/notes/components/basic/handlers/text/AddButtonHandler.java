package com.notes.components.basic.handlers.text;

import javafx.beans.property.IntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public record AddButtonHandler(IntegerProperty size) implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        size.set(size.get() + 1);
    }
}
