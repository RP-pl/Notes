package com.notes.components.common;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * A scene that can be dragged
 */
public class DraggableScene extends Scene {
    private double xOffset;
    private double yOffset;

    public DraggableScene(Parent root) {
        super(root);
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = getWindow().getX() - event.getScreenX();
                yOffset = getWindow().getY() - event.getScreenY();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getWindow().setX(event.getScreenX() + xOffset);
                getWindow().setY(event.getScreenY() + yOffset);
            }
        });
    }

    public DraggableScene(Parent root, double width, double height) {
        super(root, width, height);
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = getWindow().getX() - event.getScreenX();
                yOffset = getWindow().getY() - event.getScreenY();
            }
        });

        this.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getWindow().setX(event.getScreenX() + xOffset);
                getWindow().setY(event.getScreenY() + yOffset);
            }
        });
    }
}
