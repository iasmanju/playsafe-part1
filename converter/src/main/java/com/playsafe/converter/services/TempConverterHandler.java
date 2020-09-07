package com.playsafe.converter.services;

import com.playsafe.converter.utils.Formatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TempConverterHandler  implements TempConverter{
    public static final String KELVIN = "kelvin";
    public static final String CELSIUS = "celsius";
    private  static final double CONVERSION_FACTOR = 273.15;

    @Override
    public double toKelvin(double cTemp) {
        return Formatter.format(cTemp + CONVERSION_FACTOR);
    }

    @Override
    public double toCelsius(double kTemp) {
        return Formatter.format(kTemp - CONVERSION_FACTOR) ;
    }
}

