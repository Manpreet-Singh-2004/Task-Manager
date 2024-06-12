import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.foreign.GroupLayout;

public class trial extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label label1 = new Label("Trial");
        label1.setTextFill(Color.WHITE);
        Group root = new Group(label1);

        Text text = new Text("Hello");
        text.setX(50);
        text.setY(50);
        text.setFill(Color.DARKBLUE);
        root.getChildren().add(text);

        Line line = new Line();
        line.setStartX(0);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        root.getChildren().add(line);

        Button button = new Button("Open Stage 2");
        button.setOnAction(event -> openStage2());


        root.getChildren().add(button);

//        StackPane root1 = new StackPane(root, button);
//        root1.setStyle("-fx-background-color: lightblue;");

        Scene scene = new Scene(root, 300, 200, Color.LIGHTBLUE);

        Image icon = new Image("new.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stage 1");
        stage.setWidth(500);
        stage.setHeight(500);
        stage.setScene(scene);
        stage.show();
    }
    public void openStage2(){

        Label l1 = new Label("This is stage 2");
        StackPane mainroot2 = new StackPane(l1);

        Scene scene2 = new Scene(mainroot2);

        Stage stage2 = new Stage();
        stage2.setTitle("Stage 2");
        stage2.setScene(scene2);
        stage2.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
