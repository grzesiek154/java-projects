package DAO;

import Entities.Exercise;

import java.util.List;

public interface BaseService<T> {

    T findById(Long id);
    void save(T data);
    void update(T data);
    void delete(Long id);
    List<T> getAll();
}
