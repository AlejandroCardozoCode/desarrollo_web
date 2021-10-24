package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Hibernate;

import com.proyecto_desarrollo_web.demo.Shared.Infraestructure.Hibernate.HibernateRepository;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Cliente;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Ports.ClienteRepo;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.ValueObjects.ClienteId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateClienteRepo extends HibernateRepository<Cliente> implements ClienteRepo {

    public HibernateClienteRepo(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Cliente.class);
    }

    @Override
    public void save(Cliente actual) {
        persist(actual);
    }

    @Override
    public void update(Cliente nuevo) {
        updateEntity(nuevo);
    }

    @Override
    public Optional<Cliente> find(ClienteId id) {
        return byId(id);
    }
}
