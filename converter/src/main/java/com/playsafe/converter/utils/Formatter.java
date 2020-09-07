package com.playsafe.converter.utils;

import java.text.DecimalFormat;

public class Formatter {

    public static double format(double value){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(value));
    }
}
