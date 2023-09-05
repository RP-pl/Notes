package com.notes.components.basic.handlers.text;

import javafx.event.EventHandler;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;

public class ScrollHandler implements EventHandler<ScrollEvent> {
    @Override
    public void handle(ScrollEvent scrollEvent) {

        TextArea eventSource = (TextArea) scrollEvent.getSource();
        ScrollBar scroll = (ScrollBar) eventSource.lookup(".scroll-bar:vertical");
        if (scroll.valueProperty().get() == 1.0) {
            eventSource.appendText("\n");
        }
    }
}
