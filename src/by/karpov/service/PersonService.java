package by.karpov.service;

import by.karpov.entity.Person;

import java.util.List;

public interface PersonService<V> {

    boolean save(V entity);

    List<V> read();

    Person find(V entity);
}
