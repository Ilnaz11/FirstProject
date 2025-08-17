package ru.baymukhametov.FirstProject.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.FirstProject.Entity.MyTask;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<MyTask, Long> {
    List<Task> findByCompleted(boolean completed);

    Page<Task> findByCompleted(boolean completed, Pageable pageable);
}
