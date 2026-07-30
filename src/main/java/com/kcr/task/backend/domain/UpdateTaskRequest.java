package com.kcr.task.backend.domain;

import com.kcr.task.backend.domain.entity.TaskPriority;
import com.kcr.task.backend.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
