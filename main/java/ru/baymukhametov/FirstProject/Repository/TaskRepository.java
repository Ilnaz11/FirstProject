package ru.baymukhametov.FirstProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baymukhametov.FirstProject.Entity.MyTask;

@Repository
public interface TaskRepository extends JpaRepository<MyTask, Long> {
}
