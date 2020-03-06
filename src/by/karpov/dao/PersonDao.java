package by.karpov.dao;

public interface PersonDao<T> {

    boolean save(T entity);

    void read();

    boolean updateAddress(T entity);

    boolean delete(T entity);

    T find(T entity);
}
