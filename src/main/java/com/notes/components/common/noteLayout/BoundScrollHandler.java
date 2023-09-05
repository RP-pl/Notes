package com.notes.components.common.noteLayout;

import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;

/**
 * Event handler used for binding scrollbars
 */
public class BoundScrollHandler implements EventHandler<ScrollEvent> {

    private final ContentLayout layout;
    public BoundScrollHandler(ContentLayout layout){
        this.layout = layout;
    }

    @Override
    public void handle(ScrollEvent event) {
        Text t = (Text)layout.textLayout.textComponent.lookup(".text");
        layout.drawingLayout.drawComponent.drawCanvas.setHeight(t.getBoundsInLocal().getHeight());
    }
}
