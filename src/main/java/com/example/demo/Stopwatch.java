package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class Stopwatch implements Initializable {


    @FXML
    private Button rButton;

    @FXML
    private Button sButton;

    @FXML
    private Text text;


    Timeline timeline;
    int mins = 0, secs = 0, millis = 0;
    boolean sos = true;


    void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        text.setText((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }



    public void start() {

        timeline = new Timeline(new KeyFrame(Duration.millis(1), event -> change(text)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        sButton.setOnAction(event -> {
            if(sos) {
                timeline.play();
                sos = false;
                sButton.setText("Stop");
            } else {
                timeline.pause();
                sos = true;
                sButton.setText("Start");
            }
        });

        rButton.setOnAction(event -> {
            mins = 0;
            secs = 0;
            millis = 0;
            timeline.pause();
            text.setText("00:00:000");
            if (!sos) {
                sos = true;
                sButton.setText("Start");
            }
        });

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start();
    }
}

