package com.notes.components.basic.handlers.text;

import com.notes.components.basic.text.FontPicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class SelectionHandler implements EventHandler<ActionEvent> {

    private FontPicker picker;
    public SelectionHandler(FontPicker fp){
        this.picker = fp;
    }
    @Override
    public void handle(ActionEvent event) {
        if(picker.getValue() != null && !picker.getValue().equals("")) {
            picker.getEditor().textProperty().set(picker.getValue());
        }
    }
}
