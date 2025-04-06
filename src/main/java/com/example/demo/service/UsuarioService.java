package com.example.demo.service;

import com.example.demo.dto.TarefaResDTO;
import com.example.demo.dto.UsuarioReqDTO;
import com.example.demo.dto.UsuarioResDTO;

import java.util.List;

public interface UsuarioService {

    UsuarioResDTO create(UsuarioReqDTO dto);
    UsuarioResDTO getById(Long id);
    List<UsuarioResDTO> getAll();
    UsuarioResDTO update(Long id, UsuarioReqDTO dto);
    void delete(Long id);
    UsuarioResDTO findByEmail(String email, String senha);
    List<TarefaResDTO> getTarefasByUsuarioId(Long usuarioId);
}
