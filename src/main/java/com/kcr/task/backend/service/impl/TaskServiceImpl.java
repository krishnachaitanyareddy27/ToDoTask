package com.kcr.task.backend.service.impl;

import com.kcr.task.backend.domain.CreateTaskRequest;
import com.kcr.task.backend.domain.UpdateTaskRequest;
import com.kcr.task.backend.domain.entity.Task;
import com.kcr.task.backend.domain.entity.TaskStatus;
import com.kcr.task.backend.exception.TaskNotFoundException;
import com.kcr.task.backend.service.TaskService;
import com.kcr.task.backend.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;


@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository=taskRepository;
    }

    public Task create(CreateTaskRequest request) {
        Instant now = Instant.now();
        Task task = new Task(
          null, request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.dueDate());
        task.setPriority(request.priority());
        task.setUpdated(Instant.now());

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
