package com.notes.components.common.handlers;

import javafx.scene.paint.Color;
public class FontProperties {
    public String fontColor;
    public int fontSize;
    public String fontFamily;
    public boolean isBold;
    public boolean isItalic;

    public FontProperties(String fontColor, int fontSize, String fontFamily, boolean isBold, boolean isItalic) {
        this.fontColor = fontColor;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }
}
