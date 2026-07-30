package com.kcr.task.backend.mapper.impl;

import com.kcr.task.backend.domain.CreateTaskRequest;
import com.kcr.task.backend.domain.UpdateTaskRequest;
import com.kcr.task.backend.domain.dto.CreateTaskRequestDto;
import com.kcr.task.backend.domain.dto.TaskDto;
import com.kcr.task.backend.domain.dto.UpdateTaskRequestDto;
import com.kcr.task.backend.domain.entity.Task;
import com.kcr.task.backend.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority()
        );
    }
}
