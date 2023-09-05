package com.notes.components.basic.handlers.text;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public record FontChangeListener<T>(StringProperty font, BooleanProperty isBold, BooleanProperty isItalic, IntegerProperty size, ObjectProperty<Color> color, TextArea component) implements ChangeListener<T> {

    @Override
    public void changed(ObservableValue<? extends T> observable, T oldValue, T newValue) {
        FontWeight fw = FontWeight.NORMAL;
        FontPosture fp = FontPosture.REGULAR;

        if (isBold.get()) {
            fw = FontWeight.BOLD;
        }

        if (isItalic.get()) {
            fp = FontPosture.ITALIC;
        }
        Font newFont = Font.font(font.get(), fw, fp, size.get());
        component.setFont(newFont);
        component.setStyle("-fx-text-fill: "+ toHexString(color.getValue()));
    }
    private static String format(double val) {
        String in = Integer.toHexString((int) Math.round(val * 255));
        return in.length() == 1 ? "0" + in : in;
    }

    public static String toHexString(Color value) {
        return "#" + (format(value.getRed()) + format(value.getGreen()) + format(value.getBlue()) + format(value.getOpacity()))
                .toUpperCase();
    }
}
