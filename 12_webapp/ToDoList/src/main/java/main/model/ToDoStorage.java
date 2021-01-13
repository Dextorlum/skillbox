package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ToDoStorage {

    private static int id = 0;
    private static ConcurrentHashMap<Integer, ToDo>  toDoList= new ConcurrentHashMap <>();

    public static List<ToDo> getToDoList() {
        List<ToDo> toDoList1 = new ArrayList<ToDo>();
        toDoList1.addAll(toDoList.values());
        return toDoList1;
    }

    public static int addToDo(ToDo toDo) {
        toDo.setId(++id);
        toDoList.put(id, toDo);
        return id;
    }

    public static ToDo getToDo(int id) {
        return toDoList.get(id);
    }

    public static void deleteToDo(int id) {
        toDoList.remove(id);
    }

}
