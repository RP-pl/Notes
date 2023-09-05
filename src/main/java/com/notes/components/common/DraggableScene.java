package com.notes.components.common;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * A scene that can be dragged
 */
public class DraggableScene extends Scene {
    private double xOffset;
    private double yOffset;

    public DraggableScene(Parent root) {
        super(root);
        this.setOnMousePressed(event -> {
            xOffset = getWindow().getX() - event.getScreenX();
            yOffset = getWindow().getY() - event.getScreenY();
        });

        this.setOnMouseDragged(event -> {
            getWindow().setX(event.getScreenX() + xOffset);
            getWindow().setY(event.getScreenY() + yOffset);
        });
    }

    public DraggableScene(Parent root, double width, double height) {
        super(root, width, height);
        this.setOnMousePressed(event -> {
            xOffset = getWindow().getX() - event.getScreenX();
            yOffset = getWindow().getY() - event.getScreenY();
        });

        this.setOnMouseDragged(event -> {
            getWindow().setX(event.getScreenX() + xOffset);
            getWindow().setY(event.getScreenY() + yOffset);
        });
    }
}
