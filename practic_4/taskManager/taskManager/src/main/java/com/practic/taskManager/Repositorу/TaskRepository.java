package com.practic.taskManager.Repositorу;

import com.practic.taskManager.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAccountId(Long accountId);
}