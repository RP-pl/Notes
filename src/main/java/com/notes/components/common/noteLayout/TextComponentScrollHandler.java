package com.notes.components.common.noteLayout;

import com.notes.components.basic.drawing.DrawComponent;
import com.notes.components.basic.text.TextComponent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;

/**
 * Handles scrolling of TextComponent
 */
public class TextComponentScrollHandler implements EventHandler<ScrollEvent> {
    private final TextComponent textComponent;

    public TextComponentScrollHandler(TextComponent layout) {
        this.textComponent= layout;
    }

    @Override
    public void handle(ScrollEvent event) {
        DrawComponent eventSource = (DrawComponent) event.getSource();
        Text t = (Text)this.textComponent.lookup(".text");
        eventSource.drawCanvas.setHeight(t.getBoundsInLocal().getHeight());
        ScrollBar scroll = (ScrollBar) eventSource.lookup(".scroll-bar:vertical");
        if (scroll.valueProperty().get() == 1.0) {
            this.textComponent.appendText("\n");
        }
        eventSource.drawCanvas.setHeight(t.getBoundsInLocal().getHeight());
    }
}
