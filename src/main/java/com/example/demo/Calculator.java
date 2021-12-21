package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Calculator implements Initializable {

    @FXML
    private Button add_button;

    @FXML
    private Button clear_button;

    @FXML
    private Button devide_button;

    @FXML
    private Button dot_button;

    @FXML
    private Button eight_button;

    @FXML
    private Button five_button;

    @FXML
    private Button four_button;

    @FXML
    private Button is_button;

    @FXML
    private Button multiply_button;

    @FXML
    private Button nine_button;

    @FXML
    private Button one_button;

    @FXML
    private Button seven_button;

    @FXML
    private Button six_button;

    @FXML
    private Button subtraction_button;

    @FXML
    private TextField text_field;

    @FXML
    private Button three_button;

    @FXML
    private Button two_button;

    @FXML
    private Button zero_button;




    String s0, s1, s2;



    public void attcode () {

        s0 = s1 = s2 = "";

        add_button.setOnAction(e -> btncode(e));
        devide_button.setOnAction(e -> btncode(e));
        multiply_button.setOnAction(e -> btncode(e));
        subtraction_button.setOnAction(e -> btncode(e));
        clear_button.setOnAction(e -> btncode(e));
        is_button.setOnAction(e -> btncode(e));
        dot_button.setOnAction(e -> btncode(e));
        zero_button.setOnAction(e -> btncode(e));
        one_button.setOnAction(e -> btncode(e));
        two_button.setOnAction(e -> btncode(e));
        three_button.setOnAction(e -> btncode(e));
        four_button.setOnAction(e -> btncode(e));
        five_button.setOnAction(e -> btncode(e));
        six_button.setOnAction(e -> btncode(e));
        seven_button.setOnAction(e -> btncode(e));
        eight_button.setOnAction(e -> btncode(e));
        nine_button.setOnAction(e -> btncode(e));
    }




    public void  btncode ( ActionEvent e) {



        String a = e.toString();
        String i = a.substring(a.length() - 3, a.length() - 2);


        // ako je value broj
        if (i.charAt(0) >= '0' && i.charAt(0) <= '9' || i.charAt(0) == '.') {
            //ako je operand prisutan dodaj drugi broj
            if (!s1.equals(""))
                s2 = s2 + i;
            else
                s0 = s0 + i;

            //postavi vrijednost teksta
            text_field.setText(s0 + s1 + s2);
        } else if (i.charAt(0) == 'C') {
            //ocisti
            s0 = s1 = s2 = "";

            //postavi vrijednost teksta
            text_field.setText(s0 + s1 + s2);
        } else if (i.charAt(0) == '=') {

            double te;

            //pohrani vrijednost prvog
            if (s1.equals("+")) {
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            } else if (s1.equals("-")) {
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            } else if (s1.equals("/")) {
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            } else te = (Double.parseDouble(s0) * Double.parseDouble(s2));

            //postavi vrijednost teksta
            text_field.setText(s0 + s1 + s2 + "=" + te);

            //covert u string
            s0 = Double.toString(te);

            s1 = s2 = "";
        } else {
            //ako nema operanda
            if (s1.equals("") || s2.equals("")) {
                s1 = i;
            }
            //inace
            else {
                double te;

                //pohrani vrijednost prvog
                if (s1.equals("+")) {
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                } else if (s1.equals("-")) {
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                } else if (s1.equals("/")) {
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                } else te = (Double.parseDouble(s0) * Double.parseDouble(s2));

                //convert to string

                s0 = Double.toString(te);

                //postavi operator
                s1 = i;

                //postavi operator praznim
                s2 = "";
            }
            //postavi value na text

            text_field.setText(s0 + s1 + s2);
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        attcode();
    }
}


