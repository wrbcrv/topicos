package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime dataConclusao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;

    @ManyToOne
    private Projeto projeto;

    @OneToMany(mappedBy = "tarefa")
    private Set<TarefaUsuario> usuarios;

    @OneToMany(mappedBy = "tarefa")
    private Set<TarefaCategoria> categorias;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Set<TarefaUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<TarefaUsuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<TarefaCategoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<TarefaCategoria> categorias) {
        this.categorias = categorias;
    }
}
