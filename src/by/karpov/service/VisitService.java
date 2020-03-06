package by.karpov.service;

public interface VisitService<T, V, D> {

    boolean save(T entity1, V entity2, D entity3);

    boolean read();
}
