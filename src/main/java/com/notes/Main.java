package com.notes;

import com.notes.components.common.DraggableScene;
import com.notes.components.common.initialLayout.InitialLayout;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {


    @Override
    public void start(Stage stage) {


        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("com/notes/icons/icon.png"));


        InitialLayout parent = new InitialLayout(stage);
        stage.setWidth(500);
        stage.setHeight(350);
        DraggableScene sc = new DraggableScene(parent);

        parent.minWidthProperty().bind(sc.widthProperty());
        parent.minHeightProperty().bind(sc.heightProperty());
        stage.setScene(sc);


        stage.show();
    }
}
