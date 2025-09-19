package ru.baymukhametov.FirstProject.service;

import org.springframework.data.domain.Pageable;
import ru.baymukhametov.FirstProject.Entity.MyPriority;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TaskService {
    MyTask createTask(MyTask myTask);
    List<MyTask> getAllTasks();
    void deleteTask(Long id);
    MyTask toggleCompleted(Long id);
    Page<MyTask> getSortedTasks(int page, int size, String sortBy, String direction);
    MyTask updateTask(Long id, String description, LocalDateTime dueDate, MyPriority priority);
    List<MyTask> getTasksByCompleted(boolean completed);
    Page<MyTask> getTasksByCompleted(boolean completed, Pageable pageable);
}