package com.example.taskmanager.model;

import jakarta.persistence.*;

@Entity
public class TarefaCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Tarefa tarefa;

    @ManyToOne
    private Categoria categoria;

    // Getters e setters
}
