package com.notes.components.basic.menu;

import com.notes.components.common.handlers.OpenHandler;
import com.notes.components.common.handlers.SaveHandler;
import com.notes.components.common.noteLayout.ContentLayout;
import com.notes.components.common.handlers.LayoutNoteChanger;
import com.notes.components.common.handlers.LayoutInitialChanger;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import static com.notes.util.Resources.getResource;

public class AppMenuBar extends MenuBar {

    private final ContentLayout content;
    private final Stage stage;

    public AppMenuBar(ContentLayout content,Stage stage){
        super();
        this.content = content;
        this.stage = stage;
        this.getStylesheets().add(getResource("/com/notes/styles/Common/Icon.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/Menu/Icons.css"));
        this.getStylesheets().add(getResource("/com/notes/styles/Menu/Bar.css"));
        this.getMenus().addAll(createProjectMenu(),createFileMenu());
    }

    private Menu createProjectMenu(){
        Menu projectMenu = new Menu("Project");
        Region newIcon = new Region();
        newIcon.getStyleClass().addAll("icon","new-icon");
        MenuItem newNote = new MenuItem("New",newIcon);
        newNote.setOnAction(new LayoutNoteChanger(this.stage));
        projectMenu.getItems().add(newNote);

        Region closeIcon = new Region();
        closeIcon.getStyleClass().addAll("icon","close-icon");
        MenuItem closeButton = new MenuItem("Close",closeIcon);
        closeButton.setOnAction(new LayoutInitialChanger(this.stage));
        projectMenu.getItems().add(closeButton);
        return projectMenu;
    }

    private Menu createFileMenu(){
        Menu fileMenu = new Menu("File");
        Region openIcon = new Region();
        openIcon.getStyleClass().addAll("icon","open-note-icon");
        MenuItem open = new MenuItem("Open",openIcon);
        open.setOnAction(new OpenHandler(content,stage));

        Region saveIcon = new Region();
        saveIcon.getStyleClass().addAll("icon","save-note-icon");
        MenuItem save = new MenuItem("Save as",saveIcon);
        save.setOnAction(new SaveHandler(this.content));

        fileMenu.getItems().addAll(open,save);

        return fileMenu;
    }
}
