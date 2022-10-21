package ru.cs.vsu.storage.repo;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cs.vsu.storage.entity.ToDoEntity;

@Repository
public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
}
