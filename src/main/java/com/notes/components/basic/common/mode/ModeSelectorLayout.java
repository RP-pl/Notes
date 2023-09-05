package com.notes.components.basic.common.mode;

import com.notes.components.basic.handlers.mode.ModeSelectorIconHandler;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import java.util.List;

/**
 * ModeSelector with additional icon
 */
public class ModeSelectorLayout extends HBox {
    private final ModeSelector modeSelector;
    private final Region icon;

    public ModeSelectorLayout(List<Mode> modes){
        this.modeSelector = new ModeSelector(modes);
        this.icon = new Region();
        this.icon.getStyleClass().add(modeSelector.getValue().name() + "-cell-icon");
        this.icon.getStyleClass().add("cell-icon");
        ModeSelector.currentMode.addListener(new ModeSelectorIconHandler(this.icon));
        this.getChildren().add(icon);
        this.getChildren().add(modeSelector);
        this.getStyleClass().add("mode-selector-layout");
    }
}
