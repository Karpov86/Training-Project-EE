package by.karpov.service;

import by.karpov.entity.Person;

import java.util.List;

public interface PersonService<V> {

    boolean save(V entity);

    Person find(Long id);

    List<V> findAll();
}
