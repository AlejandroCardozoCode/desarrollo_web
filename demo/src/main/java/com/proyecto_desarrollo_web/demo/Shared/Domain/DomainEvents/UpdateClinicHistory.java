package com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomainEvent;
import com.proyecto_desarrollo_web.demo.Shared.Entities.HistoriaClinica;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;

import java.io.Serializable;
import java.util.HashMap;

public class UpdateClinicHistory extends DomainEvent {
    private final HistoriaClinica HC;

    public UpdateClinicHistory() {
        super(null);
        this.HC = null;
    }
    public UpdateClinicHistory(String aggregateId,HistoriaClinica HC) {
        super(aggregateId);
        this.HC = HC;
    }

    public UpdateClinicHistory(String aggregateId, String eventId, String occurredOn, HistoriaClinica HC) {
        super(aggregateId, eventId, occurredOn);
        this.HC = HC;
    }

    @Override
    public String eventName() {
        return "Update HC";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("HC", (Serializable) HC);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UpdateClinicHistory(aggregateId,eventId,occurredOn,(HistoriaClinica)body.get("HC"));
    }


}
