package com.notes.components.common.handlers;

public class Note {
    public FontProperties fontProperties;
    public String textContent;
    public byte[] imageData;

    public Note(String textContent,FontProperties fontProperties, byte[] imageData){
        this.textContent = textContent;
        this.imageData = imageData;
        this.fontProperties = fontProperties;
    }
}
