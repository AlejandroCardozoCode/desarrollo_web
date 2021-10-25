package com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomainEvent;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Entities.PacienteAsignado;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class UpdateListPatientDomainEvent extends DomainEvent {

    private final PacienteAsignado docId;

    public UpdateListPatientDomainEvent(PacienteAsignado docId) {
        super(null);
        this.docId = null;
    }

    public UpdateListPatientDomainEvent(String aggregateId, PacienteAsignado docId) {
        super(aggregateId);
        this.docId = docId;
    }

    public UpdateListPatientDomainEvent(String aggregateId, String eventId, String occurredOn, PacienteAsignado docId) {
        super(aggregateId, eventId, occurredOn);
        this.docId = docId;
    }

    public PacienteAsignado getDocId() {
        return docId;
    }

    @Override
    public String eventName() {
        return "Doctor.AgregarListaPacientes";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String,Serializable>(){{
            put("docId", (Serializable) docId);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new UpdateListPatientDomainEvent(aggregateId,eventId,occurredOn,(PacienteAsignado) body.get("docId"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateListPatientDomainEvent that = (UpdateListPatientDomainEvent) o;
        return docId.equals(that.docId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docId);
    }
}
