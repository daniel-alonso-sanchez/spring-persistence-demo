package es.dalonso.training.persistence.service;

import java.util.List;

public interface ICrudService<K,T> {
    Iterable<T> getAll();
     T getById(K key);
     T add(T element);
     void update(T element);
     void delete(K key);
}
