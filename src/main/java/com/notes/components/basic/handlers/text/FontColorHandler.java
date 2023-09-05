package com.notes.components.basic.handlers.text;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;

public record FontColorHandler(TextArea component, ObjectProperty<Color> color) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        ColorPicker picker = (ColorPicker) event.getSource();
        color.setValue(picker.getValue());
    }
}
