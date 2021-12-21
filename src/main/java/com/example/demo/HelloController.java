package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;



public class HelloController {



    @FXML
    void onCalculatorClick(ActionEvent event) {

            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("calculator.fxml"));

                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Calculator");
                stage.setScene(scene);
                stage.show();


            }
            catch (IOException e) {
                e.printStackTrace();
            }
    }



    @FXML
    void onConverterClick(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("converter.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Converter");
            stage.setScene(scene);
            stage.show();


        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onStopwatchClick(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Stopwatch.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Converter");
            stage.setScene(scene);
            stage.show();


        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



}




