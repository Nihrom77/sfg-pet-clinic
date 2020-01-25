package com.springframework.cfgpetclinic.services;

import java.util.Set;

/**
 * CRUD - create, read, update, delete.
 * Делаем интерфейс, аналогичный CRUDRepository, чтобы научиться
 * @param <T> - тип объектов, которые ищутся в репозитории.
 * @param <ID> - тип ID объекта в репозториии. например Long
 */
public interface CRUDService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
