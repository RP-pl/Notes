package com.notes.components.basic.handlers.drawing;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class BrushColorPicker implements EventHandler<ActionEvent> {

    private final ObjectProperty<Color> brushColor;

    public BrushColorPicker(ObjectProperty<Color> brushColor){
        this.brushColor = brushColor;
    }

    @Override
    public void handle(ActionEvent event) {
        ColorPicker picker = (ColorPicker) event.getSource();
        brushColor.setValue(picker.getValue());
    }
}
