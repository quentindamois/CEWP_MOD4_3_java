package com.example.bouncingballjavafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ball extends Application {
    private ArrayList<AbleToBounce> ballThatBounce;
    private GridPane ballgroup;
    private final int WINDOW_WIDTH = 500;
    private final int WINDOW_HEIGHT = 500;
    private ExecutorService executor;
    @Override
    public void start(Stage stage) throws IOException {
        Label title = new Label("click anywhere to throw the ball.");
        this.ballThatBounce = new ArrayList<AbleToBounce>();
       this.ballgroup = new GridPane();
       this.ballgroup.setVgap(1.0);
       this.ballgroup.setHgap(1.0);
       this.ballgroup.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
           System.out.println("Working");
           bouncing(event.getSceneX(), event.getSceneY());
       });
       this.executor = Executors.newFixedThreadPool(20);
       this.executor.submit(() -> {
           actualise();
       });
        Scene scene = new Scene(ballgroup, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setTitle("Bouncing Ball");
        stage.setScene(scene);
        ballgroup.getChildren().add(title);
        stage.show();
    }
    public boolean borderTouch(int n) {
        int i = 0;
        boolean touch = false;
        while(i < this.ballThatBounce.size() && !touch) {
            System.out.println("Numeros "  + i + "et numeros du circle " + n);
            System.out.println("Border : ");
            System.out.println( this.ballThatBounce.get(n).iSBorderColideAll(this.WINDOW_WIDTH, this.WINDOW_HEIGHT));
            System.out.println("Other ball : ");
            System.out.println(this.ballThatBounce.get(n).Colide(this.ballThatBounce.get(i)));
            System.out.println("What's suppose to be in touch : ");
            System.out.println(this.ballThatBounce.get(n).Colide(this.ballThatBounce.get(i)) || this.ballThatBounce.get(n).iSBorderColideAll(this.WINDOW_WIDTH, this.WINDOW_HEIGHT));
            touch = this.ballThatBounce.get(n).iSBorderColideAll(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
            //touch = i != n ? this.ballThatBounce.get(n).Colide(this.ballThatBounce.get(i)) || this.ballThatBounce.get(n).iSBorderColideAll(this.WINDOW_WIDTH, this.WINDOW_HEIGHT) : this.ballThatBounce.get(n).iSBorderColideAll(this.WINDOW_WIDTH, this.WINDOW_HEIGHT);
            System.out.println("i avant" + i);
            i++;
            System.out.println("i après " + i);
        }
        System.out.println("touch :");
        System.out.println(touch);
        if (touch) System.out.println("Rebond");
        return touch;
    }
    public void bouncing(double x, double y) {
        //this.executor.shutdown();
        int xSpeed = Math.random() > 0.5 ? 1 : -1;
        //xSpeed *= Math.random() > 0.5 ? 1 : -1;
        int ySpeed = Math.random() > 0.5 ? 1 : -1;
        //ySpeed *= Math.random() > 0.5 ? 1 : -1;
        this.ballThatBounce.add(new AbleToBounce(x - 12.5, y - 12.5,25.0, xSpeed, ySpeed));
        int ballNumber = this.ballThatBounce.size() - 1;
        //GridPane.setConstraints(ballThatBounce.get(ballNumber), (int) ballThatBounce.get(ballNumber).getCenterX(), (int) ballThatBounce.get(ballNumber).getCenterY());
        this.ballgroup.getChildren().add(ballThatBounce.get(ballNumber));

        /*
        this.executor.submit(() -> {
            actualise();
        });
         */
    }
    public void actualise() {
        while(true) {
            System.out.println();
            if (!ballThatBounce.isEmpty()) {
                for (int i = 0; i < ballThatBounce.size(); i++) {
                    try {
                        System.out.println(ballThatBounce.get(i));
                        Thread.sleep(100);
                        ballThatBounce.get(i).setCenterX(ballThatBounce.get(i).getCenterX() + ballThatBounce.get(i).getXSpeed());
                        ballThatBounce.get(i).setCenterY(ballThatBounce.get(i).getCenterY() + ballThatBounce.get(i).getYSpeed());
                        ballThatBounce.get(i).setTranslateX(ballThatBounce.get(i).getCenterX() + ballThatBounce.get(i).getXSpeed());
                        ballThatBounce.get(i).setTranslateY(ballThatBounce.get(i).getCenterY() + ballThatBounce.get(i).getYSpeed());
                        ballThatBounce.get(i).setXSpeed(ballThatBounce.get(i).getXSpeed() * (borderTouch(i) ? -1 : 1));
                        ballThatBounce.get(i).setYSpeed(ballThatBounce.get(i).getYSpeed() * (borderTouch(i) ? -1 : 1));
                        System.out.println(borderTouch(i) ? -1 : 1);
                        //GridPane.setConstraints(ballThatBounce.get(i), (int) ballThatBounce.get(i).getCenterX(), (int) ballThatBounce.get(i).getCenterY());
                        //System.out.println("yessssssss");
                    } catch (InterruptedException e) {
                        System.out.println("ERRORRR");
                    }
                }
            }
        }
        }
    public static void main(String[] arg) {
        launch(arg);
    }
}
