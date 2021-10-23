package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Entities;

import java.util.HashMap;
import java.util.Objects;

public class DoctorAsignado {

    private String idDoctor;
    private String nombreDoctor;

    private DoctorAsignado(){}

    public DoctorAsignado(String idDoctor, String nombreDoctor){
        this.idDoctor = idDoctor;
        this.nombreDoctor = nombreDoctor;
    }

    public HashMap<String, Object> data(){
        return new HashMap<>(){{
            put("idDoctor",idDoctor);
            put("nombreDoctor",nombreDoctor);
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorAsignado that = (DoctorAsignado) o;
        return Objects.equals(idDoctor, that.idDoctor) && Objects.equals(nombreDoctor, that.nombreDoctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoctor, nombreDoctor);
    }
}
