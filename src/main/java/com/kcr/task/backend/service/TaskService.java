package com.kcr.task.backend.service;

import com.kcr.task.backend.domain.CreateTaskRequest;
import com.kcr.task.backend.domain.UpdateTaskRequest;
import com.kcr.task.backend.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task create(CreateTaskRequest request);

    List<Task> listTasks();

    Task updateTask(UUID taskId, UpdateTaskRequest request);

    void deleteTask(UUID taskId);
}
