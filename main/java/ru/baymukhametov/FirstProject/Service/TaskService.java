package ru.baymukhametov.FirstProject.Service;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import ru.baymukhametov.FirstProject.Repository.TaskRepository;

import java.util.List;

@Service
public interface TaskService {

    MyTask createTask(MyTask task);
    List<MyTask> getAllTasks();
    void deleteTask(Long id);
    MyTask toggleCompleted(Long id);
    Page<MyTask> getSortedTasks(int page, int size, String sortBy, String direction);
    //Добавить сортировку и фильтрацию. Добавить параметр completed=true/false для фильтрации по выполненности
}
