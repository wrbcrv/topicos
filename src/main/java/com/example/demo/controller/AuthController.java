package com.example.demo.controller;

import com.example.demo.dto.LoginReqDTO;
import com.example.demo.dto.LoginResDTO;
import com.example.demo.model.Usuario;
import com.example.demo.security.JwtService;
import com.example.demo.service.UsuarioService;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AuthController(UsuarioService usuarioService, JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO request) {
        try {
            Usuario usuario = usuarioRepository.findByEmail(request.email())
                    .orElseThrow(() -> new RuntimeException("Email inválido"));

            String token = jwtService.generate(usuario);

            return ResponseEntity.ok(new LoginResDTO(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Credenciais inválidas: " + e.getMessage());
        }
    }
}
