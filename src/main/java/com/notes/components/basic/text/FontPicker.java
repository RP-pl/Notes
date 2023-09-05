package com.notes.components.basic.text;

import com.notes.components.basic.handlers.text.FontPickHandler;
import com.notes.components.basic.handlers.text.FontPickerCellFactory;
import com.notes.components.basic.handlers.text.SelectionHandler;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Component used for picking a font
 */
public class FontPicker extends ComboBox<String> {

    private FilteredList<String> fonts;

    public FontPicker(List<String> fontNames){
        super();
        List<String> names = filterFontNames(fontNames);
        this.fonts = new FilteredList<>(FXCollections.observableList(names), p->true);
        this.setCellFactory(new FontPickerCellFactory());
        this.setItems(fonts);
        this.addEventHandler(ActionEvent.ACTION,new SelectionHandler(this));
        this.getEditor().textProperty().addListener(new FontPickHandler(this,fonts));
        this.getEditor().setOnMouseClicked((event)->this.show());
        this.setEditable(true);
        this.getSelectionModel().select(0);
        this.setTooltip(new Tooltip("Select Font"));
        this.getStyleClass().add("font-picker");
    }

    private List<String> filterFontNames(List<String> fontNames) {
        Set<String> previous = new HashSet<>();
        List<String> names = new LinkedList<>();
        for (String name: fontNames) {
            if(!previous.contains(name.split(" ")[0])){
                previous.add(name.split(" ")[0]);
                names.add(name);
            }
        }
        return names;
    }
}
