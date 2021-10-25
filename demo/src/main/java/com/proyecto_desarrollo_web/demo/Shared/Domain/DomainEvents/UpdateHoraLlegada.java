package com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomainEvent;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioFinal;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioInicial;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UpdateHoraLlegada extends DomainEvent {
   private final DocHorarioInicial HI;
    public UpdateHoraLlegada() {
        super(null);
        this.HI=null;
    }

    public UpdateHoraLlegada(String aggregateId, DocHorarioInicial HI) {
        super(aggregateId);
        this.HI = HI;
    }

    public UpdateHoraLlegada(String aggregateId, String eventId, String occurredOn, DocHorarioInicial HI) {
        super(aggregateId, eventId, occurredOn);
        this.HI = HI;
    }

    public DocHorarioInicial getHI() {
        return HI;
    }

    @Override
    public String eventName() {
        return "doctor.HoraLlegada";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("Hour",HI.value());
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UpdateHoraLlegada(aggregateId,eventId,occurredOn,(DocHorarioInicial)body.get("Hour"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateHoraLlegada that = (UpdateHoraLlegada) o;
        return HI.equals(that.HI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HI);
    }
}
