package org.example.taskmanager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
public class Calculator extends Application{

    private TextField textField = new TextField();
    private double num1 = 0;
    private String op = "";
    private boolean start = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        textField.setFont(Font.font(20));
        textField.setPrefHeight(50);
        textField.setAlignment(Pos.CENTER_RIGHT);
        textField.setEditable(false);

        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));
        stackPane.getChildren().add(textField);

        TilePane tile = new TilePane();
        tile.setHgap(10);
        tile.setVgap(10);
        tile.setAlignment(Pos.TOP_CENTER);
        tile.getChildren().addAll(
                createButtonForNumber("7"),
                createButtonForNumber("8"),
                createButtonForNumber("9"),
                createButtonForOperator("/"),

                createButtonForNumber("4"),
                createButtonForNumber("5"),
                createButtonForNumber("6"),
                createButtonForOperator("X"),

                createButtonForNumber("1"),
                createButtonForNumber("2"),
                createButtonForNumber("3"),
                createButtonForOperator("-"),

                createButtonForNumber("0"),
                createButtonForClear("C"),
                createButtonForOperator("="),
                createButtonForOperator("+")
        );



        BorderPane root = new BorderPane();
        root.setTop(stackPane);

        root.setCenter(tile);
        Scene scene = new Scene(root, 250, 300);
        scene.setOnKeyPressed(this::handleKeyPress);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private void handleKeyPress(KeyEvent event) {
        String key = event.getText();

        if ("0123456789".contains(key)) {
            textField.appendText(key);
        } else if ("/*-+".contains(key)) {
            if (!op.isEmpty()) return;
            num1 = Double.parseDouble(textField.getText());
            op = key;
            textField.setText("");
        } else if (key.equals("=") || event.getCode().toString().equals("ENTER")) {
            if (op.isEmpty()) return;
            double num2 = Double.parseDouble(textField.getText());
            double result = calculate(num1, num2, op);
            textField.setText(String.valueOf(result));
            start = true;
            op = "";
            num1 = result;
        } else if (key.equals("C") || event.getCode().toString().equals("BACK_SPACE")) {
            textField.setText("");
            op = "";
            num1 = 0;
            start = true;
        }
    }
    private Button createButtonForNumber (String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::precessNumbers);
        return button;
    }
    private Button createButtonForOperator (String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(this::precessOperators);
        return button;
    }
    private Button createButtonForClear (String ch){
        Button button = new Button(ch);
        button.setFont(Font.font(18));
        button.setPrefSize(50, 50);
        button.setOnAction(e ->{
            textField.setText("");
            op = "";
            start = true;
        });
        return button;
    }
    private void precessNumbers(ActionEvent e){
        if (start){
            textField.setText("");
            start = false;
        }
        String value =((Button)e.getSource()).getText();
        textField.setText(textField.getText()+value);

    }
    private void precessOperators(ActionEvent e) {
        String value = ((Button)e.getSource()).getText();

        // Check if the button pressed is not "="
        if (!value.equals("=")) {
            // If there's already an operator set, do nothing and return
            if (!op.isEmpty()) {
                return;
            }
            // Get the first number from the textField
            num1 = Double.parseDouble(textField.getText());
            // Store the operator
            op = value;
            // Clear the textField for the next number input
            textField.setText("");
        } else {
            // If there's no operator set, do nothing and return
            if (op.isEmpty()) {
                return;
            }
            // Get the second number from the textField
            double num2 = Double.parseDouble(textField.getText());
            // Perform the calculation
            double result = calculate(num1, num2, op);
            // Display the result
            textField.setText(String.valueOf(result));
            // Reset for next calculation
            start = true;
            op = "";

            // Update num1 with the result so that it can be used in the next operation
            num1 = result;
        }
    }

    // Assume calculate method is defined to handle double values
    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

