package com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Infraestructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.PacienteCli;
import com.proyecto_desarrollo_web.demo.Usuarios.Cliente.Domain.Entities.ProductoCom;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductoComCustomType implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {
                Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<ProductoCom> response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()){
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(),List.class);
                response = objects.stream().map(element -> new PacienteCli((String) element.get("idPaciente"),
                        (String) element.get("animal"),
                        (String) element.get("raza"),
                        (Integer) element.get("edad"))).collect(Collectors.toList());

            }
        }
        catch (Exception e){
            throw new HibernateException("Error at reading map of Paciente Cliente"+ e.toString());
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {

    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
