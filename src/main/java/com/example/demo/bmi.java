package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;




public class bmi implements Initializable {

    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();
    private final static DecimalFormat Decimal_format = new DecimalFormat("#0.0");

    @FXML
    private RadioButton female;

    @FXML
    private RadioButton male;

    @FXML
    private TextField tfHeight;

    @FXML
    private TextField tfWeight;

    @FXML
    private ToggleGroup tgGendre;

    @FXML
    private TextField txStatus;

    @FXML
    private TextField txYourBmi;


    Double bmiValue;
    Double weightDouble;
    Double heightDouble;

    @FXML
    void onCLickCalculate(ActionEvent event) {

        weightDouble = DOUBLE_STRING_CONVERTER.fromString(tfWeight.getText());
        heightDouble = DOUBLE_STRING_CONVERTER.fromString(tfHeight.getText());

        //System.out.println(weightDouble);
        //System.out.println(heightDouble);

        bmiValue = weightDouble / (heightDouble * heightDouble) * 10000;

        txYourBmi.setText(Decimal_format.format(bmiValue));


    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
