package com.example.taskmanager.service;

import com.example.taskmanager.dto.request.TaskRequestDTO;
import com.example.taskmanager.dto.response.TaskResponseDTO;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskResponseDTO create(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        return TaskResponseDTO.valueOf(repository.save(task));
    }

    public List<TaskResponseDTO> findAll() {
        return repository.findAll().stream().map(TaskResponseDTO::valueOf).collect(Collectors.toList());
    }

    public TaskResponseDTO findById(Long id) {
        return repository.findById(id).map(TaskResponseDTO::valueOf).orElse(null);
    }

    public TaskResponseDTO update(Long id, TaskRequestDTO dto) {
        return repository.findById(id).map(task -> {
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setDueDate(dto.getDueDate());
            return TaskResponseDTO.valueOf(repository.save(task));
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}