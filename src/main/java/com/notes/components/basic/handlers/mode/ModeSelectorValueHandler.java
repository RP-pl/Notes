package com.notes.components.basic.handlers.mode;

import com.notes.components.basic.common.mode.Mode;
import com.notes.components.basic.common.mode.ModeSelector;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;
import java.util.List;

public class ModeSelectorValueHandler implements EventHandler<ActionEvent> {

    private static final List<ModeSelector> selectors = new LinkedList<>();

    public ModeSelectorValueHandler(ModeSelector modeSelector) {
        selectors.add(modeSelector);
    }

    @Override
    public void handle(ActionEvent event) {
        ModeSelector source = (ModeSelector) event.getSource();
        Mode current = source.getValue();
        for(ModeSelector selector : selectors){
            selector.setValue(current);
        }
        ModeSelector.currentMode.setValue(current.name());
    }
}
