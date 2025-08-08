package ru.baymukhametov.FirstProject.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.Repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private LocalDateTime createdAt;
    private static List<String> allowedSortFields = Arrays.asList("id", "bla");

    public static boolean isValidSortBy(String sortBy) {
        return allowedSortFields.contains(sortBy);
    }

    public TaskServiceImpl(TaskRepository taskRepository)  {
        this.taskRepository = taskRepository;
    }

    @Override
    public MyTask createTask(MyTask task) {
        createdAt = LocalDateTime.now();
        return taskRepository.save(task);
    }

    @Override
    public List<MyTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    @Override
    public MyTask toggleCompleted(Long taskId) {
        MyTask task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setCompleted(!task.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public Page<MyTask> getSortedTasks(int page, int size, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return taskRepository.findAll(pageable);
    }
}