package ra.model.dao;

import java.util.List;

public interface IDao <E,T>{
    List<E> findAll();
    boolean save(E e);
    E findById(T t);
    boolean update(E e);
    boolean delete(T t);
}
