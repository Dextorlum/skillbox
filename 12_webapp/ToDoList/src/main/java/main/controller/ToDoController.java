package main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import main.model.ToDo;
import main.model.ToDoListRepository;
import main.model.ToDoStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todos")
@Api(tags = "REST_API")
public class ToDoController {

    @Autowired
    private  ToDoListRepository toDoListRepository;

    @GetMapping
    public List<ToDo> list(){

        Iterable<ToDo> toDoIterable = toDoListRepository.findAll();

        ArrayList<ToDo> toDoArrayList = new ArrayList<>();

        for (ToDo toDo : toDoIterable) {
            toDoArrayList.add(toDo);
        }

        return toDoArrayList;
    }

    @PostMapping
    public int addToDo(ToDo toDo) {

        ToDo newToDo = toDoListRepository.save(toDo);
        return newToDo.getId();
    }

    @GetMapping("{id}")
    public ResponseEntity getToDo(@PathVariable int id) {
        Optional<ToDo> optionalToDo = toDoListRepository.findById(id);

        if (optionalToDo.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return new ResponseEntity(optionalToDo.get(), HttpStatus.OK);
        }
    }
    @PutMapping
    public ResponseEntity updateToDo(ToDo toDo){
        Optional<ToDo> optionalToDo = toDoListRepository.findById(toDo.getId());

        if (optionalToDo.isPresent()){
            toDoListRepository.save(toDo);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }
    }

    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable int id) {
        toDoListRepository.deleteById(id);
    }
}
