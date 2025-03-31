package com.example.taskmanager.dto.request;

import java.time.LocalDateTime;

public class TaskRequestDTO {
    private String title;
    private String description;
    private LocalDateTime dueDate;

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDueDate() { return dueDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }
}