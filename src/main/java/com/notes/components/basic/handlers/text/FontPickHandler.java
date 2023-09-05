package com.notes.components.basic.handlers.text;

import com.notes.components.basic.text.FontPicker;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;

import java.util.Objects;

public class FontPickHandler implements ChangeListener<String> {

    private final FilteredList<String> fonts;
    private final FontPicker picker;

    public FontPickHandler(FontPicker picker, FilteredList<String> fonts){
        this.picker = picker;
        this.fonts = fonts;
    }


    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            Platform.runLater(() -> {
                String selected = picker.getSelectionModel().getSelectedItem();
                if (selected == null || !selected.equals(picker.getEditor().getText())) {
                    fonts.setPredicate((element) -> element.contains(newValue));
                }
            });
    }
}
