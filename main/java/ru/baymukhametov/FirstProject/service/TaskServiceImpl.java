package ru.baymukhametov.FirstProject.service;


import ru.baymukhametov.FirstProject.Entity.MyPriority;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private static final List<String> ALLOWED_SORT_FIELDS = Arrays.asList("id", "bla");

    public static boolean isValidSortBy(String sortBy) {
        return ALLOWED_SORT_FIELDS.contains(sortBy);
    }

    public List<MyTask> getOverDueTasks(LocalDateTime now) {
        return taskRepository.findByDueDateBeforeAndCompletedFalse(now);
    }


    public List<MyTask> getTasksByCompleted(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    public Page<MyTask> getTasksByCompleted(boolean completed, org.springframework.data.domain.Pageable pageable) {
        return taskRepository.findByCompleted(completed, pageable);
    }

    @Override
    public MyTask createTask(MyTask task) {
        return taskRepository.save(task);
    }

    @Override
    public List<MyTask> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public MyTask updateTask(Long id, String description, LocalDateTime dueDate, MyPriority priority) {
        MyTask task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        if (description != null) {
            task.setDescription(description);
        }
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }
        if (priority != null) {
            task.setPriority(priority);
        }
        return taskRepository.save(task);
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
        return taskRepository.findAll(PageRequest.of(page, size, sort));
    }
}
