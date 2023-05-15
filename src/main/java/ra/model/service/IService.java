package ra.model.service;

import java.util.List;

public interface IService <E,T>{
    List<E> findAll();
    boolean save(E e);
    E findById(T t);
    boolean update(E e);
    boolean delete(T t);
}
