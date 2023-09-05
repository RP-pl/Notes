package com.notes.components.basic.handlers.mode;

import com.notes.components.basic.common.mode.Mode;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Callback;

public class ModeSelectorCellFactory implements Callback<ListView<Mode>, ListCell<Mode>> {
    @Override
    public ListCell<Mode> call(ListView<Mode> param) {
        return new ListCell<>(){
            @Override
            protected void updateItem(Mode item, boolean empty) {
                super.updateItem(item, empty);
                if(item == null || empty){
                    setGraphic(null);
                }
                else{
                    HBox container = new HBox();
                    container.getStyleClass().add("mode-cell-parent");

                    Region r = new Region();
                    r.getStyleClass().add(item.name()+"-cell-icon");
                    r.getStyleClass().add("cell-icon");
                    Label l = new Label(item.name());
                    l.getStyleClass().add("mode-label");

                    container.getChildren().addAll(r,l);

                    setGraphic(container);
                }
            }
        };
    }
}
