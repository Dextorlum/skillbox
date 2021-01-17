package main.controller;

import main.model.ToDo;
import main.model.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    ToDoListRepository toDoListRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDo> toDoIterable = toDoListRepository.findAll();

        ArrayList<ToDo> toDoArrayList = new ArrayList<>();

        for (ToDo toDo : toDoIterable){
            toDoArrayList.add(toDo);
        }

        model.addAttribute("todos", toDoArrayList);

        return "index";
    }
}
