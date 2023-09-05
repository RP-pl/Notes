package com.notes.components.common.noteLayout;

import com.notes.components.basic.handlers.mode.LayoutChangeListener;
import com.notes.components.basic.common.mode.ModeSelector;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

/**
 * Layout with all main components of a note
 */
public class ContentLayout extends StackPane {

    private final Backplate backplate;
    public final ViewLayout viewLayout;
    public DrawingLayout drawingLayout;
    public TextLayout textLayout;

    private boolean ScrollbarsBound = false;
    public ContentLayout(){
        super();
        this.minWidthProperty().set(750);
        this.textLayout = new TextLayout();;
        bindWidthProperties(textLayout);


        this.drawingLayout = new DrawingLayout(textLayout.heightProperty());
        bindWidthProperties(drawingLayout);


        this.viewLayout = new ViewLayout(this.widthProperty(),this.heightProperty());

        this.backplate = new Backplate(this.widthProperty(),textLayout.heightProperty());
        this.getChildren().addAll(backplate,viewLayout,drawingLayout,textLayout);
        ModeSelector.currentMode.addListener(new LayoutChangeListener(this));
        this.getStyleClass().add("complete-layout");
        this.getStylesheets().add("com/notes/styles/CompleteLayout.css");
    }

    private void bindWidthProperties(Region node){
        node.minWidthProperty().bind(this.widthProperty());
        node.maxWidthProperty().bind(this.widthProperty());
    }


    public void bindScrollbars(){
        if(!this.ScrollbarsBound) {
            Text t = (Text)this.textLayout.textComponent.lookup(".text");

            textLayout.addEventHandler(ScrollEvent.SCROLL,new BoundScrollHandler(this));
            drawingLayout.drawComponent.setOnScroll(new TextComponentScrollHandler(this.textLayout.textComponent));
            drawingLayout.drawComponent.drawCanvas.setHeight(t.getBoundsInLocal().getHeight());

            ScrollBar drawing = this.drawingLayout.getDrawingComponentScrollbar();
            ScrollBar text = this.textLayout.getTextComponentScrollbar();
            text.valueProperty().bindBidirectional(drawing.valueProperty());
            this.ScrollbarsBound = false;

            ScrollBar view = (ScrollBar) this.viewLayout.scrollRegion.lookup(".scroll-bar:vertical");
            view.valueProperty().bindBidirectional(text.valueProperty());
            view.setMin(0);
        }
    }
}
