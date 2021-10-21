package com.proyecto_desarrollo_web.demo.Shared.Domain.Bus.Event;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface DomaiEventSubscriber {
    Class<? extends DomainEvent>[] value();
}
