package com.kcr.task.backend.mapper;

import com.kcr.task.backend.domain.CreateTaskRequest;
import com.kcr.task.backend.domain.UpdateTaskRequest;
import com.kcr.task.backend.domain.dto.CreateTaskRequestDto;
import com.kcr.task.backend.domain.dto.TaskDto;
import com.kcr.task.backend.domain.dto.UpdateTaskRequestDto;
import com.kcr.task.backend.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);

    TaskDto toDto(Task task);

}
