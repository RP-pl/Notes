package com.notes.components.basic.text;

import com.notes.components.basic.common.NumberField;
import com.notes.components.basic.handlers.text.*;
import com.notes.components.basic.common.mode.ModeSelectorLayout;
import com.notes.components.common.noteLayout.NoteLayout;
import javafx.beans.property.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.converter.NumberStringConverter;

/**
 * Toolbar for changing TextComponent properties
 */
public class TextComponentBar extends HBox {
    public final BooleanProperty isBold = new SimpleBooleanProperty(false);
    public final BooleanProperty isItalic = new SimpleBooleanProperty(false);
    public final IntegerProperty size = new SimpleIntegerProperty(12);

    public final StringProperty font = new SimpleStringProperty("Arial");
    public  final ObjectProperty<Color> fontColor = new SimpleObjectProperty<>(Color.BLACK);

    private final FontChangeHanlder fontChangeHanlder;

    public TextComponentBar(TextArea ta){
        this.fontChangeHanlder = new FontChangeHanlder(font,isBold,isItalic,size, ta);
        this.getStyleClass().add("text-bar");

        FontPicker picker = new FontPicker(Font.getFontNames());
        picker.setOnAction(new FontSelectionHandler(font,fontChangeHanlder));

        ToggleButton bold = createBoldButton();

        ToggleButton italic = createItalicButton();

        HBox sizeField = createNumberField();
        Region spacer = new Region();
        spacer.getStyleClass().add("spacer");
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Separator separator1 = new Separator(Orientation.VERTICAL);

        Separator separator2 = new Separator(Orientation.VERTICAL);

        Separator separator3 = new Separator(Orientation.VERTICAL);


        ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setOnAction(new FontColorHandler(ta,fontColor));

        ModeSelectorLayout selector = new ModeSelectorLayout(NoteLayout.modeList);

        this.getChildren().addAll(bold,italic,separator3,picker,separator1,sizeField,separator2, colorPicker,spacer,selector);
        FontChangeListener<Object> hanlder = new FontChangeListener<>(font,isBold,isItalic,size,fontColor, ta);
        size.addListener(hanlder);
        fontColor.addListener(hanlder);
    }

    public TextComponentBar(TextArea ta,ReadOnlyDoubleProperty widthProperty){
        this(ta);
        this.minWidthProperty().bind(widthProperty);
        this.maxWidthProperty().bind(widthProperty);
    }





    private ToggleButton createBoldButton(){
        ToggleButton bold = new ToggleButton();
        bold.setOnMouseClicked(new BoldButtonHandler(isBold,fontChangeHanlder));
        bold.getStyleClass().add("bold");
        Region boldIcon = new Region();
        boldIcon.getStyleClass().add("bold-icon");
        boldIcon.getStyleClass().add("icon");
        bold.setGraphic(boldIcon);

        return bold;
    }
    private ToggleButton createItalicButton() {
        ToggleButton italic = new ToggleButton();
        italic.setOnMouseClicked(new ItalicButtonHandler(isItalic,fontChangeHanlder));
        italic.getStyleClass().add("italic");
        Region italicIcon = new Region();
        italicIcon.getStyleClass().add("italic-icon");
        italicIcon.getStyleClass().add("icon");
        italic.setGraphic(italicIcon);
        return italic;
    }

    private HBox createNumberField(){
        HBox parent = new HBox();
        parent.setAlignment(Pos.CENTER);
        NumberField sizeField = new NumberField();
        sizeField.getStyleClass().add("number-field");
        sizeField.setAlignment(Pos.CENTER);
        sizeField.textProperty().bindBidirectional(size,new NumberStringConverter());
        Button subtract = createSubtractButton();
        Button add = createAddButton();
        parent.getChildren().addAll(subtract,sizeField,add);
        return parent;
    }

    private Button createAddButton() {
        Button add = new Button();
        add.setOnMouseClicked(new AddButtonHandler(size));
        add.getStyleClass().add("add");
        Region addIcon = new Region();
        addIcon.getStyleClass().add("add-icon");
        addIcon.getStyleClass().add("icon");
        add.setGraphic(addIcon);
        return add;
    }

    private Button createSubtractButton(){
        Button subtract = new Button();
        subtract.setOnMouseClicked(new SubtractButtonHandler(size));
        subtract.getStyleClass().add("subtract");
        Region subtractIcon = new Region();
        subtractIcon.getStyleClass().add("subtract-icon");
        subtractIcon.getStyleClass().add("icon");
        subtract.setGraphic(subtractIcon);
        return subtract;
    }
}
