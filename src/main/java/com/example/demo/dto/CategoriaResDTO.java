package com.example.demo.dto;

import com.example.demo.model.Categoria;

public record CategoriaResDTO(
    Long id,
    String nome
) {
    public static CategoriaResDTO valueOf(Categoria categoria) {
        return new CategoriaResDTO(categoria.getId(), categoria.getNome());
    }
}
