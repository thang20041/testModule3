package Service;

import java.util.List;

public interface IService<E> {
    boolean add(E e);

    boolean edit(E e, int id);

    boolean delete(int id);

    List<E> findAll();

    List<E> findProductByName(String nameFind);
    E findStudentById(int id);
}
