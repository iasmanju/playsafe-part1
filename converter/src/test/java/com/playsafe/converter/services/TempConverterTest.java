package com.playsafe.converter.services;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static com.playsafe.converter.services.TempConverterHandler.CELSIUS;
import static com.playsafe.converter.services.TempConverterHandler.KELVIN;
import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
class TempConverterTest {

    private TempConverter tempConverter = new TempConverterHandler();


    @Test
    void toCelsius() {
        double tempInKelvin = 373;
        double tempInCelsius = tempConverter.toCelsius(tempInKelvin);
        double expectedValue = 99.85;
        assertEquals(expectedValue, tempInCelsius);
    }

    @Test
    void toKelvin() {
        double tempInCelsius = 99.85;
        double tempInKelvin = tempConverter.toKelvin(tempInCelsius);
        double expectedValue = 373;
        assertEquals(expectedValue, tempInKelvin);
    }

}