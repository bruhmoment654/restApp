package ru.cs.vsu.storage.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.cs.vsu.storage.entity.ToDoEntity;
import ru.cs.vsu.storage.entity.UserEntity;
import ru.cs.vsu.storage.model.ToDo;
import ru.cs.vsu.storage.repo.ToDoRepo;
import ru.cs.vsu.storage.repo.UserRepo;

@Service
@AllArgsConstructor
public class ToDoService {

    private ToDoRepo todoRepo;
    private UserRepo userRepo;

    public ToDo createTodo(ToDoEntity todo, Long userId) {
        UserEntity entity = userRepo.findById(userId).get();
        todo.setUser(entity);
        return ToDo.toModel(todoRepo.save(todo));
    }

    public ToDo completeTodo(Long id) {
        ToDoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return ToDo.toModel(todoRepo.save(todo));
    }

}
