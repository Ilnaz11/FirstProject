package ru.baymukhametov.FirstProject.Controller;


import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.baymukhametov.FirstProject.Entity.MyPriority;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.service.TaskService;


import java.time.LocalDateTime;
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

    @GetMapping("/tasks/completed")
    public List<MyTask> getTasksByCompleted(boolean completed) {
        return taskService.getTasksByCompleted(completed);
    }

    @GetMapping("/tasks/incompleted")
    public Page<MyTask> getTasksByCompleted(boolean completed, org.springframework.data.domain.Pageable pageable) {
        return taskService.getTasksByCompleted(completed, pageable);

    }
    //Сделай эндпоинт /tasks/completed — возвращает только выполненные задачи.
    //Сделай эндпоинт /tasks/incomplete — возвращает только невыполненные задачи.
    @PutMapping("/tasks/{id}")
    public MyTask updateTask(Long id, String description, LocalDateTime dueDate, MyPriority priority) {
        return taskService.updateTask(id, description, dueDate, priority);
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