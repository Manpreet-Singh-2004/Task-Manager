package org.example.test;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class mainController {

    @FXML
    private Circle MyCircle;
    private double x;
    private double y;

    public void up(ActionEvent e){
        System.out.println("UP");
        MyCircle.setCenterY(y-=1);
    }
    public void down(ActionEvent e){
        System.out.println("DOWN");
        MyCircle.setCenterY(y+=1);
    }
    public void left(ActionEvent e){
        System.out.println("LEFT");
        MyCircle.setCenterX(x-=1);
    }
    public void right(ActionEvent e){
        System.out.println("RIGHT");
        MyCircle.setCenterX(x+=1);
    }

}
