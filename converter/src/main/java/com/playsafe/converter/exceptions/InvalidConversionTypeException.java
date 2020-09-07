package com.playsafe.converter.exceptions;

public class InvalidConversionTypeException extends ResourceException {

    private Comparable<?> property;

    public InvalidConversionTypeException(Comparable<?> property){
        this.property = property;
    }

    @Override
    public Comparable<?> getProperty() {
        return property;
    }
}
