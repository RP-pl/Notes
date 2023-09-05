package com.notes.components.common.noteLayout;

import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.Region;

/**
 * Component used a background for a Note
 */
public class Backplate extends Region {

    public Backplate(ReadOnlyDoubleProperty width,ReadOnlyDoubleProperty height){
        super();
        this.setStyle("-fx-background-color: white");
        this.minWidthProperty().bind(width.subtract(100));
        this.maxWidthProperty().bind(width.subtract(100));
        this.minHeightProperty().bind(height);
        this.maxHeightProperty().bind(height);
    }
}
