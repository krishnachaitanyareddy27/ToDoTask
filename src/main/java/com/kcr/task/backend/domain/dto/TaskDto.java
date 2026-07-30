package com.kcr.task.backend.domain.dto;

import com.kcr.task.backend.domain.entity.TaskPriority;
import com.kcr.task.backend.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
