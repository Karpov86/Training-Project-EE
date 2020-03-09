package by.karpov.dao;

public interface PersonDao<T> {

    boolean save(T entity);

    boolean update(T entity1, T entity2);

    boolean delete(Long id);

    T find(Long id);
}
