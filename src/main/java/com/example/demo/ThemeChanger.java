package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ThemeChanger implements Initializable {

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private AnchorPane homePane;


    @FXML
    void onClickSaveTheme() {
        String hex2 = "#" + Integer.toHexString(colorPicker.getValue().hashCode()).substring(0, 6);



        homePane.setStyle("-fx-background-color:" + hex2);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
