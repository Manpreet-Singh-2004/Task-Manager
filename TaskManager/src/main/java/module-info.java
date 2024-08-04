module org.example.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;

    opens org.example.taskmanager to javafx.fxml;
    exports org.example.taskmanager;
    exports org.example.calendar;
    opens org.example.calendar to com.fasterxml.jackson.databind;

    // Export the filemanager package
    exports org.example.filemanager to javafx.graphics;
}