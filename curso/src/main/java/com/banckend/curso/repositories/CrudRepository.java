package com.banckend.curso.repositories;

import java.util.Optional;


public interface CrudRepository <T, I> {
    public Optional<T> findById(I id);
    public T save(T t);
    public T update(T t);
    public void delete(T t);
}
