package com.notes.components.basic.handlers.mode;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Region;

import java.util.LinkedList;
import java.util.List;

public class ModeSelectorIconHandler implements ChangeListener<String> {
    private static final List<Region> icons  = new LinkedList<>();

    public ModeSelectorIconHandler(Region icon) {
        icons.add(icon);
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        for(Region icon : icons){
            icon.getStyleClass().retainAll("cell-icon");
            icon.getStyleClass().add(newValue+"-cell-icon");
        }
    }
}
