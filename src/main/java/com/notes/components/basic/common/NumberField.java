package com.notes.components.basic.common;

import javafx.scene.control.TextField;

/**
 * Text field with number parsing
 */
public class NumberField extends TextField
{
    public NumberField(){
        super();
        this.getStyleClass().add("number-field-draw");
    }
    @Override
    public void replaceText(int start, int end, String text)
    {
        if (validate(text))
        {
            super.replaceText(start, end, text);
        }
    }

    @Override
    public void replaceSelection(String text)
    {
        if (validate(text))
        {
            super.replaceSelection(text);
        }
    }

    private boolean validate(String text)
    {
        return text.matches("[0-9]*");
    }
}
