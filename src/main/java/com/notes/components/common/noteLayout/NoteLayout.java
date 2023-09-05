package com.notes.components.common.noteLayout;

import com.notes.components.basic.common.mode.Mode;
import com.notes.components.basic.menu.AppMenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

/**
 * This layout adds menu bar and toolbar to ContentLayout
 */
public class NoteLayout extends VBox {

    public static List<Mode> modeList;
    public final ContentLayout contentLayout;
    private final Toolbar toolbar;
    private final AppMenuBar menuBar;

    public NoteLayout(Stage stage){
        super();
        modeList = List.of(Mode.EDIT,Mode.DRAW,Mode.VIEW);
        this.contentLayout = new ContentLayout();
        this.menuBar = new AppMenuBar(this.contentLayout,stage);
        this.toolbar = new Toolbar(stage,"Notes");

        //Menu and toolbar width
        this.contentLayout.maxHeightProperty().bind(this.heightProperty().subtract(52));
        this.contentLayout.minHeightProperty().bind(this.heightProperty().subtract(52));
        this.contentLayout.minWidthProperty().bind(this.widthProperty());
        this.contentLayout.maxWidthProperty().bind(this.widthProperty());
        this.getChildren().addAll(toolbar,menuBar,contentLayout);
    }
}
