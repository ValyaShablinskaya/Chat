package by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api;

import java.util.List;
import java.util.Optional;

public interface IEssenceStorage<TYPE> {
    List<TYPE> get();

   // Optional<TYPE> getById(int id);

    void save(TYPE type);
}