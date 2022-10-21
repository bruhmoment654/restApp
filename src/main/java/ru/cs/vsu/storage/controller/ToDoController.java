package ru.cs.vsu.storage.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.cs.vsu.storage.entity.ToDoEntity;
import ru.cs.vsu.storage.service.ToDoService;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class ToDoController {

    private ToDoService toDoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody ToDoEntity todo, @RequestParam Long id) {
        try {

            return ResponseEntity.ok(toDoService.createTodo(todo, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Err");
        }
    }

    @PutMapping
    public ResponseEntity completeTodo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(toDoService.completeTodo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Err");
        }
    }


}
