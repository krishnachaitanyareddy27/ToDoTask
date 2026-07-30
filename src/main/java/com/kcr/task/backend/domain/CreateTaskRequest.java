package com.kcr.task.backend.domain;

import com.kcr.task.backend.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {
}
