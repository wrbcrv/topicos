package com.example.taskmanager.controller;

import com.example.taskmanager.dto.request.TaskRequestDTO;
import com.example.taskmanager.dto.response.TaskResponseDTO;
import com.example.taskmanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponseDTO create(@RequestBody TaskRequestDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<TaskResponseDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO update(@PathVariable Long id, @RequestBody TaskRequestDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}