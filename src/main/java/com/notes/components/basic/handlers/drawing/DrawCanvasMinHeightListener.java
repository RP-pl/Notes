package com.notes.components.basic.handlers.drawing;

import com.notes.components.basic.drawing.DrawCanvas;
import javafx.beans.value.ObservableValue;

public class DrawCanvasMinHeightListener implements javafx.beans.value.ChangeListener<Number> {
    private final DrawCanvas drawCanvas;

    public DrawCanvasMinHeightListener(DrawCanvas drawCanvas) {
        this.drawCanvas = drawCanvas;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        if(drawCanvas.getHeight() < newValue.doubleValue()){
            drawCanvas.setHeight(newValue.doubleValue());
        }
    }
}
