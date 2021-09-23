package com.proyecto_desarrollo_web.demo.Shared.Domain.Aggregate;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Exceptions.UUIDNotValid;

import java.util.Objects;
import java.util.UUID;

public class CustomUUID {

    private String value;

    public CustomUUID(String value) {
        this.validate(value);
        this.value = value;
    }

    protected CustomUUID() {}

    private void validate(String value) {
        this.validateUUIDFormatRule(value);
    }

    public String value() {
        return value;
    }

    private void validateUUIDFormatRule(String value)
    {
        try {
            UUID.fromString(value);
        }
        catch (Exception ex)
        {
            throw new UUIDNotValid("El UUID no es valido");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomUUID that = (CustomUUID) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
