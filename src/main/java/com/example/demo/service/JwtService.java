package com.example.demo.service;

import com.example.demo.model.Usuario;

import io.jsonwebtoken.Claims;

public interface JwtService {
    String generate(Usuario usuario);
    Claims validate(String token);
}
