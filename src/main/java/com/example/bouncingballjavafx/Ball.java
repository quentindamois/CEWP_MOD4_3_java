package com.example.bouncingballjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class Ball extends Application {
    private Circle ballThatBounce;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    @Override
    public void start(Stage stage) throws IOException {
        Label title = new Label("click anywhere to throw the ball.");
        Scene scene = new Scene(title, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        stage.show();
    }
    /*
    public boolean borderTouch() {
        return (this.ballThatBounce.getCenterY() + );
    }

     */
    public void bouncing() {
        int xSpeed = Math.random() > 0.5 ? 1 : 0;
        xSpeed *= Math.random() > 0.5 ? 1 : -1;
        int ySpeed = Math.random() > 0.5 ? 1 : 0;
        ySpeed *= Math.random() > 0.5 ? 1 : -1;
        if (this.ballThatBounce.getRadius() == 0) this.ballThatBounce.setRadius(25.0);
        this.ballThatBounce.setCenterX((double) this.WINDOW_HEIGHT / 2);
        this.ballThatBounce.setCenterY((double) this.WINDOW_WIDTH / 2);
        while(true) {
            try {
                Thread.sleep(1000);
                this.ballThatBounce.setCenterX(this.ballThatBounce.getCenterX() + xSpeed);
                this.ballThatBounce.setCenterY(this.ballThatBounce.getCenterY() + ySpeed);
            } catch (InterruptedException e) {
                System.out.println("ERRORRR");
            }
        }
    }
    public static void main(String[] arg) {
        launch(arg);
    }
}
