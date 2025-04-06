package com.example.demo.dto;

import com.example.demo.model.Usuario;

public record UsuarioResDTO(Long id, String nome, String email) {

    public static UsuarioResDTO valueOf(Usuario usuario) {
        return new UsuarioResDTO(
            usuario.getId(),
            usuario.getNome(),
            usuario.getEmail()
        );
    }
}
