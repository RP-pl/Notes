module com.notes.notes {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;
    requires com.google.gson;
    requires java.desktop;

    opens com.notes to javafx.fxml;
    exports com.notes;
    exports com.notes.components.common;
    opens com.notes.components.common to javafx.fxml;
    opens com.notes.components.common.handlers to com.google.gson;
}