package com.notes.components.basic.handlers.text;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.util.Callback;

public class FontPickerCellFactory implements Callback<ListView<String>, ListCell<String>> {
    @Override
    public ListCell<String> call(ListView<String> param) {
        return new ListCell<>(){
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(item == null || empty){
                    setGraphic(null);
                }
                else{
                    Label l = new Label(item);
                    l.setFont(Font.font(item));
                    setGraphic(l);
                }
            }
        };
    }
}
