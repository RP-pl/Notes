package com.notes.components.basic.drawing;

import com.notes.components.basic.handlers.drawing.BrushColorPicker;
import com.notes.components.basic.common.NumberField;
import com.notes.components.basic.common.mode.ModeSelectorLayout;
import com.notes.components.common.noteLayout.NoteLayout;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.converter.NumberStringConverter;

/**
 * Toolbar for changing DrawCanvas properties
 */
public class DrawComponentBar extends HBox {

    private final DrawProperties properties;
    public DrawComponentBar(DrawProperties properties){
        this.getStyleClass().add("draw-bar");
        this.properties = properties;
        Separator separator1 = new Separator(Orientation.VERTICAL);
        Separator separator2 = new Separator(Orientation.VERTICAL);
        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(new BrushColorPicker(properties.color()));
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        ModeSelectorLayout selector = new ModeSelectorLayout(NoteLayout.modeList);
        this.getChildren().addAll(createWidthNumberComponent(),separator1,createHeightNumberComponent(),separator2,colorPicker,spacer,selector);
    }


    public HBox createWidthNumberComponent(){
        HBox parent = new HBox();
        parent.setAlignment(Pos.CENTER);
        parent.getStyleClass().add("number-component");
        StackPane pane = new StackPane();
        pane.getStyleClass().add("icon-background");
        Region icon = new Region();
        pane.getChildren().add(icon);
        icon.getStyleClass().add("number-component-icon");
        icon.getStyleClass().add("width-icon");
        NumberField width = new NumberField();
        width.textProperty().bindBidirectional(properties.width(),new NumberStringConverter());
        width.getStyleClass().add("number-field");
        parent.getChildren().addAll(pane,width);
        return parent;
    }

    public HBox createHeightNumberComponent(){
        HBox parent = new HBox();
        parent.setAlignment(Pos.CENTER);
        parent.getStyleClass().add("number-component");
        StackPane pane = new StackPane();
        pane.getStyleClass().add("icon-background");
        Region icon = new Region();
        pane.getChildren().add(icon);
        icon.getStyleClass().add("number-component-icon");
        icon.getStyleClass().add("height-icon");
        NumberField height = new NumberField();
        height.textProperty().bindBidirectional(properties.height(),new NumberStringConverter());
        height.getStyleClass().add("number-field");
        parent.getChildren().addAll(pane,height);
        return parent;
    }
}
