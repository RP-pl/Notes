package com.notes.components.basic.handlers.drawing;

import com.notes.components.basic.drawing.DrawContext;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DrawingHandler implements EventHandler<MouseEvent> {

    private final DrawContext drawContext;

    public DrawingHandler(DrawContext drawContext) {
        this.drawContext = drawContext;
    }

    @Override
    public void handle(MouseEvent event) {
        double ypos = event.getY();
        double xpos = event.getX();
        double height = drawContext.properties().height().get();
        double width = drawContext.properties().width().get();
        drawContext.context().fillOval(xpos-width/2,ypos-height/2, width, height);
    }
}
