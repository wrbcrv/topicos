package com.example.demo.dto;

import com.example.demo.model.Prioridade;
import com.example.demo.model.Status;

import java.time.LocalDateTime;

public record TarefaReqDTO(
    String titulo,
    String descricao,
    LocalDateTime dataCriacao,
    LocalDateTime dataConclusao,
    Status status,
    Prioridade prioridade,
    Long responsavelId,
    Long categoriaId
) {}
