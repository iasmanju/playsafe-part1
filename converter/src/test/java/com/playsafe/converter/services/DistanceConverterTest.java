package com.playsafe.converter.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig
class DistanceConverterTest {
    private DistanceConverter distanceConverter;

    @BeforeEach
    void init(){
       distanceConverter = new DistanceConverterHandler();
    }

    @Test
    void toMiles(){
        double distanceInKM = 1000.0;
        double distanceInMiles = distanceConverter.toMiles( distanceInKM);
        double expectedValue = 621.37;
        assertEquals(expectedValue,distanceInMiles);
    }


    @Test
    void toKilometers(){
        double distanceInMiles = 621.37;
        double distanceInKM = distanceConverter.toKilometer(distanceInMiles);
        double expectedValue = 1000.0;
        assertEquals(expectedValue,distanceInKM);
    }

}