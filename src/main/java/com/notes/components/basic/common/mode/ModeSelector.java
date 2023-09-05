package com.notes.components.basic.common.mode;

import com.notes.components.basic.handlers.mode.ModeSelectorCellFactory;
import com.notes.components.basic.handlers.mode.ModeSelectorValueHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import java.util.List;

/**
 * Component used for selecting current mode in application
 *
 */
public class ModeSelector extends ComboBox<Mode> {

    public static StringProperty currentMode;
    public ObservableList<Mode> modeList;
    public ModeSelector(List<Mode> modes){
        super();
        this.modeList = FXCollections.observableList(modes);
        this.setItems(modeList);
        this.getSelectionModel().selectFirst();
        currentMode = new SimpleStringProperty(this.getValue().name());
        this.setCellFactory(new ModeSelectorCellFactory());
        this.getStyleClass().add("mode-selector");
        this.addEventHandler(ActionEvent.ACTION,new ModeSelectorValueHandler(this));
    }
}
