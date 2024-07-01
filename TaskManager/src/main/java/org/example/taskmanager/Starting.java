package org.example.taskmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Starting extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Starting.class.getResource("Starting.fxml"));
        AnchorPane root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Hello!");

        Button button = (Button) root.lookup("#button");
        Button button1 = (Button) root.lookup("#button1");

        // Setting button actions
        button.setOnAction(event -> openCalendar());
        button1.setOnAction(event -> openCalculator());

        stage.setScene(scene);
        stage.show();
    }

    private void openCalendar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/calendar/Calendar.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Calendar");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openCalculator() {
        Stage stage = new Stage();
        stage.setTitle("Calculator");

        // Assuming Calculator is a simple class with a start method
        Calculator calculator = new Calculator();
        try {
            calculator.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
