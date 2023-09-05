package com.notes.components.basic.handlers.text;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public record FontChangeHanlder(StringProperty font, BooleanProperty isBold, BooleanProperty isItalic, IntegerProperty size, TextArea object) {
    public void change() {
        FontWeight fw = FontWeight.NORMAL;
        FontPosture fp = FontPosture.REGULAR;

        if(isBold.get()){
            fw = FontWeight.BOLD;
        }

        if(isItalic.get()){
            fp = FontPosture.ITALIC;
        }
        Font newFont = Font.font(font.get(),fw,fp,size.get());
        object.setFont(newFont);
    }
}
