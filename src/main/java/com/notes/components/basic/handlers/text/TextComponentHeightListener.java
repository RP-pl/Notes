package com.notes.components.basic.handlers.text;

import com.notes.components.common.noteLayout.TextLayout;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.text.Text;

public class TextComponentHeightListener implements ChangeListener<Number>{
    private final TextLayout textLayout;

    public TextComponentHeightListener(TextLayout textLayout) {
        this.textLayout = textLayout;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        Text t = (Text)this.textLayout.textComponent.lookup(".text");
        while (t.getBoundsInLocal().getHeight() < newValue.doubleValue()){
            textLayout.textComponent.appendText("\n");
        }
    }
}
