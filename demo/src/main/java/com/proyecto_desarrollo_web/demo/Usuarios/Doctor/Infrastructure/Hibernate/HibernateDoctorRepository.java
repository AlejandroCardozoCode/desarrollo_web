package com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Infrastructure.Hibernate;

import com.proyecto_desarrollo_web.demo.Shared.Infraestructure.Hibernate.HibernateRepository;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Doctor;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.Ports.DoctorRepositorio;
import com.proyecto_desarrollo_web.demo.Usuarios.Doctor.Domain.ValueObjects.DocId;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateDoctorRepository extends HibernateRepository<Doctor> implements DoctorRepositorio {


    public HibernateDoctorRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Doctor.class);
    }

    @Override
    public void save(Doctor actual) {
        persist(actual);
    }

    @Override
    public void update(Doctor doctor) {
        updateEntity(doctor);
    }

    @Override
    public Optional<List<Doctor>> all() {
        return getAll();
    }

    @Override
    public void delete(Doctor doctor) {
        deleteEntity(doctor);
    }

    @Override
    public Optional<Doctor> find(DocId id) {
        return byId(id);
    }
}
