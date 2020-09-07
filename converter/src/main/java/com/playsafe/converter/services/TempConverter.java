package com.playsafe.converter.services;

public interface TempConverter {

    double toKelvin(double celsiusTemp);
    double toCelsius(double kelvinTemp);
}
