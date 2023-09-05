package com.notes.components.common.noteLayout;

import com.notes.components.basic.drawing.DrawComponent;
import com.notes.components.basic.drawing.DrawComponentBar;
import com.notes.components.basic.drawing.DrawProperties;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class DrawingLayout extends VBox {

    public final DrawComponent drawComponent;
    private final DrawComponentBar dcb;

    public DrawingLayout(){
        super();
        this.getStyleClass().add("drawing-layout");
        this.setAlignment(Pos.TOP_CENTER);
        DrawProperties dp = new DrawProperties(new SimpleDoubleProperty(5),new SimpleDoubleProperty(5), new SimpleObjectProperty<>(Color.BLACK));
        this.dcb = new DrawComponentBar(dp);
        this.getStylesheets().add("com/notes/styles/Common/ColorPicker.css");
        this.getStylesheets().add("com/notes/styles/Common/NumberField.css");
        this.getStylesheets().add("com/notes/styles/Common/ComboBox.css");
        this.getStylesheets().add("com/notes/styles/Common/Separator.css");
        this.getStylesheets().add("com/notes/styles/Common/Spacer.css");
        this.getStylesheets().add("com/notes/styles/ModeSelector/ModeSelector.css");
        this.getStylesheets().add("com/notes/styles/Drawing/NumberComponent.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawComponentBar.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawingLayout.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawComponent.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawCanvas.css");


        this.drawComponent = new DrawComponent(dp,this.widthProperty(),this.heightProperty());
        VBox.setVgrow(drawComponent, Priority.ALWAYS);
        this.getChildren().addAll(dcb, drawComponent);
    }

    public DrawingLayout(ReadOnlyDoubleProperty height){
        super();
        this.getStyleClass().add("drawing-layout");
        DrawProperties dp = new DrawProperties(new SimpleDoubleProperty(5),new SimpleDoubleProperty(5), new SimpleObjectProperty<>(Color.BLACK));
        this.dcb = new DrawComponentBar(dp);
        this.getStylesheets().add("com/notes/styles/Common/ColorPicker.css");
        this.getStylesheets().add("com/notes/styles/Common/NumberField.css");
        this.getStylesheets().add("com/notes/styles/Common/ComboBox.css");
        this.getStylesheets().add("com/notes/styles/Common/Separator.css");
        this.getStylesheets().add("com/notes/styles/Common/Spacer.css");
        this.getStylesheets().add("com/notes/styles/ModeSelector/ModeSelector.css");
        this.getStylesheets().add("com/notes/styles/Drawing/NumberComponent.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawComponentBar.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawingLayout.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawComponent.css");
        this.getStylesheets().add("com/notes/styles/Drawing/DrawCanvas.css");

        this.minHeightProperty().bind(height);
        this.maxHeightProperty().bind(height);

        this.drawComponent = new DrawComponent(dp,this.widthProperty(),this.heightProperty());
        VBox.setVgrow(drawComponent, Priority.ALWAYS);
        this.getChildren().addAll(dcb, drawComponent);

    }

    protected ScrollBar getDrawingComponentScrollbar(){
       return  (ScrollBar) this.drawComponent.lookup(".scroll-bar:vertical");
    }
}
