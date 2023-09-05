package com.notes.components.basic.handlers.drawing;

import javafx.beans.value.ObservableValue;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BrushColorChangeListener implements javafx.beans.value.ChangeListener<javafx.scene.paint.Color> {
    private final GraphicsContext context;
    public BrushColorChangeListener(GraphicsContext context) {
        this.context = context;
    }

    @Override
    public void changed(ObservableValue<? extends Color> observable, Color oldValue, Color newValue) {
        context.setFill(newValue);
    }
}
