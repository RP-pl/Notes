package com.notes.components.basic.text;

import com.notes.components.basic.handlers.text.RowUpdateHandler;
import com.notes.components.basic.handlers.text.ScrollHandler;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Font;

/**
 * TextArea with infinite scrolling
 */
public class TextComponent extends TextArea {

    private final static EventHandler<ScrollEvent> scrollEventEventHandler = new ScrollHandler();

    public TextComponent(){
        this(10);
    }

    public TextComponent(int lines) {
        super("\n".repeat(lines));
        this.getStyleClass().add("text-component");
        this.setFont(Font.font("Arial",12));
        this.setStyle("-fx-text-fill: black");
        this.setWrapText(true);
        ChangeListener<? super Number> rowUpdateListener = new RowUpdateHandler(this);
        this.prefRowCountProperty().addListener(rowUpdateListener);
        this.setOnScroll(scrollEventEventHandler);
    }

    public TextComponent(int lines, ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty){
        this(lines);
        this.minWidthProperty().bind(widthProperty.subtract(100));
        this.maxWidthProperty().bind(widthProperty.subtract(100));
        this.prefHeightProperty().bind(heightProperty);
    }
}
