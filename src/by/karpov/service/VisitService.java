package by.karpov.service;

import java.time.LocalDate;
import java.util.List;

public interface VisitService<T, V, D> {

    boolean save(T entity1, V entity2, D entity3);

    List<LocalDate> getFreeDates(T entity);
}
