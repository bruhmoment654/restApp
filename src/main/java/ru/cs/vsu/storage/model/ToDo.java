package ru.cs.vsu.storage.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.cs.vsu.storage.entity.ToDoEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDo {

    private Long id;
    private String title;
    private boolean completed;

    public static ToDo toModel(ToDoEntity entity){
        return new ToDo(entity.getId(), entity.getTitle(), entity.getCompleted());
    }
}
