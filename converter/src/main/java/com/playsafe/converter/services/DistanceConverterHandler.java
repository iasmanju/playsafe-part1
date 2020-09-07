package com.playsafe.converter.services;

import com.playsafe.converter.exceptions.InvalidConversionTypeException;
import com.playsafe.converter.utils.Formatter;
import org.springframework.stereotype.Service;

@Service
public class DistanceConverterHandler implements DistanceConverter {
    private static final double CONVERSION_FACTOR = 0.62137;




    @Override
    public double toMiles(double distanceInKM) {
        return Formatter.format(CONVERSION_FACTOR * distanceInKM);
    }

    @Override
    public double toKilometer(double distanceInMiles) {
        return Formatter.format(distanceInMiles/CONVERSION_FACTOR);
    }
}
