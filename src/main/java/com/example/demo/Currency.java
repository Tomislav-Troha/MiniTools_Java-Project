package com.example.demo;

public enum Currency {
    HRK("kuna",1),
    USD("dollar", 0.15),
    GBP("pound", 0.11),
    YEN("yen",17.00),
    EUR("euro", 0.13);



    private double KunaConversionRate;

    private String fullName;

    Currency(String fullName, double KunaConversionRate) {
        this.KunaConversionRate = KunaConversionRate;
        this.fullName = fullName;
    }

    public double getKunaConversionRate() {
        return KunaConversionRate;
    }

    public String getFullName () {return fullName;}



}