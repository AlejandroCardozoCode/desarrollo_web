package com.proyecto_desarrollo_web.demo.Shared.Domain;

import com.proyecto_desarrollo_web.demo.Shared.Entities.Citas;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.*;

import java.util.List;
import java.util.Optional;

public class Paciente {
    private PacienteId id;
    private PacienteNombre nombre;
    private PacienteAnimal animal;
    private PacienteRaza raza;
    private PacienteEdad edad;
    private PacienteValoracion valoracion;
    private PacienteCC ccDuenio;
    private Optional<List<Citas>> historiaClinicaPaciente;
    private Optional<List<Producto>> productosComprados;
    private Optional<List<Producto>> productosSinComprar;

    public Paciente(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteValoracion valoracion, PacienteCC ccDuenio) {
        this.id = id;
        this.nombre = nombre;
        this.animal = animal;
        this.raza = raza;
        this.edad = edad;
        this.valoracion = valoracion;
        this.ccDuenio = ccDuenio;
        this.historiaClinicaPaciente = Optional.empty();
        this.productosComprados = Optional.empty();
        this.productosSinComprar = Optional.empty();
    }

    public static  Paciente crear(PacienteId id, PacienteNombre nombre, PacienteAnimal animal, PacienteRaza raza, PacienteEdad edad, PacienteValoracion valoracion, PacienteCC ccDuenio){
        Paciente pacienteNuevo = new Paciente(id,nombre,animal, raza, edad, valoracion, ccDuenio);
        return pacienteNuevo;
    }

    public List<Citas> verHistorialMedicoPaciente(){
        return this.historiaClinicaPaciente.get();
    }

    public List<Producto> verProductosCarrito(){
        return this.productosSinComprar.get();
    }

    public Integer precioCarrito(){
        Integer valor = 0;
        for(int i= 0 ; i< productosSinComprar.get().size(); i++)
        {
           valor = valor + productosSinComprar.get().get(i).precio().value();
        }
        return valor;
    }

    public void actualizarValoracion( PacienteValoracion valoracionNueva){
        this.valoracion = valoracionNueva;
    }

    public void agregarCita(Citas cita)
    {
        this.historiaClinicaPaciente.get().add(cita);
    }

    public void agregarCarrito(Producto producto){
        this.productosSinComprar.get().add(producto);
    }
    public void agregarCarritoFinal(Producto producto){
        this.productosComprados.get().add(producto);
    }

}
