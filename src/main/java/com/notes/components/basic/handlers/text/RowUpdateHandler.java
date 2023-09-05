package com.notes.components.basic.handlers.text;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;

public class RowUpdateHandler implements ChangeListener<Number> {

    private final TextArea source;
    public RowUpdateHandler(TextArea source){
        this.source = source;
    }
    @Override
    public void changed(ObservableValue <? extends Number> observableValue, Number number, Number t1) {
        if(t1.intValue() - number.intValue() > 0){
            this.source.appendText("\n".repeat(t1.intValue() - number.intValue()));
        }
        else{
            this.source.appendText("\n");
        }
    }
}
