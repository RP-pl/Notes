package com.notes.components.basic.drawing;

import com.notes.components.basic.handlers.drawing.DrawCanvasMinHeightListener;
import com.notes.components.basic.handlers.drawing.DrawCanvasScrollHandler;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.control.ScrollPane;

/**
 * DrawCanvas with unlimited scrolling
 */
public class DrawComponent extends ScrollPane {
    public final DrawCanvas drawCanvas;

    public DrawComponent(DrawProperties properties){
        super();
        this.drawCanvas = new DrawCanvas(properties);
        this.setContent(drawCanvas);
        this.setFitToHeight(true);
        this.setFitToWidth(true);
        this.setOnScroll(new DrawCanvasScrollHandler(drawCanvas));
        this.getStyleClass().add("draw-component");
        this.setHbarPolicy(ScrollBarPolicy.NEVER);
        this.setVbarPolicy(ScrollBarPolicy.NEVER);
    }
    public DrawComponent(DrawProperties properties, ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        this(properties);
        this.drawCanvas.widthProperty().bind(width);
        this.minWidthProperty().bind(width.subtract(100));
        this.maxWidthProperty().bind(width.subtract(100));
        this.minHeightProperty().bind(height.subtract(50));
        this.maxHeightProperty().bind(height.subtract(50));
        this.minHeightProperty().addListener(new DrawCanvasMinHeightListener(this.drawCanvas));
    }
}
