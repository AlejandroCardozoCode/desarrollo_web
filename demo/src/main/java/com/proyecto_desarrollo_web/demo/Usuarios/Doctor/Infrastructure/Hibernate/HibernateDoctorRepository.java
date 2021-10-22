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
    public void guardar(Doctor actual) {
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
    public Optional<List<Doctor>> encontrarID(DocId id) {
        Doctor doctor = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Doctor> cr = cb.createQuery(Doctor.class);
        Root<Doctor> root = cr.from(Doctor.class);
        cr.select(root).where(cb.equal(root.get("DocId"), id));
        List<Doctor> doctors = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        return Optional.ofNullable(doctors);
    }

    @Override
    public Optional<Doctor> encotrar(DocId id) {
        return byId(id);
    }
}
