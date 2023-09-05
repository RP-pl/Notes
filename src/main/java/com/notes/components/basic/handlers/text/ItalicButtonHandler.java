package com.notes.components.basic.handlers.text;

import com.notes.components.basic.handlers.text.FontChangeHanlder;
import javafx.beans.property.BooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public record ItalicButtonHandler(BooleanProperty isItalic, FontChangeHanlder hanlder)  implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        isItalic.set(!isItalic.get());
        hanlder.change();
    }
}
