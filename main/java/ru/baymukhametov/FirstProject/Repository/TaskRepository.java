package ru.baymukhametov.FirstProject.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.FirstProject.Entity.MyPriority;
import ru.baymukhametov.FirstProject.Entity.MyTask;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<MyTask, Long> {
    List<MyTask> findByCompletedTrue();
    Page<MyTask> findByCompletedFalse(Pageable pageable);
    MyTask findByDueDateBeforeAndCompletedFalse(LocalDateTime now);
    long countByDueDateBeforeAndCompletedFalse(LocalDateTime now);
}