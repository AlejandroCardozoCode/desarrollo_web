package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Listener;

import com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event.DomaiEventSubscriber;
import com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents.UpdateHoraLlegada;
import com.proyecto_desarrollo_web.demo.Shared.Domain.DomainEvents.UpdateHoraSalida;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Application.ActualizarHoraFinal.ActualizarHoraFianlDoctor;
import org.springframework.context.event.EventListener;

@DomaiEventSubscriber({UpdateHoraSalida.class})
public class VerifyHourOut {
    private ActualizarHoraFianlDoctor HF;
    public VerifyHourOut(){
        this.HF=HF;
    }
    @EventListener
    public void on(UpdateHoraLlegada u){
        this.HF.execute(u.getHI().value(),u.aggregateId().toString());
    }
}
