package com.proyecto_desarrollo_web.demo.Usuarios.Admin.Infraestructure.Hibernate;

import com.proyecto_desarrollo_web.demo.Shared.Infraestructure.Hibernate.HibernateRepository;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Admin;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.Ports.AdminRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Admin.Domain.ValueObjects.AdminId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional("transactional-manager")

public class HibernateAdminRepo extends HibernateRepository<Admin> implements AdminRepositorio{

    public HibernateAdminRepo(@Qualifier("session-factory") SessionFactory sessionFactory){
        super(sessionFactory, Admin.class);
    }

    @Override
    public void save(Admin actual){
        persist(actual);
    }

    @Override
    public void delete(Admin actual) {
        deleteEntity(actual);
    }

    @Override
    public Optional<Admin> find(AdminId id){
        return byId(id);
    }

}
