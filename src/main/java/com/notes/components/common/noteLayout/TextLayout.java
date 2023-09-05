package com.notes.components.common.noteLayout;

import com.notes.components.basic.handlers.text.TextComponentHeightListener;
import com.notes.components.basic.text.TextComponent;
import com.notes.components.basic.text.TextComponentBar;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
public class TextLayout extends VBox {
    public final TextComponentBar textComponentBar;
    public final TextComponent textComponent;
    public TextLayout(){
        this(50);
    }
    public TextLayout(int lines){
        super();
        this.getStyleClass().add("text-layout");
        this.setAlignment(Pos.CENTER);
        this.setFillWidth(true);
        this.textComponent = new TextComponent(lines,this.widthProperty(),this.heightProperty());
        this.heightProperty().addListener(new TextComponentHeightListener(this));
        this.textComponentBar = new TextComponentBar(textComponent,this.widthProperty());
        StackPane background = new StackPane();
        background.setStyle("-fx-background-color: white");
        background.getChildren().add(textComponentBar);
        this.getChildren().addAll(background, textComponent);
        this.getStylesheets().add("com/notes/styles/Text/TextComponent.css");
        this.getStylesheets().add("com/notes/styles/Text/TextComponentBar.css");
        this.getStylesheets().add("com/notes/styles/Text/Button.css");
        this.getStylesheets().add("com/notes/styles/Common/ColorPicker.css");
        this.getStylesheets().add("com/notes/styles/Common/NumberField.css");
        this.getStylesheets().add("com/notes/styles/Text/ToggleButton.css");
        this.getStylesheets().add("com/notes/styles/Text/FontPicker.css");
        this.getStylesheets().add("com/notes/styles/ModeSelector/ModeSelector.css");
        this.getStylesheets().add("com/notes/styles/Common/Button.css");
        this.getStylesheets().add("com/notes/styles/Common/Separator.css");
        this.getStylesheets().add("com/notes/styles/Common/Spacer.css");
        this.getStylesheets().add("com/notes/styles/Common/ToggleButton.css");
        this.getStylesheets().add("com/notes/styles/Common/ComboBox.css");
    }

    protected ScrollBar getTextComponentScrollbar(){
        return (ScrollBar) this.textComponent.lookup(".scroll-bar:vertical");
    }
}
