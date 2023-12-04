package com.notes.components.common.noteLayout;

import com.notes.components.basic.common.mode.ModeSelectorLayout;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import static com.notes.util.Resources.getResource;

public class ViewLayout extends VBox {

    protected final ScrollPane scrollRegion;

    public ViewLayout(ReadOnlyDoubleProperty width, ReadOnlyDoubleProperty height){
        super();
        this.scrollRegion = new ScrollPane();
        scrollRegion.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollRegion.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.minHeightProperty().bind(height);
        this.maxHeightProperty().bind(height);
        this.minWidthProperty().bind(width);
        this.maxWidthProperty().bind(width);

        scrollRegion.minHeightProperty().bind(height.subtract(50));
        scrollRegion.maxHeightProperty().bind(height.subtract(50));
        scrollRegion.minWidthProperty().bind(width.subtract(100));
        scrollRegion.maxWidthProperty().bind(width.subtract(100));

        this.setAlignment(Pos.CENTER);
        HBox bar = new HBox();
        bar.getStyleClass().add("view-bar");
        scrollRegion.getStyleClass().add("view-layout");
        this.getStyleClass().add("view-layout-scroll-pane");
        bar.setAlignment(Pos.CENTER);
        bar.getChildren().add(new ModeSelectorLayout(NoteLayout.modeList));
        Region r = new Region();
        r.minHeightProperty().bind(height.subtract(50));
        r.maxHeightProperty().bind(height.subtract(50));
        r.maxWidthProperty().bind(width.subtract(100));
        r.minWidthProperty().bind(width.subtract(100));

        scrollRegion.setContent(r);
        this.getChildren().addAll(bar,scrollRegion);
        this.getStylesheets().add(getResource("/com/notes/styles/View/ViewLayout.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/ModeSelector/ModeSelector.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/Common/ComboBox.css"));
    }
}
