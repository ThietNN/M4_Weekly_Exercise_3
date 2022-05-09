package thietnn.m4_weekly_exercise_3.service;

import java.util.Optional;

public interface IService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void removeById(Long id);
}
