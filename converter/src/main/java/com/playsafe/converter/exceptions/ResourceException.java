package com.playsafe.converter.exceptions;

public abstract class ResourceException extends RuntimeException {

    public abstract Comparable<?> getProperty();
}
