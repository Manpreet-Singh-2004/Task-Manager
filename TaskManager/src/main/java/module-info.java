module org.example.taskmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.taskmanager to javafx.fxml;
    exports org.example.taskmanager;
    exports org.example.calendar;
    opens org.example.calendar to javafx.fxml;
}