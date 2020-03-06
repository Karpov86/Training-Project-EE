package by.karpov.service;

public interface InsuranceService<T, V> {

    boolean save(T entity1, V entity2);

    boolean read();
}
