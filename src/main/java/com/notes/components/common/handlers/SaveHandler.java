package com.notes.components.common.handlers;

import com.google.gson.Gson;
import com.notes.components.basic.text.TextComponent;
import com.notes.components.basic.text.TextComponentBar;
import com.notes.components.common.noteLayout.ContentLayout;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import static com.notes.components.basic.handlers.text.FontChangeListener.toHexString;

public class SaveHandler implements EventHandler<ActionEvent> {
    private final ContentLayout content;

    public SaveHandler(ContentLayout content) {
        this.content = content;
    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(new File(System.getProperty("user.home")));
        chooser.setTitle("Save file");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Notes","*.nte");
        chooser.getExtensionFilters().add(extFilter);
        chooser.setSelectedExtensionFilter(extFilter);
        File f = chooser.showSaveDialog(content.getScene().getWindow());
        Canvas canvas = content.drawingLayout.drawComponent.drawCanvas;
        Text t = (Text)content.textLayout.textComponent.lookup(".text");
        //Get full height of canvas
        WritableImage writableImage = new WritableImage((int) t.getBoundsInLocal().getWidth(), (int) t.getBoundsInLocal().getHeight());
        SnapshotParameters parameters = new SnapshotParameters();
        parameters.setFill(Color.TRANSPARENT);
        canvas.snapshot(parameters, writableImage);
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);

        ByteArrayOutputStream dataStream = new ByteArrayOutputStream();

        try {
            ImageIO.write(renderedImage, "png", dataStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        byte[] data = Base64.getEncoder().encode(dataStream.toByteArray());
        TextComponentBar textComponentBar = content.textLayout.textComponentBar;
        TextComponent textComponent = content.textLayout.textComponent;
        FontProperties properties = new FontProperties(toHexString(textComponentBar.fontColor.get()),textComponentBar.size.get(),textComponentBar.font.get(),textComponentBar.isBold.get(),textComponentBar.isItalic.get());
        Note n = new Note(textComponent.getText(),properties,data);
        Gson gson = new Gson();
        String json = gson.toJson(n);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
