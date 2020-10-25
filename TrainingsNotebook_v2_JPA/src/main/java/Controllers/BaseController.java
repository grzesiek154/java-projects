package Controllers;

import java.util.List;

public interface BaseController<T> {

    void saveData(T data);
    void deleteData(Long id);
    T findDataById(Long id);
    void updateData(T data);
    List<T> getAllData();
}
