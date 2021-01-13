package main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import main.model.ToDo;
import main.model.ToDoStorage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "REST_API")
public class ToDoController {

    @GetMapping("/todos/")
    public List<ToDo> list(){
        return ToDoStorage.getToDoList();
    }

    @PostMapping("/todos/")
    public int addToDo(ToDo toDo) {
        return ToDoStorage.addToDo(toDo);
    }

    @GetMapping("/todos/{id}")
    public ToDo getToDo(@PathVariable int id) {
        return ToDoStorage.getToDo(id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteToDo(@PathVariable int id) {
        ToDoStorage.deleteToDo(id);
    }
}
