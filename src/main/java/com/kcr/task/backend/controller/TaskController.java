package com.kcr.task.backend.controller;


import com.kcr.task.backend.domain.CreateTaskRequest;
import com.kcr.task.backend.domain.UpdateTaskRequest;
import com.kcr.task.backend.domain.dto.CreateTaskRequestDto;
import com.kcr.task.backend.domain.dto.TaskDto;
import com.kcr.task.backend.domain.dto.UpdateTaskRequestDto;
import com.kcr.task.backend.domain.entity.Task;
import com.kcr.task.backend.mapper.TaskMapper;
import com.kcr.task.backend.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }
    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
    ){
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTaskRequestDto);
        Task task = taskService.create(createTaskRequest);
        TaskDto createdTaskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(createdTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks(){
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return ResponseEntity.ok(taskDtos);
    }
    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
             @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto

    ){
        UpdateTaskRequest  updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path = "/{taskId}")
    public void deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
    }

}
