package com.notes.components.basic.handlers.mode;

import com.notes.components.common.noteLayout.ContentLayout;
import com.notes.components.basic.common.mode.Mode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LayoutChangeListener implements ChangeListener<String> {
    private final ContentLayout contentLayout;

    public LayoutChangeListener(ContentLayout contentLayout) {
        this.contentLayout = contentLayout;
    }

    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if(newValue.equals(Mode.DRAW.name())){
            contentLayout.drawingLayout.toFront();
        }
        else if(newValue.equals(Mode.EDIT.name())){
            contentLayout.textLayout.toFront();
        }
        else if(newValue.equals(Mode.VIEW.name())){
            contentLayout.viewLayout.toFront();
        }
    }
}
