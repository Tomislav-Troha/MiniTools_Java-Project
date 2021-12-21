package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;


public class Converter implements Initializable {

    @FXML
    private TextField amount;

    @FXML
    private TextField tfFromCurr;

    @FXML
    private TextField tfToCurr;

    @FXML
    private TextField tfUkupno;

    @FXML
    private ComboBox<Currency> inputCurrencyComboBox;

    @FXML
    private ComboBox<Currency> outputCurrencyComboBox;



    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();

    private final static DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#0.0");

    private final ObservableList<Currency> currencies = FXCollections.observableArrayList();

  //  private final ChangeListener<String> inputAmountChangeListener = (observable, oldValue, newValue) -> convertAction(null);

    @FXML
    private void convertAction(ActionEvent e) {

        Currency inputCurrency = inputCurrencyComboBox.getValue();
        Currency outputCurrency = outputCurrencyComboBox.getValue();
        double inputValue;

        tfFromCurr.setText(String.valueOf(outputCurrency.getFullName()));
        tfToCurr.setText(String.valueOf(inputCurrency.getFullName()));


        if (!amount.getText().equals("") && isNumeric(amount.getText())) {
            inputValue = DOUBLE_STRING_CONVERTER.fromString(amount.getText());

            double inputValueInDollars = inputValue * inputCurrency.getKunaConversionRate();
            double outputValue = inputValueInDollars / outputCurrency.getKunaConversionRate();

            tfUkupno.setText(CURRENCY_FORMAT.format(outputValue));
        }
    }


    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        currencies.addAll(Currency.values());
        inputCurrencyComboBox.setItems(currencies);
        outputCurrencyComboBox.setItems(currencies);
        inputCurrencyComboBox.getSelectionModel().selectFirst();
        outputCurrencyComboBox.getSelectionModel().selectLast();


        inputCurrencyComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            convertAction(null);
        });
        outputCurrencyComboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            convertAction(null);
        });
    }
}
