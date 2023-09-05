package com.notes.components.basic.handlers.drawing;

import com.notes.components.basic.drawing.DrawCanvas;
import com.notes.components.basic.drawing.DrawComponent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;

public class DrawCanvasScrollHandler implements EventHandler<ScrollEvent> {
    private final DrawCanvas canvas;

    public DrawCanvasScrollHandler(DrawCanvas canvas){
        this.canvas = canvas;
    }
    @Override
    public void handle(ScrollEvent event) {
        DrawComponent component = (DrawComponent) event.getSource();
        ScrollBar scroll = (ScrollBar) component.lookup(".scroll-bar:vertical");
        if(scroll.valueProperty().get() == 1.0) {
            canvas.setHeight(canvas.getHeight()+100);
        }
    }
}
