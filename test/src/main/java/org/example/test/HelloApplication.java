package org.example.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox root = fxmlLoader.load();
        Scene scene = new Scene(root);

        stage.setTitle("Hello!");

        Button button = new Button("New page");
        Button button1 = new Button("Calc");

        // Adding buttons to the root
        root.getChildren().addAll(button, button1);

        // Setting button actions
        button.setOnAction(event -> openCalendar());
        button1.setOnAction(event -> openCalculator());

        stage.setScene(scene);
        stage.show();
    }

    private void openCalendar() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/calendarview/Calendar.fxml"));
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
