package ru.cs.vsu.storage.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cs.vsu.storage.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private List<ToDo> todos;

    public static User toModel(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername(), entity.getTodos().stream()
                .map(ToDo::toModel)
                .collect(Collectors.toList()));
    }
}
