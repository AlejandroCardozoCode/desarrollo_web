package com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Infraestructure.Hibernate;

import com.proyecto_desarrollo_web.demo.Shared.Infraestructure.Hibernate.HibernateRepository;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Paciente;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.Ports.PacienteRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Paciente.Domain.ValueObjects.PacienteId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional("transactional-manager")
public class HibernatePacienteRepo extends HibernateRepository<Paciente> implements PacienteRepositorio {

    public HibernatePacienteRepo(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Paciente.class);
    }

    @Override
    public void save(Paciente actual) {
        persist(actual);
    }

    @Override
    public Optional<Paciente> find(PacienteId id) {
        return byId(id);
    }
}
