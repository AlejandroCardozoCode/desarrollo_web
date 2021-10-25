package com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomainEvent;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioFinal;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocHorarioInicial;

import java.io.Serializable;
import java.util.HashMap;

public class UpdateHoraSalida extends DomainEvent {
    private final DocHorarioFinal HF;

    public UpdateHoraSalida(DocHorarioFinal HF) {
        super(null);
        this.HF=null;
    }

    public UpdateHoraSalida(String aggregateId, DocHorarioFinal HF) {
        super(aggregateId);
        this.HF = HF;
    }

    public UpdateHoraSalida(String aggregateId, String eventId, String occurredOn, DocHorarioFinal HF) {
        super(aggregateId, eventId, occurredOn);
        this.HF = HF;
    }

    @Override
    public String eventName() {
        return "UpdateHoraSalida";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("Hour",HF.value());
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UpdateHoraSalida(aggregateId,eventId,occurredOn,(DocHorarioFinal)body.get("Hour"));
    }
}
