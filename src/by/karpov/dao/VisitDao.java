package by.karpov.dao;

public interface VisitDao<T, V, D> {

    boolean save(T entity1, V entity2, D entity3);

    void read();

    boolean update(D entity);

    boolean delete(D entity);
}
