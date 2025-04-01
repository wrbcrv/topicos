package com.example.demo.service;

import com.example.demo.dto.UsuarioReqDTO;
import com.example.demo.dto.UsuarioResDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UsuarioResDTO create(UsuarioReqDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        return UsuarioResDTO.valueOf(repository.save(usuario));
    }

    @Override
    public UsuarioResDTO getById(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return UsuarioResDTO.valueOf(usuario);
    }

    @Override
    public List<UsuarioResDTO> getAll() {
        return repository.findAll().stream()
                .map(UsuarioResDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResDTO update(Long id, UsuarioReqDTO dto) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));

        return UsuarioResDTO.valueOf(repository.save(usuario));
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

    @Override
    public UsuarioResDTO findByEmail(String email, String senha) {
        Usuario usuario = repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(senha, usuario.getSenha())) {
            throw new RuntimeException("Email ou senha inválidos");
        }

        return UsuarioResDTO.valueOf(usuario);
    }
}
