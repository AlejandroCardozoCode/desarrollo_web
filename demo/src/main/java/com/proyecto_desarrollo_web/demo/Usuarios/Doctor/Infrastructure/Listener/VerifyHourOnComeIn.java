package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Listener;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomaiEventSubscriber;
import com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents.UpdateHoraLlegada;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraIncial.ActualizadorHoraInicialDoctor;
import org.springframework.context.event.EventListener;

@DomaiEventSubscriber({UpdateHoraLlegada.class})
public class VerifyHourOnComeIn {
    private ActualizadorHoraInicialDoctor a;

    public VerifyHourOnComeIn(ActualizadorHoraInicialDoctor a) {
        this.a = a;
    }
    @EventListener
    public void on(UpdateHoraLlegada u){
        this.a.execute(u.getHI().value(),u.aggregateId().toString());
    }
}
