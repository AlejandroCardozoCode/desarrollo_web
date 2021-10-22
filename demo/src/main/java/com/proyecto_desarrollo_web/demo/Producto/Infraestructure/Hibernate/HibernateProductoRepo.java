package com.proyecto_desarrollo_web.demo.Producto.Infraestructure.Hibernate;

import com.proyecto_desarrollo_web.demo.Shared.Infraestructure.Hibernate.HibernateRepository;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.Ports.ProductoRepositorio;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional("transactional-manager")

public class HibernateProductoRepo extends HibernateRepository<Producto> implements ProductoRepositorio {
    public HibernateProductoRepo(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Producto.class);
    }

    @Override
    public void guardar(Producto actual) {
        persist(actual);
    }

    @Override
    public Optional<Producto> buscar(ProductoId id) {
        return byId(id);
    }
}
