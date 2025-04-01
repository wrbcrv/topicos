package com.example.demo.security;

import com.example.demo.model.Usuario;

public interface JwtService {
    String generate(Usuario usuario);
}
