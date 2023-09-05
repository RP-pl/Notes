package com.notes.components.basic.handlers.text;

import com.notes.components.basic.handlers.text.FontChangeHanlder;
import com.notes.components.basic.text.FontPicker;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public record FontSelectionHandler(StringProperty font, FontChangeHanlder hanlder) implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        FontPicker picker = (FontPicker)event.getSource();
        font.setValue(picker.getValue());
        hanlder.change();
    }
}
