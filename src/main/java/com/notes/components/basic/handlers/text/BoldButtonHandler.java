package com.notes.components.basic.handlers.text;

import javafx.beans.property.BooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public record BoldButtonHandler(BooleanProperty isBold, FontChangeHanlder hanlder)  implements EventHandler<MouseEvent> {
    @Override
    public void handle(MouseEvent event) {
        isBold.set(!isBold.get());
        hanlder.change();
    }
}
