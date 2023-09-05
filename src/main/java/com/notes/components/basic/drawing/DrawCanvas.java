package com.notes.components.basic.drawing;

import com.notes.components.basic.handlers.drawing.BrushColorChangeListener;
import com.notes.components.basic.handlers.drawing.DrawingHandler;
import javafx.scene.canvas.Canvas;

/**
 * This class extends Canvas by implementing drawing functionality and color changing functionality
 */
public class DrawCanvas extends Canvas {

    public DrawCanvas(DrawProperties drawProperties){
        super();
        this.getStyleClass().add("draw-canvas");
        DrawContext context = new DrawContext(this.getGraphicsContext2D(), drawProperties);
        this.setWidth(750);
        this.setHeight(500);
        this.setOnMouseDragged(new DrawingHandler(context));
        context.properties().color().addListener(new BrushColorChangeListener(context.context()));
    }
}
