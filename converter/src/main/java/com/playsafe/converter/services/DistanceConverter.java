package com.playsafe.converter.services;

public interface DistanceConverter {

    double toMiles(double distanceInKM);
    double toKilometer(double distanceInMiles);
}
