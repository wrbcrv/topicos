package com.example.demo.dto;

import com.example.demo.model.Tarefa;

import java.time.LocalDateTime;

public record TarefaResDTO(
    Long id,
    String titulo,
    String descricao,
    LocalDateTime dataCriacao,
    LocalDateTime dataConclusao,
    String status,
    String prioridade,
    String responsavelNome,
    String categoriaNome
) {

    public static TarefaResDTO valueOf(Tarefa tarefa) {
        return new TarefaResDTO(
            tarefa.getId(),
            tarefa.getTitulo(),
            tarefa.getDescricao(),
            tarefa.getDataCriacao(),
            tarefa.getDataConclusao(),
            tarefa.getStatus() != null ? tarefa.getStatus().name() : null,
            tarefa.getPrioridade() != null ? tarefa.getPrioridade().name() : null,
            tarefa.getResponsavel() != null ? tarefa.getResponsavel().getNome() : null,
            tarefa.getCategoria() != null ? tarefa.getCategoria().getNome() : null
        );
    }
}
