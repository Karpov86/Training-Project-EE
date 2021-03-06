package by.karpov.dao;

public interface InsuranceDao<T, V> {

    boolean save(T entity1, V entity2);

    boolean update(V entity);

    boolean delete(V entity);
}
