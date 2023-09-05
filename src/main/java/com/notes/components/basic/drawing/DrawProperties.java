package com.notes.components.basic.drawing;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;

public record DrawProperties( DoubleProperty width, DoubleProperty height, ObjectProperty<Color> color) {
}
