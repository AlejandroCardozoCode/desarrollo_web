package com.proyecto_desarrollo_web.demo.Producto.Domain.Ports;

import com.proyecto_desarrollo_web.demo.Producto.Domain.Producto;
import com.proyecto_desarrollo_web.demo.Producto.Domain.ValueObjects.ProductoId;

import java.util.Optional;

public interface ProductoRepositorio {
    void save(Producto actual);
    Optional<Producto> find(ProductoId id);
}
