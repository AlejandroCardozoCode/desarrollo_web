package com.proyecto_desarrollo_web.demo.Shared.Domain.Exceptions;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String s) {
        super(s);
    }
}
