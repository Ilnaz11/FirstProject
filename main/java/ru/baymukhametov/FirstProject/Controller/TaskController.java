package ru.baymukhametov.FirstProject.Controller;


import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.service.TaskService;


import java.util.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public MyTask createTask(@RequestBody  MyTask myTask) {
        return taskService.createTask(myTask);
    }

    @GetMapping
    public List<MyTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
    @PutMapping("/{id}/toggle")
    public MyTask toggleCompleted(@PathVariable Long id) {
        return taskService.toggleCompleted(id);
    }


}