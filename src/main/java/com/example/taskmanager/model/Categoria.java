package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private Set<TarefaCategoria> tarefas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<TarefaCategoria> getTarefas() {
        return tarefas;
    }

    public void setTarefas(Set<TarefaCategoria> tarefas) {
        this.tarefas = tarefas;
    }

    // Getters e setters
}
