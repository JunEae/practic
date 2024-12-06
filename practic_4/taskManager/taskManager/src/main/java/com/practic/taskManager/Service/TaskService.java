package com.practic.taskManager.Service;

import com.practic.taskManager.Models.Account;
import com.practic.taskManager.Models.Task;
import com.practic.taskManager.Repositorу.AccountRepository;
import com.practic.taskManager.Repositorу.TaskRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Transactional
    public Task createTask(@Valid Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Long id, @Valid Task taskDetails) {
        Task task = getTaskById(id);
        task.setTitle(taskDetails.getTitle());
        task.setBody(taskDetails.getBody());
        task.setCompleted(taskDetails.getCompleted());
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    public void reassignTask(Long taskId, Long targetAccountId) {
        Task task = getTaskById(taskId);
        Account targetAccount = accountRepository.findById(targetAccountId)
                .orElseThrow(() -> new RuntimeException("Target account not found"));

        if (task.getAccount().getId().equals(targetAccountId)) {
            throw new RuntimeException("Task is already assigned to this account");
        }

        task.setAccount(targetAccount);
        taskRepository.save(task);
    }

}