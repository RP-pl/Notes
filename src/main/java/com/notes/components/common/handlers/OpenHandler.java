package com.notes.components.common.handlers;

import com.google.gson.Gson;
import com.notes.components.basic.text.TextComponentBar;
import com.notes.components.common.noteLayout.ContentLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Base64;

public class OpenHandler implements EventHandler<ActionEvent> {
    private final ContentLayout content;
    private final Stage stage;

    public OpenHandler(ContentLayout content, Stage stage) {
        this.content = content;
        this.stage  = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save file");
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Notes","*.nte","*.NTE");
        chooser.getExtensionFilters().add(extFilter);
        File file = chooser.showOpenDialog(stage);
        Gson gson = new Gson();
        StringBuilder data = new StringBuilder();
        BufferedReader fr;
        try {
            fr = new BufferedReader(new FileReader(file));
            for (String line: fr.lines().toList()) {
                data.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Note n = gson.fromJson(data.toString(), Note.class);

        byte[] imageData = Base64.getDecoder().decode(n.imageData);
        ByteArrayInputStream stream = new ByteArrayInputStream(imageData);
        Image img = new Image(stream);
        content.textLayout.textComponent.setText(n.textContent);
        TextComponentBar bar = content.textLayout.textComponentBar;
        bar.font.setValue(n.fontProperties.fontFamily);
        bar.isBold.setValue(n.fontProperties.isBold);
        bar.isItalic.setValue(n.fontProperties.isItalic);
        bar.size.setValue(n.fontProperties.fontSize);
        bar.fontColor.setValue(Color.valueOf(n.fontProperties.fontColor));
        content.drawingLayout.drawComponent.drawCanvas.setHeight(img.getHeight());
        GraphicsContext context = content.drawingLayout.drawComponent.drawCanvas.getGraphicsContext2D();
        context.drawImage(img,0,0);
    }
}
