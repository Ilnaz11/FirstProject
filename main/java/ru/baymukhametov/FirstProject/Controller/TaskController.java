package ru.baymukhametov.FirstProject.Controller;

import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.Service.TaskService;

import java.util.List;

@RestController
@RequestMapping
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/")
    public MyTask createTask(@RequestBody MyTask task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<MyTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/{id}/t")
    public MyTask toggleComplete(@PathVariable Long id) {
        return taskService.toggleCompleted(id);
    }

}